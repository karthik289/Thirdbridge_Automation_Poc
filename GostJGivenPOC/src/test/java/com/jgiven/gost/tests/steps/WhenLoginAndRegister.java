package com.jgiven.gost.tests.steps;

import org.openqa.selenium.WebDriver;

import com.google.gson.JsonObject;
import com.jgiven.gost.helpers.CommonScripts;
import com.jgiven.gost.helpers.Configuration;
import com.tngtech.jgiven.Stage;

public class WhenLoginAndRegister extends Stage<WhenLoginAndRegister>{
	WebDriver _driver;
	static JsonObject jsonData;
	static{
		jsonData = Configuration.getJsonData(WhenLoginAndRegister.class);
	}
	public WhenLoginAndRegister User_Navigate_to_LogIn_Page(WebDriver driver) {

		 CommonScripts.isloginsectionDisplayed();
		return self();
	}
	public WhenLoginAndRegister User_enters_Registration_Details(WebDriver driver) {
		String username = jsonData.get("username").getAsString();
		String emailid = jsonData.get("emailid").getAsString();
		String password = jsonData.get("password").getAsString();
		CommonScripts.enterRegisterDetails(username,emailid,password);

		return self();
	}
	public WhenLoginAndRegister User_LogOut_from_the_Application(WebDriver driver) {

		CommonScripts.logOut();
		return self();
	}
	public WhenLoginAndRegister User_enters_UserName_and_Password(WebDriver driver) {
		String username = jsonData.get("emailid").getAsString();
		String password = jsonData.get("password").getAsString();
		CommonScripts.enterUserNameAndPwd(username,password);

		return self();
	}
	
	

}
