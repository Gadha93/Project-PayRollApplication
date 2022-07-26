package testcases;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.payroll.Action.Action;
import com.payroll.baseclass.baseclass;
import com.payroll.pageobjects.Clientpage;
import com.payroll.pageobjects.Clientupdate;
import com.payroll.pageobjects.Createclient;
import com.payroll.pageobjects.Homepage;
import com.payroll.pageobjects.Loginpage;
import com.payroll.utilities.Excelcode;
import com.payroll.utilities.Excelmain;
import com.payroll.utilities.Log;

public class ClientTest extends baseclass {
	
	@Test
	public void getClientDetails() throws IOException {
		Log.startTestCase("Started to test client details");
		String usr=Excelcode.readStringData(14, 0);
		String pwd=Excelcode.readStringData(14, 1);
		Loginpage lg=new Loginpage(getDriver());
		lg.loginfn(usr,pwd);
		Clientpage cp = new Clientpage(getDriver());
		act.click(getDriver(), cp.clients());
		act.click(getDriver(), cp.cpclientname());
		String name = Excelcode.readStringData(7, 0);
		act.type(cp.cpclientname(), name);
		act.click(getDriver(), cp.cpclientid());
		String id = Excelcode.readIntegerData(7, 1);
		act.type(cp.cpclientid(), id);
		act.click(getDriver(), cp.cpSearch());
		String actual="Sam";
		String expected=name;
		Assert.assertEquals(actual, expected);
		Log.endTestCase("completed Search_client details");
	}
	@Test
	public void getupdatedClient() throws IOException, InterruptedException {
		Log.startTestCase("Started to test client details");
		String usr=Excelcode.readStringData(14, 0);
		String pwd=Excelcode.readStringData(14, 1);
		Loginpage lg=new Loginpage(getDriver());
		lg.loginfn(usr,pwd);
		Clientpage cp = new Clientpage(getDriver());
		act.click(getDriver(), cp.clients());
		act.click(getDriver(), cp.cpclientname());
		String name = Excelcode.readStringData(7, 0);
		act.type(cp.cpclientname(), name);
		act.click(getDriver(), cp.cpclientid());
		String id = Excelcode.readIntegerData(7, 1);
		act.type(cp.cpclientid(), id);
		act.click(getDriver(), cp.cpSearch());
		act.click(getDriver(), cp.cpsearchupdate());
		act.click(getDriver(), cp.cpPhone());
		String phonenum=Excelcode.readIntegerData(8, 1);
		act.type(cp.cpPhone(), phonenum);
		act.scrollByVisibilityOfElement(getDriver(), cp.cpSave());
		act.click(getDriver(), cp.cpSave());
		//need explicit wait
		String actual = "Branch";
		String expected = cp.getTextBranch();
		Assert.assertEquals(actual, expected);
		
	}
	
	  @Test
	  public void resetClientDetails() throws IOException
	  {
	  Log.startTestCase("Started to reset client details");
	  String usr=Excelcode.readStringData(14, 0);
	  String pwd=Excelcode.readStringData(14, 1);
	  Loginpage lg=new Loginpage(getDriver());
	  lg.loginfn(usr,pwd);
	  Clientpage cp = new Clientpage(getDriver());
	  act.click(getDriver(), cp.clients());
	  cp.cpclientname().click();
	  String name = Excelcode.readStringData(7, 0);
	  act.type(cp.cpclientname(), name);
	  cp.cpclientid().click(); 
	  String id =Excelcode.readIntegerData(7, 1); 
	  act.type(cp.cpclientid(), id);
	  act.click(getDriver(),cp.cpReset());
	  String actual="";
	  String expected=cp.getBlankClientName();
	  Assert.assertEquals(actual, expected);
	  Log.endTestCase("completed Reset_client details");
	  }
	 
	@Test
	public void getviewclientDetails() throws IOException {
		Log.startTestCase("Started to view client details");
		String usr=Excelcode.readStringData(14, 0);
		String pwd=Excelcode.readStringData(14, 1);
		Loginpage lg=new Loginpage(getDriver());
		lg.loginfn(usr,pwd);
		Clientpage cp = new Clientpage(getDriver());
		act.click(getDriver(), cp.clients());
		act.click(getDriver(), cp.cpview());
		String actual = "Invoice History";
		String expected = cp.getTextInvoiceHistory();
		Assert.assertEquals(actual, expected);
		Log.endTestCase("completed viewclient details");
		}

	
	@Test(groups = { "Regression" })
	public void getupdatedClientDetails() throws IOException {
		
		Log.startTestCase("Started updated client details");
		String usr=Excelcode.readStringData(14, 0);
		String pwd=Excelcode.readStringData(14, 1);
		Loginpage lg=new Loginpage(getDriver());
		lg.loginfn(usr,pwd);
		Clientpage cp = new Clientpage(getDriver());
		act.click(getDriver(), cp.clients());
		act.click(getDriver(), cp.cpupdate());
		Clientupdate cu = new Clientupdate(getDriver());
		act.click(getDriver(), cu.updatephone());
		String phonenum = Excelcode.readIntegerData(8, 1);
		act.type(cu.updatephone(), phonenum);
		act.scrollByVisibilityOfElement(getDriver(), cu.updatesave());
		act.click(getDriver(), cu.updatesave());
		String actual = "Invoice History";
		String expected = cp.getTextInvoiceHistory();
		System.out.println(expected);
		Assert.assertEquals(actual, expected);
		Homepage hp = new Homepage(getDriver());
		act.click(getDriver(), hp.logout());
		act.click(getDriver(), hp.logoutbutton());
		Log.endTestCase("Complete updated client details");
	}

}
