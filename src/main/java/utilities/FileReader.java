package utilities;

import utilities.PropertyFileReader;

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