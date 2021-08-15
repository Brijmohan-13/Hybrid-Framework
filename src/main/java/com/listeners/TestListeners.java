package com.listeners;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.base.TestBase;

// 7 methods of listener
//here in Hybrid framework SOP statements are replaced by Logger
//SOP statements are limited to Console only, where as Loggers  are available in file as well

public class TestListeners implements ITestListener{
	
	private static Logger log=Logger.getLogger(TestListeners.class);
	public void onFinish(ITestContext arg0) {
		log.info("Suite has executed successfully");		
	}

	public void onStart(ITestContext arg0) {
		log.info("Suite is ready to start the execution");		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onTestFailure(ITestResult result) {											//Screenshot for the failed test cases is required
		log.info("Test case failed with execution :"+result.getName());			
		TestBase.getScreenshot(TestBase.driver, result.getName()); 							//screenmethos called
	}

	public void onTestSkipped(ITestResult result) {
		log.info("Test case skipped with execution :"+result.getName());
	}

	public void onTestStart(ITestResult result) {
		log.info("Test case started with execution :"+result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		log.info("Test case succeeded with execution :"+result.getName());
	}

}
