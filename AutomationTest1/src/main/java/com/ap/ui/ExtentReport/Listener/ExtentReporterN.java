package com.ap.ui.ExtentReport.Listener;
import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.testng.IReporter;
import org.testng.IResultMap;
import org.testng.ISuite;
import org.testng.ISuiteResult;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;


public class ExtentReporterN implements IReporter{
	private ExtentReports extent;
	

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite>suites, 
		String outputDirectory){
	
	extent = new ExtentReports(outputDirectory + File.separator
			+ "Extent.html", true); // output directory is a result pass ,fail and skipped
	//we used boolean for empty 
	for(ISuite suite : suites){  // we used for loop// its conditonal operator..
		Map<String, ISuiteResult>result = suite.getResults();// map obtain a key value, it cannot be duplicate, its a interface and it will map to one locations
	
	for(ISuiteResult r : result.values()){// its containing another loop
		ITestContext context =r.getTestContext();
		
		buildTestNo(context.getPassedTests(), LogStatus.PASS);//once u get result, u just capture
		buildTestNo(context.getFailedTests(), LogStatus.FAIL);
		buildTestNo(context.getSkippedTests(), LogStatus.SKIP);
			
	}
}
extent.flush();// get the result and asap add with html file
extent.close();// after that u closed the result

}
// we don't want to share this report to any other project so its private
private void buildTestNo(IResultMap tests, LogStatus status){// create a private contractor
	ExtentTest test;
	
	if(tests.size()>0){
		for (ITestResult result : tests.getAllResults()){ 
			test = extent.startTest(result.getMethod().getMethodName());
			
			test.setStartedTime(getTime(result.getStartMillis()));// to see how long it will take
			test.setEndedTime(getTime(result.getEndMillis())); // 
			
			for(String group : result.getMethod().getGroups()) // group them in pass, fail and skipped to organize
				test.assignCategory(group);
			
			if(result.getThrowable() !=null){  // null is empty string             // to see there are any error to log
				test.log(status, result.getThrowable());
			}else{
				test.log(status, "Test" + status.toString().toLowerCase() + "ed");
				
		}
			extent.endTest(test);
			
	}
}
}
private Date getTime(long millis){ // private constr it's local machine time
	Calendar calender = Calendar.getInstance();
	calender.setTimeInMillis(millis);
	return calender.getTime();
	
	
}
}
