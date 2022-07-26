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
	
	  @Test
	  public void getHomePage() throws InterruptedException, IOException
	  { 
	  Log.startTestCase("Homepage testcases");
	  String usr=Excelcode.readStringData(14, 0);
	  String pwd=Excelcode.readStringData(14, 1);
	  Loginpage lg=new Loginpage(getDriver());
	  lg.loginfn(usr,pwd);
	  Homepage hp=new Homepage(getDriver());
	  act.click(getDriver(), hp.logout());
	  act.click(getDriver(), hp.logoutbutton());
	  String actual= "Login";
	  String expected=hp.getLoginText();
	  System.out.println(expected);
	  Assert.assertEquals(actual, expected);
	  
	  }
	
	  @Test public void getClientTab() throws IOException {
	  
	  String usr=Excelcode.readStringData(14, 0);
	  String pwd=Excelcode.readStringData(14, 1);
	  Loginpage lg=new Loginpage(getDriver());
	  lg.loginfn(usr,pwd);
	  Clientpage cp=new Clientpage(getDriver());
	  cp.clients().click(); 
	  act.explicitWait(getDriver(),cp.clients(),10);
	  Homepage hp=new Homepage(getDriver());
	  String actual="HOME"; 
	  String expected=hp.getHomeText();
	  System.out.println(expected); 
	  Assert.assertEquals(actual, expected);
	  Log.endTestCase("Homepage Testcase completed"); }
	 
  
   
}
