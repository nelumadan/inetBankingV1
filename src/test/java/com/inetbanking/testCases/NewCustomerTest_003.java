package com.inetbanking.testCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.pageObjects.NewCustomerPage;

public class NewCustomerTest_003 extends BaseTest
{
	@Test
	public void newCustomerTest() throws InterruptedException, IOException
	{
		logger.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserID(userID);
		logger.info("UserId is provided");
		
		lp.setPassword(password);
		logger.info("Password is provided");
		
		lp.clickLogin();
		logger.info("Clicked LoginButton");

		NewCustomerPage ncp = new NewCustomerPage(driver);
		ncp.clickNewCustomer();
		logger.info("Clicked Newcustomer");

		ncp.setCustName("Neelam");
		ncp.setCustGender("female");
		ncp.setCustDateOfBirth("10", "28","1980");
		Thread.sleep(3000);
		ncp.setCustAddress("Terrace Hills");
		ncp.setCustCity("San Jose");
		ncp.setCustState("CA");
		ncp.setCustPin("943555");
		ncp.setCustPhoneNo("1235460000");
		String email = randomString()+"@gmail.com";
		ncp.setCustEmail(email);
		ncp.setCustPassword("abcdef");
		logger.info("Customer details are provided");
		
		ncp.clicksubmitButton();
		
		Thread.sleep(3000);
		
		boolean result = driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(result == true)
		{
			Assert.assertTrue(true);
			logger.info("Testcase is passed");
		}
		else
		{
			captureScreen(driver,"newCustomerTest");
			Assert.assertTrue(false);
			logger.info("Testcase is failed");
		}
	}
}
