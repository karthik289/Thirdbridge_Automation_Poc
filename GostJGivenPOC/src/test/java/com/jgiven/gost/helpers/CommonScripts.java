package com.jgiven.gost.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;


public class CommonScripts {

	public static WebDriver driver = null;
	public static  Wait<WebDriver> waitVar = null;
	
	public static void setDriver() {
		driver =Configuration.getInstance().getDriver();
		waitVar =Configuration.getInstance().getWaitVar();
	}
	
	public static void ishomepageDisplayed() {		

		waitVar.until(ExpectedConditions.presenceOfElementLocated(By.id(ObjectRepositories.BT_Sign_In_On_Home_page)));
		driver.findElement(By.id(ObjectRepositories.BT_Sign_In_On_Home_page)).isDisplayed();

	}

	public static void clickSigninLink() {
		driver.findElement((By.id(ObjectRepositories.BT_Sign_In_On_Home_page))).click();
	}

	public static void isloginsectionDisplayed() {
		waitVar.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ObjectRepositories.LBL_Ghost)));
		driver.findElement(By.xpath(ObjectRepositories.LBL_Ghost)).isDisplayed();
	}

	public static void enterRegisterDetails(String username,String emailid,String password) {

		//Lnk_Register
		waitVar.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ObjectRepositories.Lnk_Register)));
		driver.findElement(By.xpath(ObjectRepositories.Lnk_Register)).click();
		//TXT_Name
		waitVar.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ObjectRepositories.TXT_Name)));
		driver.findElement(By.xpath(ObjectRepositories.TXT_Name)).sendKeys(username);
		// Email Adress
		waitVar.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ObjectRepositories.TXT_EmailAddress)));
		driver.findElement(By.xpath(ObjectRepositories.TXT_EmailAddress)).sendKeys(emailid);
		// Password
		waitVar.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ObjectRepositories.TXT_Passowrd)));
		driver.findElement(By.xpath(ObjectRepositories.TXT_Passowrd)).sendKeys(password);
		waitVar.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath(ObjectRepositories.BT_Register)));
		driver.findElement((By.xpath(ObjectRepositories.BT_Register))).click();

	}
	public static void enterUserNameAndPwd(String Id,String password) {
		waitVar.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ObjectRepositories.TXT_EmailAddress)));
		driver.findElement(By.xpath(ObjectRepositories.TXT_EmailAddress)).sendKeys(Id);
		waitVar.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ObjectRepositories.TXT_Passowrd)));
		driver.findElement(By.xpath(ObjectRepositories.TXT_Passowrd)).sendKeys(password);
		waitVar.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath(ObjectRepositories.BT_Sign_In_On_LoginIn_Page)));
		driver.findElement((By.xpath(ObjectRepositories.BT_Sign_In_On_LoginIn_Page))).click();

	}

	public static void isSuccessfulLoginDisplayed() {
		waitVar.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ObjectRepositories.LBL_Head_Content)));
		driver.findElement((By.xpath(ObjectRepositories.LBL_Head_Content))).isDisplayed();
	}

	public static void logOut() {
		waitVar.until(ExpectedConditions.presenceOfElementLocated(By.xpath(ObjectRepositories.BT_Sign_Out)));
		driver.findElement((By.xpath(ObjectRepositories.BT_Sign_Out))).click();

	}
}
