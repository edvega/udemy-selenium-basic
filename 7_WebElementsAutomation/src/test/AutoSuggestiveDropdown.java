package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AutoSuggestiveDropdown {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", 
				"/home/edwin/Udemy/SeleniumWebDriver/drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.makemytrip.com/");
		WebElement source = driver.findElement(By.id("hp-widget__sfrom"));
		source.clear();
		source.sendKeys("MUM");
		Thread.sleep(2000);
		source.sendKeys(Keys.ENTER);
		
		WebElement destination = driver.findElement(By.id("hp-widget__sTo"));
		destination.clear();
		destination.sendKeys("DEL");
		Thread.sleep(2000);
		destination.sendKeys(Keys.ARROW_DOWN);
		destination.sendKeys(Keys.ENTER);
	}
}