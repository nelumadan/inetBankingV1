package com.inetbanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig
{
	Properties prop;
	
	public ReadConfig()
	{
		
		File src = new File("./Configuration/config.properties");
		
		try
		{
			FileInputStream fis = new FileInputStream(src);
			prop = new Properties();
			prop.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is " +e.getMessage());
		}
	}
	
	public String getChromepath()
	{
		String chromepath=prop.getProperty("chromepath");
		return chromepath;
	}
	
	public String getURL()
	{
		String URL=prop.getProperty("baseURL");
		return URL;
	}
	
	public String getUserID()
	{
		String UID=prop.getProperty("userID");
		return UID;
	}
	
	public String getpassword()
	{
		String password=prop.getProperty("password");
		return password;
	}
}
