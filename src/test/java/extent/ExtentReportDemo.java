package extent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
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

import ExtentBase.BaseClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemo extends BaseClass {
	
	
	
	@Test
	public void orangeHRMTitleTest() {
	test=extent.createTest("orangeHRMTitleTest");
	String actTitle=driver.getTitle();	
	Assert.assertEquals(actTitle, "OrangeHRM");
	}
	
	@Test
	public void orangeHRMLogoTest() {
	test=extent.createTest("orangeHRMLogoTest");
	
	boolean status=driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
	Assert.assertTrue(false);
		
		
	}
	
	@Test
	public void orangeHRMLoginTest() {
	test=extent.createTest("orangeHRMLoginTest");
		
    driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
    driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	boolean dashLogo=driver.findElement(By.xpath("//img[@alt='client brand banner']")).isDisplayed();
	Assert.assertTrue(dashLogo);
	
	}
	
}
