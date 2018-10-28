package utilities;

import utilities.PropertyFileReader;

/**
 * @author rahulr
 * File Reader class to perform file read operation
 */
public class FileReader {

	private static FileReader fileReaderManager = new FileReader();
	private static PropertyFileReader propertyFileReader;

	private FileReader() {
	}

	 public static FileReader getInstance( ) {
	      return fileReaderManager;
	 }

	 public PropertyFileReader getConfigReader() {
		 return (propertyFileReader == null) ? new PropertyFileReader() : propertyFileReader;
	 }
}