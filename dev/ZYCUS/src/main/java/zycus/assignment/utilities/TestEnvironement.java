package zycus.assignment.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;


public class TestEnvironement {
	
	static Logger log = Logger.getLogger(TestEnvironement.class.getName());
	public static Map<String,String> baseURL(){
		Map<String,String> envVeraibleMap=new HashMap<String,String>(); 
	  String BASE_URL=null;
	  
	//System.out.println(" -------inside get base url --------");
		Properties properties = new Properties();
		
		try {
			FileInputStream propertiesFile = new FileInputStream(
					new File("src/main/resources/DataFilesLocations.properties"));
			properties.load(propertiesFile);
			String env = System.getProperty("env");
			System.out.println(env+":   ----------------------------------------");
			//log.info("All the test cases will be executed on the user selected environment:  "+ env);
			if(env.equalsIgnoreCase("vnv")){
					
				envVeraibleMap.put("BASE_URL", properties.getProperty("baseURL_vnv"));
				envVeraibleMap.put("inputFiles", properties.getProperty("InputFilesLocation"));
				log.info(BASE_URL+ " : is the base url");
				
				return envVeraibleMap;
			}
			else if(env.equalsIgnoreCase("sqe")){
	
				envVeraibleMap.put("BASE_URL", properties.getProperty("baseURL_sqe"));
				envVeraibleMap.put("inputFiles", properties.getProperty("InputFilesLocation"));
				log.info(BASE_URL+ " : is the base url");
				
				return envVeraibleMap;
			}
		}catch(Exception e){
			log.info(e);
			
		}
		return envVeraibleMap;
	}
	public String testDataTab(){
		String testDataTabName=System.getProperty("test");
		//System.out.println(testDataTabName+"  :tab name");
/*		try{
			if(testDataTabName.equalsIgnoreCase("r")){
			return testDataTabName;	
			}
			else if(testDataTabName.equalsIgnoreCase("f")){
				
				return testDataTabName;	
			}
			
		}catch(Exception e){
			System.out.println(e);
		}*/
		System.out.println(testDataTabName+"  :Test case sheet");
		return testDataTabName;	
		
	}

}
