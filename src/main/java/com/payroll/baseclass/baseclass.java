package com.payroll.baseclass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.payroll.Action.Action;
import com.payroll.pageobjects.Clientpage;
import com.payroll.pageobjects.Clientupdate;
import com.payroll.pageobjects.Createclient;
import com.payroll.pageobjects.Homepage;
import com.payroll.pageobjects.Loginpage;
import com.payroll.pageobjects.Worker;
import com.payroll.utilities.Excelcode;
import com.payroll.utilities.ExtentReport;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseclass {
	public static Properties prop;
	public static Action act=new Action();
	public String usr;
	public String psw;
	public static Loginpage lg;
	public static Clientpage cp;
	public static Homepage hp;
	public static Clientupdate cu;
	public static Worker wp;
	public static Createclient cc;
	//public static WebDriver getDriver()
	//loadConfig method is to load the configuration
	
	public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
	
	@BeforeSuite(groups= {"Regression"})
	public void loadConfig() {
		DOMConfigurator.configure("log4j.xml");
		ExtentReport.setExtent();

		try {
			 prop = new Properties();
			 
			 
			FileInputStream ip = new FileInputStream(
					System.getProperty("user.dir") + "/Configurations/config.properties");
			prop.load(ip);
			System.out.println(System.getProperty("user.dir"));
			

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@BeforeMethod(groups= {"Regression"})
	 public void firstcall() throws IOException
	 {
		launchApp();
		lg=new Loginpage(getDriver());
		cp=new Clientpage(getDriver());
		hp=new Homepage(getDriver());
		cu=new Clientupdate(getDriver());
		wp=new Worker(getDriver());
		cc=new Createclient(getDriver());
		usr=Excelcode.readStringData(14, 0);
		psw=Excelcode.readStringData(14, 1);
		
	 }
	public static WebDriver getDriver()
	{
		return driver.get();
		
	}
	
	public void launchApp() {
		
	   String browserName = prop.getProperty("Browser");
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver.set(new ChromeDriver());
		} else if (browserName.equalsIgnoreCase("FireFox")) {
			WebDriverManager.firefoxdriver().setup();
			driver.set(new FirefoxDriver());
		} else if (browserName.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver.set(new InternetExplorerDriver());
		}
		//Maximize the screen
		getDriver().manage().window().maximize();
		Action action = new Action();
		//Implicit TimeOuts
	    action.implicitWait(getDriver(), 10);
		//PageLoad TimeOuts
		action.pageLoadTimeOut(getDriver(), 30);   
		 getDriver().get(prop.getProperty("url"));
		
		 
	}
	@AfterMethod(groups = { "Regression" })
	public void driverClose() {
		getDriver().close();
	}
	@AfterSuite(groups= {"Regression"})
	public void Logout()
	{
		 
		 ExtentReport.endReport();
	}

	
	}


