package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage
{
	WebDriver ldriver;
	
	public EditCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'Edit Customer')]")
	@CacheLookup
	WebElement editCustLink;
	
	@FindBy(name="cusid")
	@CacheLookup
	WebElement custId;
	
	@FindBy(name="AccSubmit")
	@CacheLookup
	WebElement submitButton;
	
	public void editCustomer()
	{
		editCustLink.click();
	}
	
	public void setCustomerId(String custid)
	{
		custId.sendKeys(custid);
	}
	
	public void  clickSubmitButton()
	{
		submitButton.click();
	}
}
