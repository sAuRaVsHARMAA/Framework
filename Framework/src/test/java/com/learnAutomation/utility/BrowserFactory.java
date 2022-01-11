package com.learnAutomation.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {
	
	public static WebDriver startBrowser(WebDriver driver, String browserName, String appURL)
	{
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		    driver=new ChromeDriver();
		    
		}
		
		else if(browserName.equalsIgnoreCase("FireFox"))
		{
			System.setProperty("webdriver.firefox.driver", "./Driver/firefoxdriver.exe");
			driver=new FirefoxDriver();	
		}
			
		else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.firefox.driver", "./InternetExplorerDriver.exe");
			driver=new InternetExplorerDriver();	
		}
		
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	    
	}
	
	public static void quitDriver(WebDriver driver)
	{
		driver.quit();
	}

}
