package com.orangehrm.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.oranhrm.base.BaseClass;

public class LoginPage {
	
	@FindBy(xpath="//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginbtn;
	
	@FindBy(xpath="//img[@alt='company-branding']")
	WebElement loginLogo;
	
	public LoginPage(){
		PageFactory.initElements(BaseClass.getDriver(), this);	
	}
	
	public boolean validateLogo() {
		loginLogo.isDisplayed();
		return true;
	}
	
	public void ValidateLogin(String uname,String pass) {
		username.sendKeys(uname);
		password.sendKeys(pass);
		loginbtn.click();
	}
	
	

}
