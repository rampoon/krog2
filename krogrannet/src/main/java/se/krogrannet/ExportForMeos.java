package se.krogrannet;

import javax.xml.bind.JAXBException;

import se.krogrannet.xml.ExportImportImpl;

public class ExportForMeos {

	public static void main( String[] args ) {
		
		ExportImportImpl exportImportImpl;
		try {
			exportImportImpl = new ExportImportImpl();
			exportImportImpl.exportForMeos();
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
