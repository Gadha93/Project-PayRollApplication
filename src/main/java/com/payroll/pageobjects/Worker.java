package com.payroll.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.payroll.Action.Action;

public class Worker {
	Action act=new Action(); 
	public static WebDriver driver;
	@FindBy(linkText = "Workers")
	WebElement worker;
	@FindBy(id="workersearch-first_name")
	WebElement workername;
	@FindBy(id="workersearch-last_name")
	WebElement workerlastname;
	@FindBy(id="workersearch-postcode")
	WebElement workerpostcode;
	@FindBy(id="workersearch-ni_number")
	WebElement workerni_number;
	@FindBy(xpath="//input[@id='worker-known']")
	WebElement known;
	@FindBy(css="button[type='reset']")
	WebElement reset;
	@FindBy(css="button[type='submit']")
	WebElement search;
	@FindBy(xpath="(//span[@class='glyphicon glyphicon-pencil'])[1]")
	WebElement update;
	@FindBy(xpath="//label[normalize-space()='Payment Method']")
	WebElement textpayment;
	@FindBy(xpath="//th[normalize-space()='Name']")
	WebElement assertname;
	@FindBy(xpath="(//span[@class='glyphicon glyphicon-eye-open'])[1]")
	WebElement viewbutton;
	@FindBy(xpath="//th[normalize-space()='Division']")
	WebElement division;
	@FindBy(xpath="//button[normalize-space()='Next']")
	WebElement next;
	@FindBy(xpath="(//span[@class='glyphicon glyphicon-trash'])[1]")
	WebElement delbutton;
	@FindBy(xpath=" //a[normalize-space()='Dashboard']")
	WebElement dashboard;
	public Worker(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement workerPage() {
		act.explicitWait(driver, worker, 10);
		return worker;
	}
	public WebElement getdeletebutton() {
		return delbutton;
	}
	
	public WebElement getWorkerNextPage() {
		return next;
	}
	public WebElement update() {
		return update;
	}
	public String getDashBoard() {
		String text=dashboard.getText();
		return text;
	}
	public WebElement updateKnownField() {
		return known;
	}
	public WebElement getSearchWorker() {
		return search;
	}
	public WebElement getWorkerName() {
		return workername;
	}
	public WebElement getWorkerLastName() {
		return workerlastname;
	}
	public WebElement getWorkerPostCode() {
		return workerpostcode;
	}
	public WebElement getWorkerNiNumber() {
		return workerni_number;
	}
	public String getAssertCheckName() {
		String name=assertname.getText();
		return name;
	}
	public WebElement resetCheck() {
		//act.explicitWait(driver, resetCheck(), 10);
		return reset;
	}
	public WebElement getviewbutton() {
		return viewbutton;
	}
	public String viewbutton() {
		 String viewbutton=division.getText();
		 return viewbutton;
	}
	public String getTextPayment() {
		 String button=textpayment.getText();
		 return button;
	}
}
