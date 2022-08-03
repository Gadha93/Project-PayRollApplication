package testcases;

import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import com.payroll.Action.Action;
import com.payroll.baseclass.baseclass;
import com.payroll.pageobjects.Loginpage;
import com.payroll.pageobjects.PasswordReset;
import com.payroll.utilities.Excelcode;
import com.payroll.utilities.Log;

public class LoginTest extends baseclass {
   
    @Test(priority = 1)
	public void getloginValidCredentials() throws IOException, InterruptedException {
		Log.startTestCase("Login to payroll");
		lg.loginfn(usr,psw);
		String actual = "Dashboard";
		String expected =lg.getTextPayRoll();
		Assert.assertEquals(actual, expected);
		Log.endTestCase("login to homepage");
	}

	@Test(priority=2)
	public void getloginInvalidCredentials() throws IOException {
		lg.uname().click();
		String s = Excelcode.readStringData(3, 0);
		lg.uname().sendKeys(s);
		lg.pwd().click();
		String s1 = Excelcode.readStringData(3, 1);
		lg.pwd().sendKeys(s1);
		lg.loginButton().click();
		String actual = "Incorrect username or password.";
		String expected = lg.getValidationMsg();
		Assert.assertEquals(actual, expected);
		}

	@Test(priority = 3)
	public void getloginEmptyFields() {
		lg.uname().click();
		lg.uname().sendKeys("");
		lg.pwd().click();
		lg.pwd().sendKeys("");
		lg.loginButton().click();
		String actual = "Username cannot be blank.";
		String expected = lg.getBlankValidationMsg();
		Assert.assertEquals(actual, expected);

	}

	@Test(groups = { "Regression" },priority=6)
	public void getResetCheck() throws InterruptedException {
		lg.reset().click();
		boolean expected = true;
		boolean actual = lg.getLogoCheck();
		System.out.println(expected + "Assertion passed");
		Assert.assertEquals(actual, expected);
		}
	@Test(dataProvider = "getinvalidLogin", priority = 4, groups = { "Regression" })
	public void getInvalidLogin(String Username, String Password) {
		lg.uname().click();
		lg.uname().sendKeys(Username);
		lg.pwd().click();
		lg.pwd().sendKeys(Password);
		lg.loginButton().click();
		String actual = "Incorrect username or password.";
		String expected = lg.getValidationMsg();
		Assert.assertEquals(actual, expected);
		}

	@DataProvider
	public Object[][] getinvalidLogin() {
		Object[][] data = new Object[2][2];
		data[0][0] = "carol";
		data[0][1] = "1q2w3e";
		data[1][0] = "caer";
		data[1][1] = "1q2w3e4r";
		return data;
	}
	@Test(priority=5)
	public void getCancelButton() throws IOException
	{
		lg.reset().click();
		PasswordReset pr=new PasswordReset(getDriver());
		pr.getEmail().click();
		String email=Excelcode.readStringData(16, 0);
	    pr.getEmail().sendKeys(email);
	    pr.getCancelButton().click();
	    String actual = "Login";
		String expected = lg.getTextLogin();
		Assert.assertEquals(actual, expected);
	}

}
