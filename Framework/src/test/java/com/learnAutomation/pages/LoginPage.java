package com.learnAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(how=How.NAME,using="username") WebElement uname;
	@FindBy(how=How.NAME,using="password") WebElement pass;
	@FindBy(how=How.XPATH,using=".//input[@value='Login']") WebElement loginButton;
	
	public void loginToCRM(String usernameApp, String passwordApp)
	{
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
		}
		uname.sendKeys(usernameApp);
		pass.sendKeys(passwordApp);
		loginButton.click();
		
	}

}
