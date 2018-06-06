package zycus.assignment.common;

import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

import zycus.assignment.utilities.AbstactcommonClass;
import zycus.assignment.utilities.ExcelDataTest;

/*
 * Project: ZYCUS Assignment
 * Author: Srinivasa Rao
 * Description: Function for creating customer profile.
 */
public class POSTCreateCustomer extends AbstactcommonClass {
	Properties properties = new Properties();
	static Logger log = Logger.getLogger(POSTCreateCustomer.class.getName());

	ExcelDataTest edt = new ExcelDataTest();
	String TestStep;
	String apiurl;
	String payLoadFileName;
	String expectedHTTPcode;
	String expectedOutput;
	String oAuthToken;

	public POSTCreateCustomer(String TestStep, String apiurl, String payLoadFileName, String expectedHTTPcode,
			String expectedOutput,  int order) {
		this.TestStep = TestStep;
		this.apiurl = apiurl;
		this.payLoadFileName = payLoadFileName;
		this.expectedHTTPcode = expectedHTTPcode;
		this.expectedOutput = expectedOutput;
		this.order = order;
	}

	@Test
	public void postCreatingSG() throws IOException {}

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
}
