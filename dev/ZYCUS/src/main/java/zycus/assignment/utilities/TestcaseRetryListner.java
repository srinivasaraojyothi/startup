package zycus.assignment.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class TestcaseRetryListner implements IRetryAnalyzer{
	private int retry_count=0;
	private int max_retry_count=2;

	@Override
	public boolean retry(ITestResult result) {
		if(retry_count<max_retry_count){
			System.out.println(" here is the result: "+result.getName());
			retry_count=retry_count+1;
		return true;
		}
		else{
			return false;	
		}
	}

}
