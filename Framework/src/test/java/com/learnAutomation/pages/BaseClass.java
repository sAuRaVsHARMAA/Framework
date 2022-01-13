package com.learnAutomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.beust.jcommander.Parameter;
import com.learnAutomation.utility.BrowserFactory;
import com.learnAutomation.utility.ConfigDataProvider;
import com.learnAutomation.utility.ExcelDataProvider;
import com.learnAutomation.utility.Helper;

public class BaseClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite()
	{
		excel=new ExcelDataProvider();
		config=new ConfigDataProvider();
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"./Reports/FreeCRM"+Helper.getCurrentDate()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
	}
	@Parameters({"browser","urlToBeTested"})
	@BeforeClass
	public void startUp(String browser, String urlToBeTested)
	{
		//driver=BrowserFactory.startBrowser(driver, config.getBrowser(), config.getStagingURL());
		driver=BrowserFactory.startBrowser(driver, browser, urlToBeTested);
	}
	
	@AfterClass
	public void tearDown()
	{
		BrowserFactory.quitDriver(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			
			try {
				logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			try {
				logger.pass("Test passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenShot(driver)).build());
			} catch (IOException e) {
				System.out.println(e.getMessage());
		}
		}
		report.flush();
	}
	

}
