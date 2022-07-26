package com.payroll.pageobjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.payroll.Action.Action;
import com.payroll.baseclass.baseclass;

public class Clientpage extends baseclass{
	Action act=new Action();
	@FindBy(linkText = "Clients")
	WebElement client;
	@FindBy(id="clientsearch-client_name")
	WebElement clientname;
	@FindBy(id="clientsearch-id")
	WebElement clientid;
	@FindBy(xpath="//button[@type='submit']")
	WebElement search;
	@FindBy(xpath="//button[@type='reset']")
	WebElement reset;
	@FindBy(linkText="Create Client")
	WebElement create_client;
	@FindBy(linkText="Home")
	WebElement home;
	@FindBy(linkText="Client ID")
	WebElement sclient_id;
	@FindBy(linkText="Client Name")
	WebElement sclient_name;
	@FindBy(linkText="Your Ref")
	WebElement yourref;
	@FindBy(linkText="Client Address")
	WebElement clientaddress;
	@FindBy(linkText="Postcode")
	WebElement postcode;
	@FindBy(xpath="(//span[@class='glyphicon glyphicon-eye-open'])[1]")
	WebElement view;
	@FindBy(xpath="(//span[@class='glyphicon glyphicon-pencil'])[1]")
	WebElement update;
	@FindBy(id="clientsearch-client_name")
	WebElement assert1;
	@FindBy(xpath="//span[@class='glyphicon glyphicon-pencil']")
	WebElement updatesearch;
	@FindBy(xpath="//input[@id='client-phone']")
	WebElement phone;
	@FindBy(linkText = "Invoice History")
	WebElement errormsg1;
	@FindBy(css="button[type='submit']")
	WebElement save;
	@FindBy(xpath="//th[normalize-space()='Division']")
	WebElement assertdivision;
	@FindBy(xpath="//th[normalize-space()='Branch']")
	WebElement branch;
	public static WebDriver driver;
	
	public Clientpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String getBlankClientName()
	{
		String errassert=assert1.getText();
		return errassert;
	}
	public WebElement cpclientname()
	{
		return clientname;
		
	}
	public WebElement cpclientid()
	{
		return clientid;
		
	}
	public WebElement cpSearch()
	{
		return search;
		
	}
	public String cpDivision()
	{
		 String err2=assertdivision.getText(); 
		 return err2; 
	}
	public WebElement cpSave()
	{
		return save;
		
	}
	public WebElement cpReset()
	{
		return reset;
		
	}
	public WebElement cpPhone()
	{
		return phone;
		
	}
	public WebElement cphome()
	{
		return home;
		
	}
	public WebElement cpsortclientid()
	{
		return sclient_id;
		
	}
	public WebElement cpsortclientname()
	{
		return sclient_name;
		
	}
	public WebElement cpview()
	{
		return view;
	
	}
	public WebElement cpclientaddress()
	{
		return clientaddress;
		
	}
	public WebElement cppostcode()
	{
		return postcode;
		
	}
	public WebElement cpupdate()
	{
		return update;
		
	}
	public WebElement cpsearchupdate()
	{
		act.explicitWait(driver, updatesearch, 10);
		return updatesearch;
		
	}
	public WebElement cpcreateclient()
	{
		return create_client;
		
	}
	public WebElement cpyourref()
	{
		return yourref;
		
	}
	public WebElement clients()
	{
		return client;
		
	}
	
	 public String getTextInvoiceHistory() 
	    { 
		 String err2=errormsg1.getText(); 
		 return err2; 
		 }
	public String getTextBranch()
	{
		String s=branch.getText();
		return s;
	}
}
