package com.github.edvega;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateNavBar {

	private Base base = new Base();
	private static Logger log = LogManager.getLogger(ValidateNavBar.class.getName());
	
	@BeforeTest
	public void initialize() {
		
		this.base.initializeDriver();
		Base.driver.get(this.base.getHomeUrl());
	}
	
	@Test
	public void validateNavigationBar() {
		
		LandingPage page = new LandingPage(Base.driver);
		Assert.assertTrue(page.getNavBar().isDisplayed());
		log.info("Navigation Bar is displayed");
	}
	
	@AfterTest
	public void tearDown() {
		
		this.base.tearDown();
	}
}