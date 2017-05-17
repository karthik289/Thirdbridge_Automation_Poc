package com.jgiven.gost.tests;

import java.io.File;
import java.io.FileInputStream;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.jgiven.gost.helpers.CommonScripts;
import com.jgiven.gost.helpers.Configuration;
import com.jgiven.gost.tests.steps.GivenLogiAndRegister;
import com.jgiven.gost.tests.steps.ThenLoginRegister;
import com.jgiven.gost.tests.steps.WhenLoginAndRegister;
import com.jgiven.testrails.postdata.PostResults;
import com.tngtech.jgiven.testng.ScenarioTest;

public class LoginRegisterTest extends ScenarioTest<GivenLogiAndRegister, WhenLoginAndRegister, ThenLoginRegister> {

	WebDriver driver;
	Wait<WebDriver> waitVar = null;
	public Properties config = new Properties();
	public static String baseURL = "https://ghost.org/";
	@BeforeTest
	public void initBrowser() {
		try{		
			System.out.println("unal");
		File configFile= new File("./Resources/config.properties");
		if(configFile.exists()){
				config.load(new FileInputStream(configFile));
			if(config.containsKey("browser")){
				if(config.getProperty("browser").equalsIgnoreCase("firefox")){
					driver = new FirefoxDriver(); 	
				}else if(config.getProperty("browser").equalsIgnoreCase("panthom")){
					String[] phantomArgs = new  String[] {"--webdriver-loglevel=NONE"};			
					DesiredCapabilities cap= DesiredCapabilities.phantomjs();
					cap.setCapability("phantomjs.page.settings.userAgent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/53 (KHTML, like Gecko) Chrome/15.0.87");
					cap.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, phantomArgs);
					File file  = new File("./Resources/phantomjs.exe");  
					if(System.getProperty("os.name").toLowerCase().contains("linux")){
						file  = new File("./Resources/phantomjs");  
					}
					System.setProperty("phantomjs.binary.path", file.getAbsolutePath());
					driver = new PhantomJSDriver(cap);
				}
			}
		}else{
			driver = new FirefoxDriver(); 	
		}
		Configuration.getInstance().setDriver(driver);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		waitVar = new FluentWait<WebDriver>(driver)							
				.withTimeout(30, TimeUnit.SECONDS) 			
				.pollingEvery(5, TimeUnit.SECONDS) 			
				.ignoring(NoSuchElementException.class);
		Configuration.getInstance().setWaitVar(waitVar);
		CommonScripts.setDriver();
		driver.get(baseURL);
	}catch (Exception e) {
		e.printStackTrace();
	}
	}

	@Test
	public void RegisterintoGost() {

		given().User_is_on_Home_Page();
		when().User_Navigate_to_LogIn_Page(driver);
		when().User_enters_Registration_Details(driver);
		then().Message_displayed_Register_Successfully(driver);
	}
	@Test
	public void SuccessfulLogOut() {

		when().User_LogOut_from_the_Application(driver);
		then().User_Navigate_to_LogIn_Page(driver);
	}
	@Test
	public void SuccessfulLoginwithValidCredentials() {

		given().User_is_on_Home_Page();
		when().User_Navigate_to_LogIn_Page(driver);
		when().User_enters_UserName_and_Password(driver);
		then().Message_displayed_Login_Successfully(driver);

	}
	@Test
	public void SuccessfulLogOutAfterLogin() {

		when().User_LogOut_from_the_Application(driver);
		then().User_Navigate_to_LogIn_Page(driver);
	}

	@AfterTest
	public void tearDown() {
		try{
		driver.quit();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
