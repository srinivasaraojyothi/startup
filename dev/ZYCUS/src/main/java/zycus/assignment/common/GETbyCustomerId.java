package zycus.assignment.common;

import java.io.IOException;
import java.util.Properties;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import zycus.assignment.utilities.AbstactcommonClass;

/*
 * Project: Zycus Assignment
 * Author: Srinivasa Rao
 * Description: Function for GET by customerId.
 */
public class GETbyCustomerId extends AbstactcommonClass {
	Properties properties = new Properties();

	static Logger log = Logger.getLogger(GETbyCustomerId.class.getName());


	String pageFlag = null;
	String TestCase;
	String TestStep;
	String apiurl;
	String payLoad;
	String expectedHTTPcode;
	String expectedOutput;
	String oAuthToken;

	public GETbyCustomerId(String TestCase,String TestStep, String apiurl, String expectedHTTPcode, String expectedOutput,
			 int order) {
		this.TestCase=TestCase;
		this.TestStep = TestStep;
		this.apiurl = apiurl;
	//	this.payLoad = payLoad;
		this.expectedHTTPcode = expectedHTTPcode;
		this.expectedOutput = expectedOutput;
		//this.oAuthToken = oAuthToken;
		this.order = order;
	}

	@Test
	public void getTranslations() throws IOException, ParserConfigurationException, SAXException {
		
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
