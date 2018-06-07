package zycus.assignment.common;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import zycus.assignment.core.GET;
import zycus.assignment.utilities.AbstactcommonClass;
import zycus.assignment.utilities.TestEnvironement;

/*
 * Project: Zycus Assignment
 * Author: Srinivasa Rao
 * Description: Function for GET by customerId.
 */
public class GETbyCustomerId extends AbstactcommonClass {
	Properties properties = new Properties();

	static Logger log = Logger.getLogger(GETbyCustomerId.class.getName());


	//String pageFlag = null;
	String TestCase;
	String TestStep;
	String apiurl;
	String payLoad;
	String expectedHTTPMessage;
	String expectedOutput;
	String oAuthToken;

	public GETbyCustomerId(String TestCase,String TestStep, String apiurl, String expectedHTTPMessage, String expectedOutput,
			 int order) {
		this.TestCase=TestCase;
		this.TestStep = TestStep;
		this.apiurl = apiurl;
	//	this.payLoad = payLoad;
		this.expectedHTTPMessage = expectedHTTPMessage;
		this.expectedOutput = expectedOutput;
		//this.oAuthToken = oAuthToken;
		this.order = order;
	}

	@Test
	public void getbyCustomerId()   {


		try{
			String customerInfoFile=TestEnvironement.baseURL().get("inputFiles")+TestEnvironement.baseURL().get("customerIdInfo");
			String url=TestEnvironement.baseURL().get("BASE_URL").toString()+apiurl;
	FileInputStream fis=new FileInputStream(new File (customerInfoFile));
	
	JSONObject customerDetails=new JSONObject(IOUtils.toString(fis).toString());
		JSONObject jsonOfHttpMessage=new JSONObject(expectedHTTPMessage);
		JSONObject jsonOfHttpEntityMessage=new JSONObject(expectedOutput);
		Response getResponse=new GET().get(url.replace("/ID", "/"+customerDetails.getString("customerguid").toString()));
		Assert.assertEquals(Integer.toString(getResponse.getStatus()), jsonOfHttpMessage.get("HttpsStatusCode").toString());
		Assert.assertEquals(getResponse.getStatusInfo().toString(), jsonOfHttpMessage.get("HttpsStatusInfo").toString());
		JSONObject jsonOfmessageBody=new JSONObject(getResponse.readEntity(String.class));
		
if(jsonOfmessageBody.has("code")&&jsonOfmessageBody.has("message")){

if(jsonOfmessageBody.get("code").toString().equalsIgnoreCase(jsonOfHttpEntityMessage.get("code").toString())
		&&jsonOfmessageBody.get("message").toString().equalsIgnoreCase(jsonOfHttpEntityMessage.get("message").toString())){
	Assert.assertTrue(true);
	
}
else{
	Assert.assertTrue(false);
}
}

else if(jsonOfmessageBody.has("status")){
	if(jsonOfmessageBody.get("status").toString().equalsIgnoreCase(jsonOfHttpEntityMessage.get("status").toString())){
		Assert.assertTrue(true);
		
	}
	else{
		Assert.assertTrue(false);
	}
	
	
}
		}catch(Exception e){
			System.out.println(e);
			
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
