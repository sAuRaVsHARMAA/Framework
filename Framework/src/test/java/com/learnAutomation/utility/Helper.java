package com.learnAutomation.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.utils.FileUtil;

public class Helper {
	
	
	WebDriver driver;
	
	public static String captureScreenShot(WebDriver driver)
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath=System.getProperty("user.dir")+"./Screenshots/FreeCRM"+getCurrentDate()+".png";
		
		try {
			org.openqa.selenium.io.FileHandler.copy(src, new File(screenshotPath));
			System.out.println("Screeshot Captured");
		} catch (IOException e) {
			System.out.println("Unable to capture screenshot"+e.getMessage());
	}
		return screenshotPath;

}
	public static String getCurrentDate()
	{
		DateFormat customFormat=new SimpleDateFormat("MM_dd_yyyy_HH_ss");
		Date currentdate=new Date();
		return customFormat.format(currentdate);		
		}
	
	
	
	
}
