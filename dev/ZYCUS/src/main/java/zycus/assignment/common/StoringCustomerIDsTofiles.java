package zycus.assignment.common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import org.json.JSONObject;
import org.testng.annotations.Test;

public class StoringCustomerIDsTofiles {
	
	@Test
	public void storingCustomerIDsTofiles(File fileName, String DataToWrite) throws IOException{
try{
	JSONObject customerId=new JSONObject();
	customerId.put("customerguid", DataToWrite);
	
		//File[] listOfFiles=file.listFiles();
		OutputStreamWriter writeToFile=new OutputStreamWriter(new FileOutputStream(fileName));
		
		BufferedWriter bufWriter = new BufferedWriter(writeToFile);
		bufWriter.write(customerId.toString());
		bufWriter.flush();
}catch(Exception e){
	System.out.println(e);
	
}

		
	}

}
