package com.github.edvega;

import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {

	private Base base = new Base();
	private static Logger log = LogManager.getLogger(HomePage.class.getName());
	
	@BeforeTest
	public void initialize() {
		
		this.base.initializeDriver();
	}
	
	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String password, String text) {
		
		this.base.getDriver().get(this.base.getHomeUrl());
		WebDriver driver = this.base.getDriver();
		LandingPage page = new LandingPage(driver);
		
		String logInPopup = "//*[@id='homepage']/div[5]/div[2]/div/div/div/span/div/div[7]/div/div/div[2]";
		if (!driver.findElements(By.xpath(logInPopup)).isEmpty()) {
			driver.findElement(By.xpath(logInPopup)).click();
		}
		
		page.getLogin().click();
		
		LoginPage login = new LoginPage(driver);
		login.getMail().sendKeys(username);
		login.getPassword().sendKeys(password);
		login.getSubmit().click();
		System.out.println(text);
		log.info(text);
	}
	
	@DataProvider
	public Object[][] getData() {
		
		Object[][] data = new Object[2][3];
		data[0][0] = "bc@qa.com";
		data[0][1] = "12345";
		data[0][2] = "Restricted user";
		
		data[1][0] = "restricted@qa.com";
		data[1][1] = "67890";
		data[1][2] = "Non Restricted user";
		
		return data;
	}
	
	@AfterTest
	public void tearDown() {
		
		this.base.tearDown(this.base.getDriver());
	}
}