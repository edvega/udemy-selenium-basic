package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", 
				"/home/edwin/Udemy/SeleniumWebDriver/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.alaskaair.com");
		
		driver.findElement(By.xpath("//*[@id='tab-hotels']")).click();
		
		driver.findElement(By.xpath("//*[@id='hotelOnlyToLocation']")).sendKeys("NYC");
		driver.findElement(By.id("hotelOnlyToLocation")).sendKeys(Keys.TAB);
		
		driver.findElement(By.id("hotelFromDate")).sendKeys(Keys.ENTER);
		
		WebDriverWait d = new WebDriverWait(driver, 20);
		d.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[4]/form/div[11]/div[2]/div[13]/section/div/div[16]/section/article[1]/div[2]/div[1]/a")));

		driver.findElement(By.xpath("/html/body/div[4]/form/div[11]/div[2]/div[13]/section/div/div[16]/section/article[1]/div[2]/div[1]/a")).click();
		
	}
}