package com.jgiven.gost.tests.steps;

import org.openqa.selenium.WebDriver;

import com.jgiven.gost.helpers.CommonScripts;
import com.tngtech.jgiven.Stage;

public class ThenLoginRegister extends Stage<ThenLoginRegister> {
	WebDriver _driver;
	public ThenLoginRegister Message_displayed_Register_Successfully(WebDriver driver) {

		CommonScripts.isSuccessfulLoginDisplayed();

		return self();
	}
	public ThenLoginRegister User_Navigate_to_LogIn_Page(WebDriver driver) {

		CommonScripts.isloginsectionDisplayed();
		return self();
	}
	public ThenLoginRegister Message_displayed_Login_Successfully(WebDriver driver) {

		CommonScripts.isSuccessfulLoginDisplayed();

		return self();
	}
	public ThenLoginRegister Message_displayed_LogOut_Successfully(WebDriver driver) {

		CommonScripts.isloginsectionDisplayed();
		return self();
	}

}
