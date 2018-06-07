package zycus.assignment.utilities;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class FailTestCaseRetry implements IAnnotationTransformer {

	@Override
	public void transform(ITestAnnotation testAnnotation, Class testClass, Constructor testConstructor, Method testMethod) {
		
		//IRetryAnalyzer analyzer=testAnnotation.getRetryAnalyzer();
		//System.out.println(analyzer);
		//if(analyzer==null){
			
			testAnnotation.setRetryAnalyzer(TestcaseRetryListner.class);
		//}
	}
	

}
