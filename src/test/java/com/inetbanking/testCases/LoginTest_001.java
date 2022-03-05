package com.inetbanking.testCases;

import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

import java.io.IOException;
import org.testng.Assert;

public class LoginTest_001 extends BaseTest
{
	@Test
	public void loginTest() throws InterruptedException, IOException
	{
		
		logger.info("URL is opened");
				
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserID(userID);
		logger.info("Entered UserID");
	
		lp.setPassword(password);
		logger.info("Entered Password");
		
		lp.clickLogin();
		logger.info("Clicked LoginButton");
		
		String Title = driver.getTitle();
		System.out.println("Title= " +Title);
		
		if(Title.equals("Guru99 Bank Manager HomePage"))
		{
			Assert.assertTrue(true);
			logger.info("Testcase passed");
		}
		else
		{
			captureScreen(driver,"loginTest");
			Assert.assertTrue(false);
			logger.info("Testcase failed");
		}
	}
}
