package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "/home/edwin/Udemy/SeleniumWebDriver/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cleartrip.com");
		
		driver.findElement(By.id("DepartDate")).click();
		driver.findElement(By.cssSelector("a.ui-state-default.ui-state-highlight.ui-state-active")).click();
		
		Select adults = new Select(driver.findElement(By.id("Adults")));
		adults.selectByValue("3");
		
		Select children = new Select(driver.findElement(By.id("Childrens")));
		children.selectByValue("4");
		
		Select infants = new Select(driver.findElement(By.id("Infants")));
		infants.selectByValue("1");
		
		driver.findElement(By.id("MoreOptionsLink")).click();
		Thread.sleep(2000);
		Select travelClass  = new Select(driver.findElement(By.id("Class")));
		travelClass.selectByValue("Business");
		
		driver.findElement(By.id("AirlineAutocomplete")).sendKeys("american");
		driver.findElement(By.id("SearchBtn")).click();
		
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());
	}
}