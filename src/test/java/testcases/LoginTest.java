package testcases;

import org.testng.annotations.Test;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import com.payroll.Action.Action;
import com.payroll.baseclass.baseclass;
import com.payroll.pageobjects.Loginpage;
import com.payroll.utilities.Excelcode;
import com.payroll.utilities.Log;

public class LoginTest extends baseclass {
   
    @Test(priority = 1)
	public void getloginValidCredentials() throws IOException {
		Log.startTestCase("Login to payroll");
		String usr=Excelcode.readStringData(14, 0);
		String pwd=Excelcode.readStringData(14, 1);
		Loginpage lg=new Loginpage(getDriver());
		lg.loginfn(usr,pwd);
		boolean expected = true;
		boolean actual = lg.getLogoCheck();
		Assert.assertEquals(actual, expected);
		Log.endTestCase("login to homepage");
	}

	@Test
	public void getloginInvalidCredentials() throws IOException {
		Loginpage lg=new Loginpage(getDriver());
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

	@Test(priority = 2)
	public void getloginEmptyFields() {
		Loginpage lg=new Loginpage(getDriver());
		lg.uname().click();
		lg.uname().sendKeys("");
		lg.pwd().click();
		lg.pwd().sendKeys("");
		lg.loginButton().click();
		String actual = "Username cannot be blank.";
		String expected = lg.getBlankValidationMsg();
		Assert.assertEquals(actual, expected);

	}

	@Test(groups = { "Regression" })
	public void getResetCheck() throws InterruptedException {
		Loginpage lg=new Loginpage(getDriver());
		lg.reset().click();
		boolean expected = true;
		boolean actual = lg.getLogoCheck();
		System.out.println(expected + "Assertion passed");
		Assert.assertEquals(actual, expected);
		}
	@Test(dataProvider = "getinvalidLogin", priority = 3, groups = { "Regression" })
	public void getInvalidLogin(String Username, String Password) {
		Loginpage lg=new Loginpage(getDriver());
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
	@Test
	public void getCancelButton() throws IOException
	{
		Loginpage lg=new Loginpage(getDriver());
		lg.reset().click();
		lg.getEmail().click();
		String email=Excelcode.readStringData(16, 0);
	    lg.getEmail().sendKeys(email);
	    lg.getCancelButton().click();
	    String actual = "Login";
		String expected = lg.getTextLogin();
		Assert.assertEquals(actual, expected);
	}

}
