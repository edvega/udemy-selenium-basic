package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Dropdown {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.gecko.driver", 
				"/home/edwin/Udemy/SeleniumWebDriver/drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.spicejet.com/");
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		for (int i = 0; i < 4; i++) {
			driver.findElement(By.id("hrefIncAdt")).click(); //adults
		}
		
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
	}
}