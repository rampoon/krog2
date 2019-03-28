package se.krogrannet.xml;

import javax.xml.bind.JAXBException;

public interface ExportImportService {

	public String exportForMeos() throws JAXBException, ClassNotFoundException;
}
