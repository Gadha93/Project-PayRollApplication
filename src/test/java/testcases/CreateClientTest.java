package testcases;

import org.testng.annotations.Test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.payroll.Action.Action;
import com.payroll.baseclass.baseclass;
import com.payroll.pageobjects.Clientpage;
import com.payroll.pageobjects.Createclient;
import com.payroll.pageobjects.Loginpage;
import com.payroll.utilities.Excelcode;
import com.payroll.utilities.Log;

public class CreateClientTest extends baseclass {

	@Test
	public void getValidationMsg() throws IOException, InterruptedException {
		Log.startTestCase("going to test validation message for mandatory fields");
		lg.loginfn(usr, psw);
		act.click(getDriver(), cp.clients());
		act.click(getDriver(), cp.cpcreateclient());
		act.scrollByVisibilityOfElement(getDriver(), cc.savebutton());
		act.click(getDriver(), cc.savebutton());
		String actual = "Branch cannot be blank.";
		String expected = cc.getMessage();
		System.out.println(expected);
		Assert.assertEquals(actual, expected);
		Log.endTestCase("Testcase completed");
	}

	@Test
	public void getMandatoryDetailsOfClient() throws IOException {
		Log.startTestCase("client mandatory fields are going to enter");
		lg.loginfn(usr, psw);

		act.click(getDriver(), cp.clients());
		act.click(getDriver(), cp.cpcreateclient());

		act.click(getDriver(), cc.branch());
		act.selectByIndex(cc.branch(), 1);

		act.click(getDriver(), cc.division());
		act.selectByIndex(cc.division(), 1);

		act.click(getDriver(), cc.clientName());
		String s3 = Excelcode.readStringData(11, 0);
		act.type(cc.clientName(), s3);

		act.click(getDriver(), cc.clientAddress());
		String s1 = Excelcode.readStringData(9, 0);
		act.type(cc.clientAddress(), s1);

		act.scrollByVisibilityOfElement(getDriver(), cc.savebutton());

		act.click(getDriver(), cc.clientPostcode());
		String s4 = Excelcode.readIntegerData(12, 0);
		act.type(cc.clientPostcode(), s4);

		act.click(getDriver(), cc.clientInvoiceContact());
		String s8 = Excelcode.readIntegerData(9, 1);
		act.type(cc.clientInvoiceContact(), s8);

		act.click(getDriver(), cc.clientPhone());
		String s6 = Excelcode.readIntegerData(10, 1);
		act.type(cc.clientPhone(), s6);

		act.click(getDriver(), cc.clientEmail());
		String s2 = Excelcode.readStringData(10, 0);
		System.out.println(s2);
		act.type(cc.clientEmail(), s2);
		act.scrollByVisibilityOfElement(getDriver(), cc.savebutton());

		act.click(getDriver(), cc.clientCompanyReg());
		String s7 = Excelcode.readStringData(11, 1);
		act.type(cc.clientCompanyReg(), s7);

		act.click(getDriver(), cc.clientInvoiceOrder());
		act.selectByIndex(cc.clientInvoiceOrder(), 2);

		act.click(getDriver(), cc.clientInvoiceDelivery());
		act.selectByIndex(cc.clientInvoiceDelivery(), 1);

		act.click(getDriver(), cc.clientMasterDocument());
		act.selectByIndex(cc.clientMasterDocument(), 1);

		act.click(getDriver(), cc.clientSettlementDays());
		String s9 = Excelcode.readIntegerData(12, 1);
		act.type(cc.clientSettlementDays(), s9);

		act.click(getDriver(), cc.clientVat());
		act.selectByIndex(cc.clientVat(), 2);

		act.scrollByVisibilityOfElement(getDriver(), cc.savebutton());
		act.explicitWait(getDriver(), cc.savebutton(), 10);
		act.click(getDriver(), cc.savebutton());

		String actual = "Division";
		String expected = cc.getTextDivision();
		Assert.assertEquals(actual, expected);

		Log.endTestCase("values are entered sucessfully");
	}

	@Test
	public void getDetailsSave() throws IOException {
		Log.startTestCase("client details going to save");

		lg.loginfn(usr, psw);

		act.click(getDriver(), cp.clients());
		act.click(getDriver(), cp.cpcreateclient());

		act.click(getDriver(), cc.branch());
		act.selectByIndex(cc.branch(), 1);

		act.click(getDriver(), cc.division());
		act.selectByIndex(cc.division(), 1);

		act.click(getDriver(), cc.clientName());
		String s3 = Excelcode.readStringData(11, 0);
		act.type(cc.clientName(), s3);

		act.click(getDriver(), cc.clientAddress());
		String s1 = Excelcode.readStringData(9, 0);
		act.type(cc.clientAddress(), s1);

		act.scrollByVisibilityOfElement(getDriver(), cc.savebutton());

		act.click(getDriver(), cc.clientPostcode());
		String s4 = Excelcode.readIntegerData(12, 0);
		act.type(cc.clientPostcode(), s4);

		act.click(getDriver(), cc.clientInvoiceContact());
		String s8 = Excelcode.readIntegerData(9, 1);
		act.type(cc.clientInvoiceContact(), s8);

		act.click(getDriver(), cc.clientPhone());
		String s6 = Excelcode.readIntegerData(10, 1);
		act.type(cc.clientPhone(), s6);

		act.click(getDriver(), cc.clientEmail());
		String s2 = Excelcode.readStringData(10, 0);
		System.out.println(s2);
		act.type(cc.clientEmail(), s2);
		act.scrollByVisibilityOfElement(getDriver(), cc.savebutton());

		act.click(getDriver(), cc.clientCompanyReg());
		String s7 = Excelcode.readStringData(11, 1);
		act.type(cc.clientCompanyReg(), s7);

		act.click(getDriver(), cc.clientInvoiceOrder());
		act.selectByIndex(cc.clientInvoiceOrder(), 2);

		act.click(getDriver(), cc.clientInvoiceDelivery());
		act.selectByIndex(cc.clientInvoiceDelivery(), 1);

		act.click(getDriver(), cc.clientMasterDocument());
		act.selectByIndex(cc.clientMasterDocument(), 1);

		act.click(getDriver(), cc.clientSettlementDays());
		String s9 = Excelcode.readIntegerData(12, 1);
		act.type(cc.clientSettlementDays(), s9);

		act.click(getDriver(), cc.clientVat());
		act.selectByIndex(cc.clientVat(), 2);
		act.click(getDriver(), cc.checkbox1());
		act.click(getDriver(), cc.checkbox2());
		act.click(getDriver(), cc.checkbox3());
		act.click(getDriver(), cc.checkbox4());
		act.scrollByVisibilityOfElement(getDriver(), cc.savebutton());
		act.explicitWait(getDriver(), cc.savebutton(), 10);
		act.click(getDriver(), cc.savebutton());
		String actual = "Division";
		String expected = cc.getTextDivision();
		Assert.assertEquals(actual, expected);
		Log.endTestCase("save the client details successfully");
	}

}
