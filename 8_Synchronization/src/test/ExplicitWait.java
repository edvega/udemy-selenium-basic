package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", 
				"/home/edwin/Udemy/SeleniumWebDriver/drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.alaskaair.com");
		
		driver.findElement(By.id("tab-hotels")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hotelFromDate")));
		driver.findElement(By.id("hotelOnlyToLocation")).sendKeys("NYC");
		
		wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[17]/ul")));
		driver.findElement(By.id("hotelOnlyToLocation")).sendKeys(Keys.TAB);
		driver.findElement(By.id("hotelFromDate")).sendKeys(Keys.ENTER);
		
		wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/div[4]/form/div[11]/div[2]/div[13]/section/div/div[16]/section/article[1]/div[2]/div[1]/a")));
		
		driver.findElement(By.xpath("/html/body/div[4]/form/div[11]/div[2]/div[13]/section/div/div[16]/section/article[1]/div[2]/div[1]/a")).click();
	}
}