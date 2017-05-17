package com.jgiven.gost.helpers;

import java.io.File;
import java.io.FileReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Configuration {
	 WebDriver driver;
	 Wait<WebDriver> waitVar ;
	 private static Configuration config= new Configuration();
	 private Configuration() {
		
	}
	 public static Configuration getInstance(){
		return config;
	}
	public WebDriver getDriver() {
		return driver;
	}
	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}
	 
	 
	public Wait<WebDriver> getWaitVar() {
		return waitVar;
	}
	public void setWaitVar(Wait<WebDriver> waitVar) {
		this.waitVar = waitVar;
	}
	public static JsonObject getJsonData(Class clazz){
		try{String classname = clazz.getName();
		String fileName = classname.substring(classname.lastIndexOf(".")+1, classname.length());
		JsonParser parser = new JsonParser();
		System.out.println("*********filename******"+"./Resources/"+fileName+".json");
		File datafile = new File("./Resources/"+fileName+".json");
		JsonObject jsonData = (JsonObject)parser.parse(new FileReader(datafile));
		return jsonData;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	 
	 

}
