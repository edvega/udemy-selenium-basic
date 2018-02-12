package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutocompleteTextBox {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", 
				"/home/edwin/Udemy/SeleniumWebDriver/drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.google.com");
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		driver.findElement(By.id("lst-ib")).sendKeys("thermo");
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("/html/body/div/div[3]/form/div[2]/div[2]/div[1]/div[2]")));
		
		driver.findElement(By.id("lst-ib")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.id("lst-ib")).sendKeys(Keys.ENTER);
	}
}