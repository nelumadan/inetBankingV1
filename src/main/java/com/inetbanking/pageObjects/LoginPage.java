package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(name="uid")
	@CacheLookup
	WebElement userID;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement password;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement loginButton;
	
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	@CacheLookup
	WebElement logoutButton;
	
	public void setUserID(String uid)
	{
		userID.clear();
		userID.sendKeys(uid);
	}
	
	public void setPassword(String pass)
	{
		password.clear();
		password.sendKeys(pass);
	}
	
	public void clickLogin()
	{
		loginButton.click();
	}
	
	public void clickLogout()
	{
		logoutButton.click();
	}
}
