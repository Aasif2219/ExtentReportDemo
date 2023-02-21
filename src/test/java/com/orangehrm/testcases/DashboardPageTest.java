package com.orangehrm.testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.Pages.DashboardPage;
import com.orangehrm.Pages.LoginPage;
import com.orangehrm.Pages.PersonalDetailsPage;
import com.oranhrm.base.BaseClass;

public class DashboardPageTest extends BaseClass{
	//public WebDriver driver;
	@Test
	public void validatePersonalDetails() {
		//test=extent.createTest("validatePersonalDetails");
		LoginPage login= new LoginPage();
		DashboardPage dash= new DashboardPage();
		login.ValidateLogin(prop.getProperty("username"), prop.getProperty("password"));
		getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PersonalDetailsPage personal=dash.myInfoTest();
		String expectedURL="https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/7";
		String actualURL=getDriver().getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL);
		
		
	}
	
	
	

}
