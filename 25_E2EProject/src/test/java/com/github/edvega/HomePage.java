package com.github.edvega;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class HomePage extends Base{

	@Test
	public void basePageNavigation() {
		
		Base base = new Base();
		base.initializeDriver();
		WebDriver driver = base.getDriver();
		
		driver.get("http://qaclickacademy.com");
	}
}