package zycus.assignment.common;

import java.io.File;
import java.io.FileInputStream;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import zycus.assignment.core.POST;
import zycus.assignment.utilities.AbstactcommonClass;
import zycus.assignment.utilities.ExcelDataTest;
import zycus.assignment.utilities.StoringCustomerIDsTofiles;
import zycus.assignment.utilities.TestEnvironement;

/*
 * Project: ZYCUS Assignment
 * Author: Srinivasa Rao
 * Description: Function for creating customer profile.
 */
public class POSTCreateCustomer extends AbstactcommonClass {
	
	static Logger log = Logger.getLogger(POSTCreateCustomer.class.getName());
	StoringCustomerIDsTofiles stroringIDstoFiles=new StoringCustomerIDsTofiles();
	ExcelDataTest edt = new ExcelDataTest();
	String TestCase;
	String TestStep;
	String apiurl;
	String payLoadFileName;
	String expectedHTTPMessage;
	String expectedOutput;
	String oAuthToken;

	public POSTCreateCustomer(String TestCase,String TestStep, String apiurl, String payLoadFileName, String expectedHTTPMessage,
			String expectedOutput,  int order) {
		this.TestCase= TestCase;
		this.TestStep = TestStep;
		this.apiurl = apiurl;
		this.payLoadFileName = payLoadFileName;
		this.expectedHTTPMessage = expectedHTTPMessage;
		this.expectedOutput = expectedOutput;
		this.order = order;
	}
	@Test()
	public void postCreateCustomer(){
		try{
		//System.out.println("********* retry ************");
		String url=TestEnvironement.baseURL().get("BASE_URL").toString()+apiurl;
		String customerCreationPayLoadFile=TestEnvironement.baseURL().get("inputFiles")+payLoadFileName;
		FileInputStream fis=new FileInputStream(customerCreationPayLoadFile);
		String inputStreamString=IOUtils.toString(fis);
		Entity<String> entityString=Entity.json(inputStreamString);
		System.out.println(entityString.getEntity());
		JSONObject jsonOfHttpMessage=new JSONObject(expectedHTTPMessage);
		JSONObject jsonOfHttpEntityMessage=new JSONObject(expectedOutput);
		Response postResponse=new POST().post(url, entityString);
		
		
		Assert.assertEquals(Integer.toString(postResponse.getStatus()), jsonOfHttpMessage.get("HttpsStatusCode").toString());
		Assert.assertEquals(postResponse.getStatusInfo().toString(), jsonOfHttpMessage.get("HttpsStatusInfo").toString());
		String[] splitHeaderInfo = postResponse.getLocation().toString().split("/");
if(!postResponse.getHeaderString("Location").isEmpty()){
		stroringIDstoFiles.storingCustomerIDsTofiles(new File(TestEnvironement.baseURL().get("inputFiles")+"customerID.json"), splitHeaderInfo[splitHeaderInfo.length-1].toString());
		//String messageBody=postResponse.readEntity(String.class);

}
else{
	JSONObject jsonOfmessageBody=new JSONObject(postResponse.readEntity(String.class));
	if(jsonOfmessageBody.get("code").toString().equalsIgnoreCase(jsonOfHttpEntityMessage.get("code").toString())
	&&jsonOfmessageBody.get("message").toString().equalsIgnoreCase(jsonOfHttpEntityMessage.get("message").toString())){
		Assert.assertTrue(true);
		
	}
	else{
		Assert.assertTrue(false);
	}
	
}

		}
		catch(Exception e){
			log.info(e);
		}
		
	}
	


	@Override
	public int getOrder() {
		return order;
	}

	@Override
	public String getTestStep() {
		return TestStep;
	}

	@Override
	public String getExpectedresult() {
		return expectedHTTPMessage;
	}

	@Override
	public String getExpectedDATAresult() {
		return expectedOutput;
	}

	@Override
	public String getTestCase() {
		
		return TestCase;
	}
}
