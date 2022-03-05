package com.inetbanking.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.inetbanking.utilities.ReadConfig;

public class BaseTest 
{
	ReadConfig readconfig = new ReadConfig();
	
	public String baseURL=readconfig.getURL();
	public String userID=readconfig.getUserID();
	public String password=readconfig.getpassword();
	public String chromePath=readconfig.getChromepath();
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentSparkReporter sparkReporter;
	public static ExtentTest test;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String browserName) throws InterruptedException
	{
		logger = Logger.getLogger("inetbankingV1");
		PropertyConfigurator.configure("./Configuration/log4j.properties");

		if (browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", chromePath);
			driver = new ChromeDriver();
		}
		else if(browserName.equals("safari"))
		{
			driver = new SafariDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.get(baseURL);	
		driver.manage().window().maximize();
		
		WebElement frame1 = driver.findElement(By.id("ccpa-consent-notice"));
		driver.switchTo().frame(frame1);	
		driver.findElement(By.id("saveAndExit")).click();
	}
	
	@AfterClass
	public void teardown()
	{
		driver.close();
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver,String testname) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + testname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	//user defined method to generate random string which can be used to generate new email each time the test is run
	public String randomString()
	{
		String randomString = RandomStringUtils.randomAlphabetic(8);
		return randomString;
	}
		
	//user defined method to generate random number which can be used
	public String randomNum()
	{
		String randomNum = RandomStringUtils.randomNumeric(4);
		return randomNum;
	}
}
