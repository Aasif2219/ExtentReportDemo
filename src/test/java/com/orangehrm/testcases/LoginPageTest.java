package com.orangehrm.testcases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.Pages.DashboardPage;
import com.orangehrm.Pages.LoginPage;
import com.oranhrm.base.BaseClass;


public class LoginPageTest extends BaseClass {
	
	
	@Test
	public void orangeHRMLogoTest() {
    LoginPage login= new LoginPage(driver);
	//test=extent.createTest("orangeHRMLogoTest");
	boolean status=login.validateLogo();
	Assert.assertTrue(false);	
		
	}
	
	@Test
	public void orangeHRMLoginTest() {
	LoginPage login= new LoginPage(driver);
	DashboardPage dash= new DashboardPage(driver);
	//test=extent.createTest("orangeHRMLoginTest");
	login.ValidateLogin(prop.getProperty("username"), prop.getProperty("password"));
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	boolean dashLogo=dash.validateDashLogo();
	Assert.assertTrue(dashLogo);
	
	}
	
}
