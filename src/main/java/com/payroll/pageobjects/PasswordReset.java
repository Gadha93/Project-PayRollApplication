package com.payroll.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordReset {
	public static WebDriver driver;
	@FindBy(xpath="//input[@id='passwordresetrequestform-email']")
	WebElement email;
	@FindBy(xpath="//a[normalize-space()='Cancel']")
	WebElement cancel;
	@FindBy(xpath="//h1[normalize-space()='Login']")
	WebElement textlogin;
	public PasswordReset(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getEmail() {
		return email;
	}
	public WebElement getCancelButton() {
		return cancel;
	}
	public String getTextLogin() {
		String usr = textlogin.getText();
		return usr;
	}

}
