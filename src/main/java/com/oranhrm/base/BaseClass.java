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
import org.testng.IReporter;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.orangehrm.Pages.LoginPage;
import com.orangehrm.utilities.Reporting;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public WebDriver driver;
	
	Reporting report;
	
	public Properties prop;
	public LoginPage login;
	
	
	
	@BeforeMethod
	public void setup() throws InterruptedException {
		readConfig();
	    WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get(prop.getProperty("url"));
	    Thread.sleep(5000);
			
	}
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
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
	
	public static String getScreenshot(WebDriver driver,String screenshotName) throws IOException {
		String dateName=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		
		String destination=System.getProperty("user.dir")+"/screenshots" +screenshotName+dateName+".png";
	    File finalDestination=new File(destination);
	    FileUtils.copyFile(source, finalDestination);
	    return destination;
	}
	


}
