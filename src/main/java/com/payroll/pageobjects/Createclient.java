package com.payroll.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.payroll.baseclass.baseclass;

public class Createclient extends baseclass{
	@FindBy(id="client-branch_id")
	WebElement branch;
	@FindBy(id="client-division_id")
	WebElement division;
	@FindBy(id="client-client_name")
	WebElement clientname;
	@FindBy(xpath="//textarea[@id='client-client_address']")
	WebElement clientaddress;
	@FindBy(id="client-postcode")
	WebElement clientpostcode;
	@FindBy(css="input[name='Client[country]']")
	WebElement clientcountry;
	@FindBy(className = "Client[your_ref]")
	WebElement clientyourref;
	@FindBy(name = "Client[invoice_contact]")
	WebElement clientinvoicecontact;
	@FindBy(id = "client-phone")
	WebElement clientphone;
	@FindBy(xpath="//input[@id=client-fax")
	WebElement clientfax;
	@FindBy(id="client-email")
	WebElement clientemail;
	@FindBy(name = "Client[company_reg]")
	WebElement clientcompanyreg;
	@FindBy(id="client-invoice_order")
	WebElement clientinvoiceorder;
	@FindBy(id="client-invoice_delivery_method")
	WebElement clientinvoicedelivery;
	@FindBy(name = "Client[master_document]")
	WebElement masterdocument;
	@FindBy(id="client-settilement_days")
	WebElement settlementdays;
	@FindBy(id="client-vat_rate")
	WebElement vat;
	@FindBy(xpath= "//a[@href='/payrollapp/client/create']")
	WebElement create;
	@FindBy(xpath="//button[@type='submit']")
	WebElement save;
	@FindBy(xpath="//th[normalize-space()='Division']")
	WebElement assertmsg;
	@FindBy(xpath="//div[normalize-space()='Branch cannot be blank.']")
	WebElement assertmsg1;
	@FindBy(id="client-require_po")
	WebElement check1;
	@FindBy(id="client-direct_client")
	WebElement check2;
	@FindBy(id="client-uk_public_sector_client")
	WebElement check3;
	@FindBy(id="client-subject_to_payee")
	WebElement check4;
	public static WebDriver driver;
	public Createclient(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public String assertMsg()
	{ 
		 String err2=assertmsg.getText(); 
		 return err2; 
	}
	public String getTextDivision()
	{ 
		 String err1=assertmsg1.getText(); 
		 return err1; 
	}
	public WebElement savebutton()
	{
		return save;
	}
	public WebElement createbutton()
	{
		return create;
	}
	public WebElement branch()
	{
		return branch;
	}
	public WebElement division()
	{
		return division;
	}
	public WebElement clientName()
	{
		return clientname;
	}
	public WebElement clientAddress()
	{
		return clientaddress;
	}
	public WebElement clientPostcode()
	{
		return clientpostcode;
	}
	public WebElement country()
	{
		return clientcountry;
	}
	public WebElement yourRef()
	{
		return clientyourref;
	}
	public WebElement clientInvoiceContact()
	{
		return clientinvoicecontact;
	}
	public WebElement clientPhone()
	{
		return clientphone;
	}
	public WebElement clientFax()
	{
		return clientfax;
	}
	public WebElement clientEmail()
	{
		return clientemail;
	}
	public WebElement clientCompanyReg()
	{
		return clientcompanyreg;
	}
	public WebElement clientInvoiceOrder()
	{
		return clientinvoiceorder;
	}
	public WebElement clientInvoiceDelivery()
	{
		return clientinvoicedelivery;
	}
	public WebElement clientMasterDocument()
	{
		return masterdocument;
	}
	public WebElement clientSettlementDays()
	{
		return settlementdays;
	}
	public WebElement clientVat()
	{
		return vat;
	}
	public WebElement checkbox1()
	{
		return check1;
	}
	public WebElement checkbox2()
	{
		return check2;
	}
	public WebElement checkbox3()
	{
		return check3;
	}
	public WebElement checkbox4()
	{
		return check4;
	}
}


