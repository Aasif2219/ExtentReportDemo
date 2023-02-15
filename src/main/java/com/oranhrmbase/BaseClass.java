package com.oranhrmbase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest test;
	
	public WebDriver driver;
	
	@BeforeSuite
	public void setExtent() {
		htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/myReport.html");
		htmlReporter.config().setDocumentTitle("Automation Report");
		htmlReporter.config().setReportName("Functional Report");
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		extent.setSystemInfo("Hostname", "LoaclHost");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Tester Name", "Aasif");
		extent.setSystemInfo("Browser", "Chrome");
	}
	
	@AfterSuite
	public void endReport() {
		extent.flush();
	}
	@BeforeMethod
	public void setup() throws InterruptedException {
	    WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	    Thread.sleep(5000);
			
	}
	
	@AfterMethod
	public void result(ITestResult result) throws IOException {
		   
		if(result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Test Case Failed is" +result.getName());
			test.log(Status.FAIL, "Test Case Failed is" +result.getThrowable());
			
			String screenshotPath=BaseClass.getScreenshot(driver, result.getName());
			test.addScreenCaptureFromPath(screenshotPath);
		
		}else if(result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Test case skipped is" +result.getName());
			
		}else if(result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Test Case Passed is" +result.getName());
		}
		
		driver.quit();
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
