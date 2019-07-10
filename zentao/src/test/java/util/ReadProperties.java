package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



/**
 * 
 * @author renjy
 */
public class ReadProperties {

	/**
	 * 
	 * @param folder
	 * @param filename
	 * @param propname
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static String getprop(String folder, String filename, String propname) throws FileNotFoundException, IOException {
		Properties props = new Properties();
		props.load(new FileInputStream("./test-classes/"+ folder +"/"+filename+".properties"));
		 String str = props.getProperty(propname);
		return str;
		
	}
	
	
	
	
}