package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import objects.RediffHomePagePF;
import objects.RediffLoginPage;

public class LoginApp {

	/*
	 * RediffLoginPage implemented in normal POM pattern style
	 * RediffHomePagePF implemented with POM factory methods
	 */
	@Test
	public void login(){
		
		System.setProperty("webdriver.chrome.driver", 
				"/home/edwin/Udemy/SeleniumWebDriver/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		RediffLoginPage login = new RediffLoginPage(driver);
		login.getEmailId().sendKeys("hello");
		login.getPassword().sendKeys("hello!");
		login.getSubmit().click();
		login.getHome().click();
		
		RediffHomePagePF home = new RediffHomePagePF(driver);
		home.getSearchLink().click();
		home.getSearchBox().click();
		home.getSearchBox().sendKeys("bike");
		home.getSearchButton().click();
	}
}
