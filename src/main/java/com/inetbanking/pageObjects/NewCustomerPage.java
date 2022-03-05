package com.inetbanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCustomerPage
{
WebDriver ldriver;
	
	public NewCustomerPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'New Customer')]")
	@CacheLookup
	WebElement newCustLink;
	
	@FindBy(name="name")
	@CacheLookup
	WebElement name;
	
	@FindBy(xpath="//input[@name='rad1' and @value='m']")
	@CacheLookup
	WebElement male;
	
	@FindBy(xpath="//input[@name='rad1' and @value='f']")
	@CacheLookup
	WebElement female;
	
	@FindBy(id="dob")
	@CacheLookup
	WebElement dateOfBirth;
	
	@FindBy(name="addr")
	@CacheLookup
	WebElement address;
	
	@FindBy(name="city")
	@CacheLookup
	WebElement city;
	
	@FindBy(name="state")
	@CacheLookup
	WebElement state;
	
	@FindBy(name="pinno")
	@CacheLookup
	WebElement pin;
	
	@FindBy(name="telephoneno")
	@CacheLookup
	WebElement phoneNo;
	
	@FindBy(name="emailid")
	@CacheLookup
	WebElement email;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement password;
	
	@FindBy(name="sub")
	@CacheLookup
	WebElement submitButton;
	
	public void clickNewCustomer()
	{
		newCustLink.click();
	}
	
	public void setCustName(String cname)
	{
		name.sendKeys(cname);
	}
	
	public void setCustGender(String cgender)
	{
		if(cgender.equals("male"))
		{
			male.click();
		}
		else
		{
			female.click();
		}
	}
	
	public void setCustDateOfBirth(String mm,String dd,String yyyy)
	{
		dateOfBirth.sendKeys(mm);
		dateOfBirth.sendKeys(dd);
		dateOfBirth.sendKeys(yyyy);
	}
	
	public void setCustAddress(String caddress)
	{
		address.sendKeys(caddress);
	}
	
	public void setCustCity(String ccity)
	{
		city.sendKeys(ccity);
	}
	
	public void setCustState(String cstate)
	{
		state.sendKeys(cstate);
	}
	
	public void setCustPin(String cpin)
	{
		pin.sendKeys(cpin);
	}
	
	public void setCustPhoneNo(String cphone)
	{
		phoneNo.sendKeys(cphone);
	}
	
	public void setCustEmail(String cemail)
	{
		email.sendKeys(cemail);
	}
	
	public void setCustPassword(String pass)
	{
		password.sendKeys(pass);
	}
	
	public void clicksubmitButton()
	{
		submitButton.click();
	}
}
