package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CalendarUIHandler {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", 
				"/home/edwin/Udemy/SeleniumWebDriver/drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.path2usa.com/travel-companions");
		driver.findElement(By.xpath("//*[@id='travel_date']")).click();
		
		while (!driver.findElement(
				By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).
				getText().contains("April")) {
			driver.findElement(
					By.cssSelector("[class='datepicker-days'] [class='next']")).click();
		}
		
		List<WebElement> days = driver.findElements(By.className("day"));
		
		for (WebElement day : days) {
			if (day.getText().equals("25")) {
				day.click();
				break;
			}
		}
	}
}