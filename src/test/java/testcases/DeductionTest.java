package testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.payroll.Action.Action;
import com.payroll.baseclass.baseclass;
import com.payroll.pageobjects.Deduction;
import com.payroll.pageobjects.Loginpage;
import com.payroll.utilities.Excelcode;
import com.payroll.utilities.Log;

public class DeductionTest extends baseclass {
	
	  @Test 
	  public void checkAddDeduction() throws IOException {
	  Log.startTestCase("Going to check deduction"); 
	  lg.loginfn(usr,psw);
	  Deduction dc = new Deduction(getDriver());
	  act.click(getDriver(),dc.deductionTab()); 
	  act.click(getDriver(),dc.addDeduction()); 
	  act.click(getDriver(),dc.deductionWorker());
	  act.explicitWait(getDriver(), dc.deductionWorker(), 10);
	  act.selectByIndex(dc.deductionWorker(), 3);
	  act.click(getDriver(),dc.deductiontype()); 
	  act.selectByIndex(dc.deductiontype(), 3);
	  act.click(getDriver(), dc.deductionAmount()); 
	  String s=Excelcode.readIntegerData(13, 0); 
	  act.type(dc.deductionAmount(), s);
	  act.click(getDriver(), dc.deductionform());
	  act.click(getDriver(),dc.deductiondate()); 
	  act.explicitWait(getDriver(),dc.deductionsave(), 10); 
	  act.click(getDriver(), dc.deductionsave()); 
	  String actual="Worker"; 
	  String expected=dc.getTextWorker(); 
	  Assert.assertEquals(actual,expected);
	  Log.endTestCase("End deduction testcase");
	  }
	 
	@Test(groups= {"Regression"})
	public void deductioncheck() throws IOException
	{
		Log.startTestCase("Going to check deduction"); 
		lg.loginfn(usr,psw);
		Deduction dc = new Deduction(getDriver());
		act.click(getDriver(),dc.deductionTab());
		act.click(getDriver(), dc.addDeduction());
		act.click(getDriver(),dc.deductionWorker());
		act.selectByIndex(dc.deductionWorker(), 3);
		act.click(getDriver(), dc.deductiontype());
		act.selectByIndex(dc.deductiontype(), 3);
		act.click(getDriver(), dc.deductionsave());
		String actual="Amount cannot be blank.";
		String expected=dc.getValidationMsg();
		Assert.assertEquals(actual, expected);
		Log.endTestCase("End deduction testcase");
	}
	@Test
	public void getDeductionUpdate()throws IOException {
		Log.startTestCase("Going to update deduction"); 
		lg.loginfn(usr,psw);
		Deduction dc = new Deduction(getDriver());
		act.click(getDriver(),dc.deductionTab());
		act.click(getDriver(),dc.getdeduction());
		act.click(getDriver(), dc.deductionAmount());
		String amt=Excelcode.readIntegerData(15, 0);
		act.type(dc.deductionAmount(),amt);
		act.click(getDriver(), dc.deductionsave());
		String actual="Worker"; 
		String expected=dc.getTextWorker(); 
		Assert.assertEquals(actual,expected);
		Log.endTestCase("End update deduction testcase");
	}
}