package se.krogrannet.util;

import java.util.Properties;

public class Utilities {

	public void listSystemUtilities() {
		Properties properties = System.getProperties();

		properties.forEach(
				(key,value)
				->
				System.out.println(key + "=" +value)	
		);
	}
}
