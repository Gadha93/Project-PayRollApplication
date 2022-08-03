package testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;
import com.payroll.Action.Action;
import com.payroll.baseclass.baseclass;
import com.payroll.pageobjects.Clientpage;
import com.payroll.pageobjects.Homepage;
import com.payroll.pageobjects.Loginpage;
import com.payroll.utilities.Excelcode;
import com.payroll.utilities.Log;

public class HomeTest extends baseclass{
	
	@Test(priority=2)
	public void getClientTab() throws IOException {
		Log.startTestCase("Going to check client tab is working");
		lg.loginfn(usr, psw);
		cp.clients().click();
		String actual = "HOME";
		String expected = hp.getHomeText();
		System.out.println(expected);
		Assert.assertEquals(actual, expected);
		Log.endTestCase("testcase complete for client tab");
	}

	@Test(priority=1)
	public void logout() throws IOException {
		Log.startTestCase("going to check logout properly");
		lg.loginfn(usr, psw);
		act.click(getDriver(), hp.logout());
		act.click(getDriver(), hp.logoutbutton());
		String actual = "Login";
		String expected = hp.getLoginText();
		System.out.println(expected);
		Assert.assertEquals(actual, expected);
		Log.endTestCase("testcase complete for logout button");
	}

}
