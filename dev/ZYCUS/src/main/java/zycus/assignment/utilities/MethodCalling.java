package zycus.assignment.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.testng.annotations.Factory;

import zycus.assignment.common.POSTCreateCustomer;

public class MethodCalling {
	ArrayList<Cell> testDataSheetSarray = new ArrayList<Cell>();
	List<Object> methodObjects = new ArrayList<Object>();
	ExcelDataTest edt = new ExcelDataTest();

	static Logger log = Logger.getLogger(MethodCalling.class);
	Properties properties = new Properties();
	public static String testCaseName = "";
	static int FunctionOrder = 0;
	//OauthTokenExtract authToken = new OauthTokenExtract();

	@Factory
	public Object[] methodCalling() throws IOException {
		FileInputStream propertiesFile = new FileInputStream(
				new File("src/main/resources/DataFilesLocations.properties"));
		FileInputStream logFile = new FileInputStream(new File("src/main/resources/log4j.properties"));
		properties.load(logFile);
		properties.load(propertiesFile);
		testDataSheetSarray.clear();
		methodObjects.clear();
		testDataSheetSarray = edt.urlsDataSheet();

		for (int testDataSheetSarrayIteration = 0; testDataSheetSarrayIteration <= testDataSheetSarray.size()
				- 1; testDataSheetSarrayIteration++) {


			String grade = testDataSheetSarray.get(testDataSheetSarrayIteration).toString();
			//System.out.println(testDataSheetSarray.get(testDataSheetSarrayIteration).toString()+"   <====>:  "+testDataSheetSarrayIteration );
			//log.info(testDataSheetSarray.get(testDataSheetSarrayIteration).toString()+"   <====>:  "+testDataSheetSarrayIteration);
			switch (grade) {
			case "POST":
				
				try {
					String testCase = testDataSheetSarray.get(testDataSheetSarrayIteration - 2).toString();
					String testStep = testDataSheetSarray.get(testDataSheetSarrayIteration - 1).toString();
					String apiurl = testDataSheetSarray.get(testDataSheetSarrayIteration + 1).toString();
					String payLoad = testDataSheetSarray.get(testDataSheetSarrayIteration + 2).toString();
					String expectedHTTPcode = new Integer(
							Integer.parseInt(testDataSheetSarray.get(testDataSheetSarrayIteration + 3).toString()))
									.toString();
					String expectedOutput = testDataSheetSarray.get(testDataSheetSarrayIteration + 4).toString();
					String[] apiurlSplitArray=apiurl.split("/");
					
if(apiurlSplitArray[apiurlSplitArray.length-1].equalsIgnoreCase("customers")){


					if (!payLoad.isEmpty()) {
						//System.out.println("*********Testing************");
						FunctionOrder=FunctionOrder+1;
						
						methodObjects.add(new POSTCreateCustomer(testCase,testStep, apiurl, payLoad, expectedHTTPcode,
								expectedOutput,  FunctionOrder));
						
						
					} else if (payLoad.isEmpty() != true) {}
					
}
					
					

				} catch (Exception e) {

					e.printStackTrace();
				}
				break;
		
			case "GET":

				String testCase = testDataSheetSarray.get(testDataSheetSarrayIteration - 2).toString();
				String testStep = testDataSheetSarray.get(testDataSheetSarrayIteration - 1).toString();
				String apiurl = testDataSheetSarray.get(testDataSheetSarrayIteration + 1).toString();
				String payLoad = testDataSheetSarray.get(testDataSheetSarrayIteration + 2).toString();
				String expectedHTTPcode = new Integer(
						Integer.parseInt(testDataSheetSarray.get(testDataSheetSarrayIteration + 3).toString()))
								.toString();
				String expectedOutput = testDataSheetSarray.get(testDataSheetSarrayIteration + 4).toString();

				try {} catch (Exception e) {

					e.printStackTrace();
				}
				break;
			default:
				grade = "Invalid command";
				break;

			}

		}

		return methodObjects.toArray();

	}
}
