package zycus.assignment.common;

import java.io.FileInputStream;
import java.util.Properties;

import javax.ws.rs.client.Entity;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import javax.ws.rs.core.Response;
import zycus.assignment.core.POST;
import zycus.assignment.utilities.AbstactcommonClass;
import zycus.assignment.utilities.ExcelDataTest;
import zycus.assignment.utilities.TestEnvironement;

/*
 * Project: ZYCUS Assignment
 * Author: Srinivasa Rao
 * Description: Function for creating customer profile.
 */
public class POSTCreateCustomer extends AbstactcommonClass {
	Properties properties = new Properties();
	static Logger log = Logger.getLogger(POSTCreateCustomer.class.getName());
	
	ExcelDataTest edt = new ExcelDataTest();
	String TestCase;
	String TestStep;
	String apiurl;
	String payLoadFileName;
	String expectedHTTPcode;
	String expectedOutput;
	String oAuthToken;

	public POSTCreateCustomer(String TestCase,String TestStep, String apiurl, String payLoadFileName, String expectedHTTPcode,
			String expectedOutput,  int order) {
		this.TestCase= TestCase;
		this.TestStep = TestStep;
		this.apiurl = apiurl;
		this.payLoadFileName = payLoadFileName;
		this.expectedHTTPcode = expectedHTTPcode;
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
		
		Response postResponse=new POST().post(url, entityString);
		
		Assert.assertEquals(Integer.toString(postResponse.getStatus()), expectedHTTPcode);

		
		//System.out.println(url+"   :   "+customerCreationPayLoadFile);
		Assert.assertTrue(true);
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
		return expectedHTTPcode;
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
