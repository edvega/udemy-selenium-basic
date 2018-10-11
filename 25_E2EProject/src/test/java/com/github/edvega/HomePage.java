package com.github.edvega;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {

	@Test(dataProvider="getData")
	public void basePageNavigation(String username, String password, String text) {
		
		Base base = new Base();
		base.initializeDriver();
		WebDriver driver = base.getDriver();
		
		driver.get("http://qaclickacademy.com");
		LandingPage page = new LandingPage(driver);
		driver.findElement(By.xpath("//*[@id='homepage']/div[5]/div[2]/div/div/div/span/div/div[7]/div/div/div[2]")).click();
		page.getLogin().click();
		
		LoginPage login = new LoginPage(driver);
		login.getMail().sendKeys(username);
		login.getPassword().sendKeys(password);
		login.getSubmit().click();
		System.out.println(text);
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
}