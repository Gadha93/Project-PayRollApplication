package com.payroll.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.payroll.baseclass.baseclass;

public class Clientupdate  extends baseclass{
	@FindBy(xpath = "//input[@id='client-your_ref']")
	WebElement update_yourref;
	@FindBy(xpath = "//input[@id='client-phone']")
	WebElement update_phone;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement update_save;
	
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	WebElement logout;
	
	@FindBy(xpath="(//a[@class='logout-btn'])")
	WebElement logoutbutton;
	
	public static WebDriver driver;
	public Clientupdate(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement updateRef()
	{
		return update_yourref;
	}

	public WebElement updatephone()
	{
		return update_phone;
	}
	
	public WebElement updatesave()
	{
		return update_save;
	}
	public WebElement logout()
	{
		return logout;
	}
	public WebElement logoutbutton()
	{
		return logoutbutton;
	}
}
