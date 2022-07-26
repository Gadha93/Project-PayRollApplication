package com.payroll.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Deduction {
	public static WebDriver driver;
	@FindBy(linkText = "Deduction")
	WebElement deduction;

	public Deduction(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement deductionTab() {
		return deduction;
	}

	@FindBy(linkText = "Add Deduction")
	WebElement adddeduction;

	public WebElement addDeduction() {
		return adddeduction;
	}

	@FindBy(xpath = "//span[@role='combobox']")
	WebElement worker;

	public WebElement deductionWorker() {
		return worker;
	}

	@FindBy(xpath = "//select[@id='deduction-type']")
	WebElement type;

	public WebElement deductiontype() {
		return type;
	}

	@FindBy(xpath = "//input[@id='deduction-amount']")
	WebElement amount;

	public WebElement deductionAmount() {
		return amount;
	}

	@FindBy(xpath = "//input[@id='deduction-effective_from']")
	WebElement form;

	public WebElement deductionform() {
		return form;
	}

	@FindBy(xpath = "//td[normalize-space()='22']")
	WebElement date;

	public WebElement deductiondate() {
		return date;
	}

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement save;

	public WebElement deductionsave() {
		return save;
	}

	@FindBy(xpath = "//th[normalize-space()='Worker']")
	WebElement errmsg2;

	public String getTextWorker() {
		String err2 = errmsg2.getText();
		return err2;
	}

	@FindBy(xpath = "//p[normalize-space()='Amount cannot be blank.']")
	WebElement errmsg3;

	public String getValidationMsg() {
		String err2 = errmsg3.getText();
		return err2;
	}
	@FindBy(xpath= "(//span[@class='glyphicon glyphicon-pencil'])[1] ")
	WebElement update;
	public WebElement getdeduction() {
		return update;
	}
	
}
