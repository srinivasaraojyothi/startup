package zycus.assignment.utilities;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporterNG implements IReporter {
	private ExtentReports extent;

	@Override
	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		extent = new ExtentReports(outputDirectory + File.separator + "ExtentReport.html", true);


		for (ISuite suite : suites) {
			Map<String, ISuiteResult> result = suite.getResults();
			// log.info(result.keySet()+"---from report");
			for (ISuiteResult r : result.values()) {
				ITestContext context = r.getTestContext();
				// log.info();

				buildTestNodes(context.getPassedTests(), LogStatus.PASS);
				buildTestNodes(context.getFailedTests(), LogStatus.FAIL);
				buildTestNodes(context.getSkippedTests(), LogStatus.SKIP);
			}
		}
		// extent.config().
		extent.flush();
		extent.close();
	}

	private void buildTestNodes(IResultMap tests, LogStatus status) {
		ExtentTest test;

		if (tests.size() > 0) {
			ArrayList<ITestResult> list = new ArrayList<ITestResult>(tests.getAllResults());
	        Collections.sort(list, new Comparator<ITestResult>() {
	            public int compare(ITestResult o1, ITestResult o2) {
	                return Integer.compare(((AbstactcommonClass) o1.getMethod().getInstance()).getOrder(), ((AbstactcommonClass) o2.getMethod().getInstance()).getOrder());
	            }
	    });
	        System.out.println(list);
			for (ITestResult result : list) {
				
				// log.info(result.getMethod()+" :method name");
				AbstactcommonClass obj1 = (AbstactcommonClass) result.getMethod().getInstance();
				// log.info(obj1.getTestStep());
				test = extent.startTest(obj1.getTestStep());
				// test.getTest().getStartedTime() =
				// getTime(result.getStartMillis());
				// test.getTest().endedTime = getTime(result.getEndMillis());

				for (String group : result.getMethod().getGroups())
					test.assignCategory(group);
				// log.info(tests.size()+" :
				// ----------------------------is the test
				// size------------------");
				String message=null ;
				// log.info(message+" : is the message");

				if (result.getThrowable() != null)
					message = result.getThrowable().getMessage();

				test.log(status, message);
				// test.log(LogStatus.INFO, "<a href='linkToLogFile'><span
				// class='label info'>"+"Test Step:
				// "+obj1.getTestStep()+"</span></a>");

				test.log(LogStatus.INFO,
						"<table style=\"font-family:arial;font-size:14px;border-collapse:collapse width:200px\">"
								+ "<tr>" 
								+ "<th style=\"width:40%\" border: 1px solid black>" + "Expected HTTP Code" + "</th>"
								+ "<th border: 1px solid black>" + "Expected Data Result" + "</th>" + "</tr>" + "<tr>"
								+ "<td>" + obj1.getExpectedresult() + "</td>"
								+ "<td>" + obj1.getExpectedDATAresult() + "</td>" + "</tr></table>");

				extent.endTest(test);
			}
		}
	}
}