package se.krogrannet.xml;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.Properties;

import se.krogrannet.jdbc.JdbcHelper;
import se.krogrannet.xsd.IOF.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.log4j.Logger;

public class ExportImportImpl implements ExportImportService {

	private Marshaller marshaller;
	private JAXBContext context;
	private final static String KROG_CONTEXTPATH = "se.krogrannet.xsd.IOF";
	private final static String KROG_PROPERTY_ENCODING = "jaxb.encoding";
	private final static String KROG_ENCODING_UTF8 = "UTF8";
	private final static String KROG_FILE_NAME = "krogrannet_IOF3.xml";
	private final static String KROG_FILE_HEADER = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
	private final static String KROG_KEY_OUTFILEPATH = "OutfilePath";
	private static Logger log = Logger.getLogger( ExportImportImpl.class );
	private static String outfilePath;
	
	public ExportImportImpl() throws JAXBException {
		context = JAXBContext.newInstance( KROG_CONTEXTPATH );
		Properties properties = System.getProperties();

		outfilePath = (String)properties.get(KROG_KEY_OUTFILEPATH);
		
		marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
		marshaller.setProperty( KROG_PROPERTY_ENCODING, KROG_ENCODING_UTF8);
	}
	
	@Override
	public String exportForMeos() throws JAXBException, ClassNotFoundException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String payLoad = null;
		   
		try {
			JdbcHelper jdbcHelper = new JdbcHelper();
		
			con = jdbcHelper.getConnection();
			
		      stmt = con.createStatement();
		      
		      StringBuffer strbSQL = new StringBuffer();
		      Event event = new Event();
		      strbSQL.setLength(0);
		      strbSQL.append("select tav_id, tav_ar from tavling where tav_aktiv_flag='Y' order by tav_id desc");
		      
		      String sql = strbSQL.toString();
		      log.info("exportForMeos: sql 1=" + sql);
		      rs = stmt.executeQuery(sql);
		      
		      if( rs.next() ) {
		    	  int tavId = rs.getInt("tav_id");
		    	  int tavAr = rs.getInt("tav_ar");
		    	  
		    	  Id id = new Id();
		    	  id.setValue( "" + tavId );
		    	  event.setId( id );
		    	  event.setName( "Krogrännet " + tavAr );
		    	  log.debug("exportForMeos: aktiv år=" + tavAr); 
		      }
		      rs.close();
		      
		      strbSQL.setLength(0);
		      strbSQL.append("select anm_del_id, anm_startnr, del_koen, del_fornamn, ");
		      strbSQL.append("del_efternamn, del_gatuadress, del_postnr, del_postadress, ");
		      strbSQL.append("del_emailadress, lan_namn, anm_kla_id, kla_namn, kla_info, ");
		      strbSQL.append("kla_kortnamn, klu_namn, anm_klu_id from anmalan "); 
		      strbSQL.append("inner join deltagare on del_id = anm_del_id "); 
		      strbSQL.append("left outer join land on lan_id = del_lan_id ");
		      strbSQL.append("inner join klass on kla_id = anm_kla_id ");
		      strbSQL.append("left outer join klubb on klu_id = anm_klu_id ");
		      strbSQL.append("where anm_startnr is not null order by anm_startnr");
		      
		      sql = strbSQL.toString();
		      log.info("exportForMeos: sql 2=" + sql);  
		      rs = stmt.executeQuery(sql);

		      EntryList entryList = new EntryList();
		      
	          entryList.setEvent( event );
	          entryList.setIofVersion("3.0");
	          
		      while(rs.next()) {
		          int anmId  = rs.getInt( "anm_del_id" );
		          int anm_startnr = rs.getInt( "anm_startnr" );
		          String forName = rs.getString( "del_fornamn" );
		          String lastName = rs.getString( "del_efternamn" );
		          String koen = rs.getString( "del_koen" );
		          int anmKlaId = rs.getInt( "anm_kla_id" );
		          String klaKortNamn = rs.getString( "kla_kortnamn" );
		          String klaInfo = rs.getString( "kla_info" );
		          int anmKluId = rs.getInt( "anm_klu_id" );
		          String klubbNamn = rs.getString( "klu_namn" );
		           
		          Person person = new Person();
		          PersonName personName = new PersonName();
		          personName.setGiven( forName );
		          personName.setFamily( lastName );
		          person.setName( personName );
		          person.setSex( koen );
		          PersonEntry personEntry = new PersonEntry();
		          personEntry.setPerson( person );
		          
		          Id anmalningsId = new Id();
		          anmalningsId.setValue( "" + anmId );    
		          personEntry.setId( anmalningsId );

		          Id classId = new Id();
		          se.krogrannet.xsd.IOF.Class clazz = new se.krogrannet.xsd.IOF.Class();
		          classId.setValue( "" + anmKlaId );
		          clazz.setId( classId );
		          clazz.setName( klaInfo );       
		          personEntry.getClazz().add( clazz );
		          
		          Organisation organisation = new Organisation();
		          Id orgId = new Id();
		          orgId.setValue( "" + anmKluId );
		          organisation.setId( orgId );
		          organisation.setName( klubbNamn );
		          personEntry.setOrganisation( organisation );
		          
		          entryList.getPersonEntry().add( personEntry );
		          
		      }
		      
		      StringWriter writer = new StringWriter();

		      marshaller.marshal( entryList, writer );
		      payLoad =  KROG_FILE_HEADER + writer.toString();
		}
		catch ( SQLException e ) {
			log.info("exportForMeos:", e);
			e.printStackTrace();
			if( con != null ) {
				try {
					con.close();
				}
				catch( Exception e2 ) {
					log.info("exportForMeos:", e2);
				}
			}
		}
		finally {
			if( rs != null ) {
				try {
					rs.close();
				}
				catch( Exception e ) {
					log.info("exportForMeos Could not close rs:", e);
				}
			}
			if( stmt != null ) {
				try {
					stmt.close();
				}
				catch( Exception e ) {
					log.info("exportForMeos Could not close stmt:", e);
				}
			}
			if( con != null ) {
				try {
					con.close();
				}
				catch( Exception e ) {
					log.info("exportForMeos Could not close con:", e);
					System.out.println("Could not close con");				}
			}
		}
	    return payLoad;
	}
	public void createXMLFile( String payload ) throws IOException {
	      BufferedWriter bw = new BufferedWriter
	    		    (new OutputStreamWriter(new FileOutputStream(new File(outfilePath + "/" + KROG_FILE_NAME)), KROG_ENCODING_UTF8 ));
	      
	      bw.write( payload );
	      bw.flush();
	      bw.close();
	}
}
