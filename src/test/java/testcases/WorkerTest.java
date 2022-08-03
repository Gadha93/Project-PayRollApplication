package testcases;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.payroll.baseclass.baseclass;
import com.payroll.pageobjects.Loginpage;
import com.payroll.pageobjects.Worker;
import com.payroll.utilities.Excelcode;
import com.payroll.utilities.Log;

public class WorkerTest extends baseclass {
	@Test(priority=1)
	public void getSearchWorker() throws IOException {
		Log.startTestCase("Started to search worker ");
		lg.loginfn(usr, psw);
		act.click(getDriver(), wp.workerPage());
		act.click(getDriver(), wp.getWorkerName());
		String firstname = Excelcode.readStringData(19, 0);
		act.type(wp.getWorkerName(), firstname);
		act.click(getDriver(), wp.getWorkerLastName());
		String lastname = Excelcode.readStringData(19, 1);
		act.type(wp.getWorkerLastName(), lastname);
		act.click(getDriver(), wp.getWorkerPostCode());
		String post = Excelcode.readIntegerData(19, 2);
		act.type(wp.getWorkerPostCode(), post);
		act.click(getDriver(), wp.getWorkerNiNumber());
		String number = Excelcode.readIntegerData(19, 3);
		act.type(wp.getWorkerNiNumber(), number);
		act.click(getDriver(), wp.getSearchWorker());
		String actual = "Name";
		String expected = wp.getAssertCheckName();
		Assert.assertEquals(actual, expected);
		Log.endTestCase("completed Search_client details");
	}
	@Test(groups= {"Regression"},priority=5)
	public void updateWorker() throws IOException {
		Log.startTestCase("Started to update worker details");
		lg.loginfn(usr, psw);
		act.click(getDriver(), wp.workerPage());
		act.click(getDriver(), wp.update());
		act.click(getDriver(), wp.updateKnownField());
		String known=Excelcode.readStringData(20, 0);
		act.type(wp.updateKnownField(), known);
		act.scrollByVisibilityOfElement(getDriver(), wp.getWorkerNextPage());
		act.click(getDriver(), wp.getWorkerNextPage());
		String actual = "Payment Method";
		String expected = wp.getTextPayment();
		Assert.assertEquals(actual, expected);
		Log.endTestCase("Updated worker  details");
	}
	@Test(priority=4)
	public void getResetWorker() throws IOException {
		Log.startTestCase("Started to Reset worker details");
		lg.loginfn(usr, psw);
		act.click(getDriver(), wp.workerPage());
		act.click(getDriver(), wp.getWorkerName());
		String firstname = Excelcode.readStringData(18, 0);
		act.type(wp.getWorkerName(), firstname);
		act.click(getDriver(), wp.getWorkerLastName());
		String lastname = Excelcode.readStringData(18, 1);
		act.type(wp.getWorkerLastName(), lastname);
		act.click(getDriver(), wp.getWorkerPostCode());
		String post = Excelcode.readIntegerData(18, 2);
		act.type(wp.getWorkerPostCode(), post);
		act.click(getDriver(), wp.getWorkerNiNumber());
		String number = Excelcode.readStringData(18, 3);
		act.type(wp.getWorkerNiNumber(), number);
		act.click(getDriver(), wp.resetCheck());
		String actual = "Name";
		String expected = wp.getAssertCheckName();
		Assert.assertEquals(actual, expected);
		Log.endTestCase("Reset  worker details details");
	}
	@Test(priority=3)
	public void viewWorker() throws IOException, InterruptedException {
		Log.startTestCase("Started to view worker details");
		lg.loginfn(usr, psw);
		act.click(getDriver(), wp.workerPage());
		act.click(getDriver(), wp.getviewbutton());
		String actual = "Division";
		String expected = wp.viewbutton();
		Assert.assertEquals(actual, expected);
		Log.endTestCase("Viewed worker details");
	    }
	@Test(priority=2)
	public void deleteWorker() throws IOException, InterruptedException {
		Log.startTestCase("Started to delete worker details");
		lg.loginfn(usr, psw);
		act.click(getDriver(), wp.workerPage());
		act.click(getDriver(), wp.getdeletebutton());
		act.Alert(getDriver());
		String actual = "Dashboard";
		String expected = wp.getDashBoard();
		Assert.assertEquals(actual, expected);
		Log.endTestCase("Delete Worker Testcase completed");
	    }
	

}
