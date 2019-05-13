package se.krogrannet;

import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.apache.log4j.Logger;

import se.krogrannet.xml.ExportImportImpl;

public class ExportForMeos {

	public static void main( String[] args ) {
		
		Logger log = Logger.getLogger( ExportForMeos.class );
		
		ExportImportImpl exportImportImpl;
		try {
			exportImportImpl = new ExportImportImpl();
			String payLoad = exportImportImpl.exportForMeos();
			exportImportImpl.createXMLFile( payLoad );
		} catch (Exception e) {
			log.info("ExportForMeos :", e);
		}
	}
}
