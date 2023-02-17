package com.orangehrm.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.Pages.DashboardPage;
import com.orangehrm.Pages.LoginPage;
import com.orangehrm.Pages.PersonalDetailsPage;
import com.oranhrm.base.BaseClass;

public class DashboardPageTest extends BaseClass{
	
	@Test
	public void validatePersonalDetails() {
		//test=extent.createTest("validatePersonalDetails");
		LoginPage login= new LoginPage(driver);
		DashboardPage dash= new DashboardPage(driver);
		login.ValidateLogin(prop.getProperty("username"), prop.getProperty("password"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		PersonalDetailsPage personal=dash.myInfoTest();
		String expectedURL="https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/7";
		String actualURL=driver.getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL);
		
		
	}
	
	
	

}
