package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ImplicitWait {

	public static void main(String[] args) {
	
		System.setProperty("webdriver.gecko.driver", 
				"/home/edwin/Udemy/SeleniumWebDriver/drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.alaskaair.com");
		
		driver.findElement(By.id("tab-hotels")).click();
		driver.findElement(By.id("hotelOnlyToLocation")).sendKeys("nyc");
		driver.findElement(By.id("hotelOnlyToLocation")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("hotelOnlyToLocation")).sendKeys(Keys.TAB);
		driver.findElement(By.id("hotelFromDate")).sendKeys(Keys.ENTER);		
		driver.findElement(By.xpath("/html/body/div[4]/form/div[11]/div[2]/div[13]/section/div/div[16]/section/article[1]/div[2]/div[1]/a")).click();
		
	}
}