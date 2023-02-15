package com.orangehrmtest;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.oranhrmbase.BaseClass;


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
	Assert.assertTrue(status);
		
		
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
