package com.github.edvega;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class HomePage extends Base {

	@Test
	public void basePageNavigation() {
		
		Base base = new Base();
		base.initializeDriver();
		WebDriver driver = base.getDriver();
		
		driver.get("http://qaclickacademy.com");
		LandingPage page = new LandingPage(driver);
		driver.findElement(By.xpath("//*[@id='homepage']/div[5]/div[2]/div/div/div/span/div/div[7]/div/div/div[2]")).click();
		page.getLogin().click();
		
		LoginPage login = new LoginPage(driver);
		login.getMail().sendKeys("as@asd.com");
		login.getPassword().sendKeys("123123123");
		login.getSubmit().click();
	}	
}