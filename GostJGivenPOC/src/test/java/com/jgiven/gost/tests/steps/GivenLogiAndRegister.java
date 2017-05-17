package com.jgiven.gost.tests.steps;

import org.openqa.selenium.WebDriver;

import com.jgiven.gost.helpers.CommonScripts;
import com.tngtech.jgiven.Stage;

public class GivenLogiAndRegister extends Stage<GivenLogiAndRegister>{

	public GivenLogiAndRegister User_is_on_Home_Page() {

		CommonScripts.ishomepageDisplayed();
		CommonScripts.clickSigninLink();		
		return self();
	}
}
