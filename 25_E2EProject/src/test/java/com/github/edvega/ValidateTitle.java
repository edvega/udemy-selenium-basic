package com.github.edvega;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateTitle {

	private Base base = new Base();
	private static Logger log = LogManager.getLogger(ValidateTitle.class.getName());
	
	@BeforeTest
	public void initialize() {
		
		this.base.initializeDriver();
		log.info("Driver is initialized");
		Base.driver.get(this.base.getHomeUrl());
		log.info("Navigated to Home Page");
	}
	
	@Test
	public void validateAppTItle() {
		
		LandingPage page = new LandingPage(Base.driver);
		Assert.assertEquals(page.getTitle().getText(), "FEATURED COURSE");
		log.info("Successfully validated Text message");
	}
	
	@AfterTest
	public void tearDown() {
		
		this.base.tearDown();
	}
}