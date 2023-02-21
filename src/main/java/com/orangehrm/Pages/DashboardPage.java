package com.orangehrm.Pages;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oranhrm.base.BaseClass;

public class DashboardPage {
	
	@FindBy(xpath="//img[@alt='client brand banner']")
	WebElement dashboardlogo;
	
	@FindBy(xpath="//span[normalize-space()='My Info']")
	WebElement myInfo;
	
	public DashboardPage() {
		PageFactory.initElements(BaseClass.getDriver(), this);
	}

	public boolean validateDashLogo() {
		dashboardlogo.isDisplayed();
		return true;
	}
	
	public PersonalDetailsPage myInfoTest() {
		myInfo.click();
		return new PersonalDetailsPage();
	}
	
	

}
