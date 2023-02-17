package com.orangehrm.Pages;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	
	@FindBy(xpath="//img[@alt='client brand banner']")
	WebElement dashboardlogo;
	
	@FindBy(xpath="//span[normalize-space()='My Info']")
	WebElement myInfo;
	
	public DashboardPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
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
