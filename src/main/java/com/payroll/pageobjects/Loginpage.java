package com.payroll.pageobjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.payroll.Action.Action;
import com.payroll.baseclass.baseclass;
import com.payroll.utilities.Excelcode;

public class Loginpage extends baseclass {

	Action act = new Action();
	public static WebDriver driver;
	@FindBy(id = "loginform-username")
	WebElement username;
	@FindBy(id = "loginform-password")
	WebElement password;
	@FindBy(name = "login-button")
	WebElement login;
	@FindBy(linkText = "reset it")
	WebElement resetit;
	@FindBy(id = "LoginForm[rememberMe]")
	WebElement rememberme;
	@FindBy(xpath = "//img[@alt='logo']")
	WebElement logoverified;
	@FindBy(xpath = "//p[normalize-space()='Incorrect username or password.']")
	WebElement incorrectuserpass;
	@FindBy(xpath = "//p[normalize-space()='Username cannot be blank.']")
	WebElement blankcheck;
	@FindBy(xpath = "//p[normalize-space()='Incorrect username or password.']")
	WebElement validation;
	@FindBy(xpath="//input[@id='passwordresetrequestform-email']")
	WebElement email;
	@FindBy(xpath="//a[normalize-space()='Cancel']")
	WebElement cancel;
	@FindBy(xpath="//h1[normalize-space()='Login']")
	WebElement textlogin;
	@FindBy(xpath="//a[normalize-space()='Dashboard']")
	WebElement payroll;
	public Loginpage(WebDriver driver) {
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
	public WebElement uname() {
		return username;
	}

	public WebElement pwd() {
		return password;

	}

	public WebElement loginButton() {
		act.explicitWait(driver, login, 10);
		return login;

	}

	public WebElement reset() {
		return resetit;

	}

	public WebElement rememberme() {
		return rememberme();

	}

	public void loginfn(String usr,String psw) throws IOException {
		// String s= Excelcode.readStringData(4, 0);
		act.type(username,usr);
		act.type(password, psw);
		act.click(driver, login);
	}

	public boolean getLogoCheck() {
		boolean logo = logoverified.isDisplayed();
		return logo;
	}

	public String assertValidationMsg() {
		String psw = incorrectuserpass.getText();
		return psw;
	}
	public String getBlankValidationMsg() {
		String blank = blankcheck.getText();
		return blank;
	}
	public String getValidationMsg() {
		String usr = validation.getText();
		return usr;
	}
	public String getTextLogin() {
		String usr = textlogin.getText();
		return usr;
	}
	public String getTextPayRoll() {
		String usr = payroll.getText();
		return usr;
	}
}
