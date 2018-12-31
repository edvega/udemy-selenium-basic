package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/home/edwin/Udemy/SeleniumWebDriver/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://qaclickacademy.com/practice.php");
		
	driver.findElement(By.id("checkBoxOption1")).click();
	System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
	
	driver.findElement(By.id("checkBoxOption1")).click();
	System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());
	
	System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
	}
}