package se.krogrannet.xml;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.sql.*;

import se.krogrannet.jdbc.JdbcHelper;
import se.krogrannet.xsd.IOF.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.log4j.Logger;

public class ExportImportImpl implements ExportImportService {

	private Marshaller marshaller;
	private JAXBContext context;
	private final String contextPath = "se.krogrannet.xsd.IOF";
	
	private static Logger log = Logger.getLogger( ExportImportImpl.class );
	
	public ExportImportImpl() throws JAXBException {
		context = JAXBContext.newInstance( contextPath );
		
		marshaller = context.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
		marshaller.setProperty( "jaxb.encoding", "UTF-8");
	}
	
	@Override
	public void exportForMeos() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		   
		try {
			JdbcHelper jdbcHelper = new JdbcHelper();
		
			con = jdbcHelper.getConnection();
			
		      stmt = con.createStatement();
		      String sql;
		      //sql = "SELECT anm_id FROM anmalan";
		      
		      StringBuffer strbSQL = new StringBuffer();
		      Event event = new Event();
		      strbSQL.setLength(0);
		      strbSQL.append("select tav_id, tav_ar from tavling where tav_aktiv_flag='Y' order by tav_id desc");
		      
		      sql = strbSQL.toString();
		      log.info("exportForMeos: sql 1=" + sql);
		      rs = stmt.executeQuery(sql);
		      
		      if( rs.next() ) {
		    	  int tavId = rs.getInt("tav_id");
		    	  int tavAr = rs.getInt("tav_ar");
		    	  
		    	  Id id = new Id();
		    	  id.setValue( "" + tavId );
		    	  event.setId( id );
		    	  event.setName( "Krogrännet " + tavAr );
		      }
		      rs.close();
		      
		      strbSQL.setLength(0);
		      strbSQL.append("select anm_del_id, anm_startnr, del_koen, del_fornamn, del_efternamn, ");
		      strbSQL.append("del_gatuadress, del_postnr, del_postadress, del_emailadress, ");
		      strbSQL.append("lan_namn, anm_kla_id, kla_namn, kla_info,");
		      strbSQL.append("kla_kortnamn, klu_namn, anm_klu_id ");
		      strbSQL.append("from deltagare, anmalan, land, klass, klubb ");
		      strbSQL.append("where del_id = anm_del_id and del_lan_id = lan_id ");
		      strbSQL.append("and anm_kla_id = kla_id and anm_klu_id = klu_id ");
		      strbSQL.append("and anm_startnr is not null order by anm_startnr");
		      
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
		      String fileHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		      String loadableString = fileHeader + writer.toString();
		      
		      //File file = new File("krogrannet_IOF3.xml");
				 
		      //if( !file.exists() ) {
		    //	  	file.createNewFile();
		     // }
	 
		   //   FileWriter fw = new FileWriter( file.getAbsoluteFile()) ;
		      //BufferedWriter bw = new BufferedWriter(fw);
		      
		      BufferedWriter bw = new BufferedWriter
		    		    (new OutputStreamWriter(new FileOutputStream("krogrannet_IOF3.xml"),"UTF-8"));
		      
		      bw.write( loadableString );
		      bw.flush();
		      bw.close();
		}
		catch ( Exception e ) {
			e.printStackTrace();
			if( con != null ) {
				try {
					con.close();
				}
				catch( Exception e2 ) {
					e2.printStackTrace();
				}
			}
		}
		finally {
			if( rs != null ) {
				try {
					rs.close();
				}
				catch( Exception e ) {
					System.out.println("Could not close rs");
				}
			}
			if( stmt != null ) {
				try {
					stmt.close();
				}
				catch( Exception e ) {
					System.out.println("Could not close stmt");
				}
			}
			if( con != null ) {
				try {
					con.close();
				}
				catch( Exception e ) {
					System.out.println("Could not close con");
				}
			}
		}
	}

}
