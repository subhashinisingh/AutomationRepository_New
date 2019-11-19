package com.actitime.genericLib;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.actitime.ObjectRepoLib.Home;
import com.actitime.ObjectRepoLib.Login;

/**
 * 
 * @author Subhashini
 *
 */

public class BaseClass {
	/*Global Object*/
	public static WebDriver driver;
	public FileLib flib=new FileLib();
	
  @BeforeClass
  public void configBC() throws Throwable {
	  System.out.println("Launch the Browser");
	  /*read browser name from properties file*/
	  String BROWSERNAME = flib.getPropertyFileData("browser");
	  if(BROWSERNAME.equals("firefox")) {
		  driver = new FirefoxDriver();
	  }else if(BROWSERNAME.equals("chrome")) {
		  driver = new ChromeDriver();
	  }else if(BROWSERNAME.equals("ie")) {
		  driver = new InternetExplorerDriver();
	  }else 
	  {
		  driver = new FirefoxDriver();
	  }
  }
  
  @BeforeMethod
  public void configBM() throws Throwable {
	  System.out.println("Login to application");
	  /*read URL, username, password from properties file */
	  String URL = flib.getPropertyFileData("url");
	  String USERNAME = flib.getPropertyFileData("username");
	  String PASSWORD = flib.getPropertyFileData("password");
	  
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(20,  TimeUnit.SECONDS);
	  driver.get(URL);
	  
	  /*create an object to Login POM class */
	  Login lp=PageFactory.initElements(driver, Login.class);
	  lp.loginToApp(USERNAME, PASSWORD);
	  Thread.sleep(2000);
	  
  }
  
  @AfterMethod
  public void configAM() {
	  System.out.println("Logout");
	  /*create an object to HOME POM class */
	  Home hp = PageFactory.initElements(driver, Home.class);
	  hp.logout();
	  
  }
  
  @AfterClass
  public void configAC() {
	  System.out.println("======Close The Browser");
	  driver.close();
	  }
  }
