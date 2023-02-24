package com.orangehrm.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.Pages.DashboardPage;
import com.orangehrm.Pages.LoginPage;
import com.orangehrm.Pages.PersonalDetailsPage;
import com.orangehrm.utilities.DataProviders;
import com.oranhrm.base.BaseClass;

public class DashboardPageTest extends BaseClass{
	//public WebDriver driver;
	LoginPage login;
	DashboardPage dash;
	PersonalDetailsPage personal;
	
	@Test(dataProvider="LoginData",dataProviderClass=DataProviders.class)
	public void validatePersonalDetails(String email, String pwd) throws InterruptedException {
		//test=extent.createTest("validatePersonalDetails");
		login= new LoginPage();
		dash= new DashboardPage();
		//login.ValidateLogin(prop.getProperty("username"), prop.getProperty("password"));
		login.ValidateLogin(email,pwd);
		Thread.sleep(5000);
	    personal=dash.myInfoTest();
	    Thread.sleep(5000);
		String expectedURL="https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/7";
		String actualURL=getDriver().getCurrentUrl();
		Assert.assertEquals(actualURL, expectedURL);
		
		
	}
	
	
	

}
