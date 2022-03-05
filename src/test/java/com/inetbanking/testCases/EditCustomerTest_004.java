package com.inetbanking.testCases;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.EditCustomerPage;
import com.inetbanking.pageObjects.LoginPage;



public class EditCustomerTest_004 extends BaseTest
{
	@Test
	public void editCustomerTest()
	{
		logger.info("URL is opened");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserID(userID);
		logger.info("UserId is provided");
		
		lp.setPassword(password);
		logger.info("Password is provided"); 
		
		lp.clickLogin();
		logger.info("Clicked LoginButton");
		
		EditCustomerPage ecp = new EditCustomerPage(driver);
		ecp.editCustomer();
		logger.info("Clicked Editcustomer");
		
		String custid = randomNum();
		ecp.setCustomerId(custid);
		ecp.clickSubmitButton();
	
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();
		driver.switchTo().defaultContent();
		lp.clickLogout();
		driver.switchTo().alert().accept();//close alert on logout
		driver.switchTo().defaultContent();
		System.out.println(alertText);
	}
}
