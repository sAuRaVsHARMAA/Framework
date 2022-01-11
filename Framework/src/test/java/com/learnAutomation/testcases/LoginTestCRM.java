package com.learnAutomation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.learnAutomation.pages.BaseClass;
import com.learnAutomation.pages.LoginPage;
import com.learnAutomation.utility.BrowserFactory;

public class LoginTestCRM extends BaseClass {
	
	@Test(priority=1)
	public void loginApp()
	{
		logger=report.createTest("Login to CRM");
		LoginPage loginpage=PageFactory.initElements(driver, LoginPage.class);
		logger.info("Application Started");
		loginpage.loginToCRM(excel.getStringData("Sheet1", 0, 0), excel.getStringData("Sheet1", 0, 1));
		logger.pass("Login Success");
		
		
	}
	@Test(priority=2)
	public void loginApp1()
	{
		logger=report.createTest("Logout to CRM");
		
		logger.fail("Logout failed");

}
}
