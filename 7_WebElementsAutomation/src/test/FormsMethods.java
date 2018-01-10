package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormsMethods {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", 
				"/home/edwin/Udemy/SeleniumWebDriver/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.makemytrip.com/");
		
		System.out.println("Before clicking Multi city radio button");
		System.out.println(driver.findElement(
				By.xpath("//*[@id='hp-widget__return']")).isDisplayed());
		driver.findElement(By.xpath("//div[@id='multicity']")).click();
		
		System.out.println("Before clicking Multi city radio button");
		System.out.println(driver.findElement(
				By.id("hp-widget__return")).isDisplayed());
	}
}