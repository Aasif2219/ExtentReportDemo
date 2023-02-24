package com.orangehrm.testcases;

import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.Pages.DashboardPage;
import com.orangehrm.Pages.LoginPage;
import com.orangehrm.utilities.DataProviders;
import com.oranhrm.base.BaseClass;


public class LoginPageTest extends BaseClass {
	//public WebDriver getDriver();
	LoginPage login;
	DashboardPage dash;
	@Test
	public void orangeHRMLogoTest() {
	login= new LoginPage();
	//test=extent.createTest("orangeHRMLogoTest");
	boolean status=login.validateLogo();
	Assert.assertTrue(false);	
		
	}
	
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void orangeHRMLoginTest(String email, String pwd) {
	login= new LoginPage();
	dash= new DashboardPage();
	//test=extent.createTest("orangeHRMLoginTest");
	//login.ValidateLogin(prop.getProperty("username"), prop.getProperty("password"));
	login.ValidateLogin(email,pwd);
	getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	boolean dashLogo=dash.validateDashLogo();
	Assert.assertTrue(dashLogo);
	
	}
	
}
