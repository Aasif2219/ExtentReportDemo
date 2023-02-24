package com.oranhrm.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.orangehrm.Pages.LoginPage;
import com.orangehrm.utilities.ExtentManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public Properties prop;

	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	
	@BeforeSuite
	public void loadConfig() {
		ExtentManager.setExtent();
	}
	public static WebDriver getDriver() {
		// Get Driver from threadLocalmap
		return driver.get();
	}
	
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		readConfig();
	    WebDriverManager.chromedriver().setup();
	    WebDriverManager.chromedriver().setup();
		// Set Browser to ThreadLocalMap
		driver.set(new ChromeDriver());
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
	    Thread.sleep(5000);
			
	}
	
	@AfterMethod
	public void teardown() {
		
		getDriver().quit();
	}
	
	public void readConfig() {
		try {
			prop=new Properties();
			FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void afterSuite() {
		ExtentManager.endReport();
	}
	
}
