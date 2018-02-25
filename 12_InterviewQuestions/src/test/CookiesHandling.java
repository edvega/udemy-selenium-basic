package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CookiesHandling {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", 
				"/home/edwin/Udemy/SeleniumWebDriver/drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookieNamed("asdf");
		//click on any link
		//login page - verify login url
	}
}