package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Exercise1 {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", 
				"/home/edwin/Udemy/SeleniumWebDriver/drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.ebay.com");
		
		//Count of links in entire web page
		System.out.println("Links in the page:");
		System.out.println(driver.findElements(By.tagName("a")).size());
		
		//Links in the footer section
		System.out.println("Links in footer section:");
		WebElement footer = driver.findElement(By.id("glbfooter"));
		System.out.println(footer.findElements(By.tagName("a")).size());
	}
}