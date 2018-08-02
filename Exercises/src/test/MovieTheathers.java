package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class MovieTheathers {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", 
				"/home/edwin/Udemy/SeleniumWebDriver/drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://www.cinepolis.com");
		driver.navigate().refresh();
		Select city = new Select(driver.findElement(
				By.id("cmbCiudades")));
		
		city.selectByVisibleText("Querétaro");
		driver.findElement(By.xpath("/html/body/form/div[3]/header/div[1]/div[2]/div/div[3]/input")).click();
		
		for (WebElement movieTheater : driver.
				findElements(By.className("search-choice"))) {
			String text = movieTheater.findElement(By.tagName("span")).getText();
			
			if(text.contains("VIP") || text.contains("Xtreme")) {
				movieTheater.findElement(By.tagName("a")).click();
				System.out.println("Removed " + text);
			}
		}
	}
}