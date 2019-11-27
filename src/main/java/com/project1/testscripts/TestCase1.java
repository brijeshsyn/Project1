package com.project1.testscripts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.wma.framework.common.InitTest;
import com.wma.framework.report.TestRailAndExtentReporter;

public class TestCase1 extends InitTest {
	
	private TestRailAndExtentReporter tcLogger;
	
	@Test
	@Parameters({"RunId", "CaseID", "TCTitle"})
	public void test1(@Optional String runId, @Optional String caseId, @Optional String tcTitle) {
		tcLogger = TestRailAndExtentReporter.getInstance(config(), tcTitle, "Sample Test Case");
		WebDriver driver = getWebDriver();
		tcLogger.log(Status.INFO, "Step 1");
		tcLogger.log(Status.PASS, "Step 1 PASSED");
		tcLogger.log(Status.INFO, "Step 2");
		tcLogger.log(Status.PASS, "Step 2 PASSED");
		tcLogger.log(Status.INFO, "Step 3");
		tcLogger.log(Status.FAIL, "Step 3 FAILED");
		quitDriver();
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("After Class...");
		tcLogger.flush();
	}
	
}
