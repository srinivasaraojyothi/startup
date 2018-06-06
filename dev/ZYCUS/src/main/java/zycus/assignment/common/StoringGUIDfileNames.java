package zycus.assignment.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class StoringGUIDfileNames {
	Properties properties = new Properties();
	@Test
	public File[] storingGUIDfileNames() throws IOException{
		FileInputStream fileInput = new FileInputStream(new File("src/main/resources/DataFilesLocations.properties"));
		properties.load(fileInput);
		File file=new File(properties.getProperty("filePath"));
		File[] listOfFiles=file.listFiles();

	    return listOfFiles;

		
	}

}
