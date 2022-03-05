package com.inetbanking.testCases;

import java.io.IOException;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;
import com.inetbanking.utilities.ExcelUtil;

public class LoginTestDDT_002 extends BaseTest
{
	@Test(dataProvider="LoginData")
	public void loginDDT(String userID,String pwd) throws InterruptedException, IOException
	{
		logger.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserID(userID);
		logger.info("UserId is provided");
		
		lp.setPassword(pwd);
		logger.info("Password is provided");
			
		lp.clickLogin();
		logger.info("Clicked LoginButton");
	
		if(isAlertPresent()==true)
		{
			captureScreen(driver,"loginTestDDT");
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();		
			Assert.assertTrue(false);
			logger.warn("Login failed");
		}
		else
		{
			Assert.assertTrue(true);
			logger.info("Login passed");
			lp.clickLogout();
			driver.switchTo().alert().accept();//close alert on logout
			driver.switchTo().defaultContent();
		}
	}
	
	public boolean isAlertPresent()//user defined method created to check alert is present or not
	{
		try
		{
			driver.switchTo().alert();
			return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	
	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException
	{
		String path = "C:\\Users\\nelu_\\eclipse-workspace\\inetBankingV1\\Configuration\\inetBankingLoginData.xlsx";
		
		ExcelUtil xlutil = new ExcelUtil(path);
		int totalrows = xlutil.getRowCount("Sheet1");
		int totalcols = xlutil.getCellCount("Sheet1", 1);
		
		String loginData[][]=new String[totalrows][totalcols];
		
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcols;j++)
			{
				loginData[i-1][j] = xlutil.getCellData("Sheet1", i, j);
			}
		}
		
		return loginData;
	}
	
}
