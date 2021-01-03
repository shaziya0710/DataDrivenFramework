package org.training.base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.training.utility.Utility;

public class DriverInstance {
	public WebDriver driver;
	@BeforeMethod
	public void initiateDriverInstance() throws Exception
	{
		if(Utility.fetchPropertyValue("browserName").toString().equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver","./Driver/chromedriver.exe");
			 driver=new ChromeDriver();
		}
		else if(Utility.fetchPropertyValue("browserName").toString().equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else{
			throw new Exception("Browser is not correct");
		}
		driver.get(Utility.fetchPropertyValue("applicaionURL").toString());
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}
}

