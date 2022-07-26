package com.payroll.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Factory;

import com.payroll.baseclass.baseclass;

public class Homepage extends baseclass{
	@FindBy(linkText = "Dashboard")
	WebElement dashboard;
	@FindBy(linkText = "Company")
	WebElement company;
	@FindBy(linkText = "Clients")
	WebElement clients;
	@FindBy(linkText = "Workers")
	WebElement workers;
	@FindBy(linkText = "Deduction")
	WebElement deduction;
	@FindBy(linkText = "TimeSheet")
	WebElement timesheet;
	@FindBy(linkText = "Payslip")
	WebElement payslip;
    @FindBy(xpath="//img[@alt='logo']")
	WebElement logo;
	@FindBy(xpath="//p[normalize-space()='Welcome to Payroll Application']")
	WebElement errmsg;
	@FindBy(xpath="//a[@class='dropdown-toggle']")
	WebElement logout;
	@FindBy(xpath="(//a[@class='logout-btn'])")
	WebElement logoutbutton;
	@FindBy(xpath="//h1[normalize-space()='Login']")
	WebElement errmsg1;
	
	@FindBy(xpath="//a[normalize-space()='Home']")
	WebElement errmsg2;
	
	public static WebDriver driver;
	public Homepage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement dashboard()
	{
		return dashboard;
	}
	public WebElement company()
	{
		return company;
	}
	public WebElement clients()
	{
		act.explicitWait(driver, clients, 10);
		return clients;
	}
	public WebElement workers()
	{
		return workers;
	}
	public WebElement deduction()
	{
		return deduction;
	}
	public WebElement timesheet()
	{
		return timesheet;
	}
	public WebElement Payslip()
	{
		return payslip;
	}
	public WebElement logo()
	{
		return logo;
	}
	public String errormsg()
	{
		String err=errmsg.getText();
		return err;
	}
	public WebElement logoutbutton()
	{
		return logoutbutton;
	}
	public WebElement logout()
	{
		return logout;
	}
	 public String getLoginText() 
	    { 
		 String textlogin=errmsg1.getText(); 
		 return textlogin; 
		 }
	 public String getHomeText() 
	    { 
		 String texthome=errmsg2.getText(); 
		 return texthome; 
		 }
}

