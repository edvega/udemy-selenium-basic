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
		
		System.out.println("After clicking Multi city radio button");
		System.out.println(driver.findElement(
				By.id("hp-widget__return")).isDisplayed());
		
		driver.findElement(By.xpath("//*[@id='hp-widget__depart']")).click();
		driver.findElement(
				By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[3]/div/div[1]/table/tbody/tr[4]/td[7]")).click();
		driver.findElement(By.xpath("//*[@id='hp-widget__paxCounter']")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[9]/div[1]/div[1]/div[2]/ul/li[5]")).click();
		driver.findElement(By.xpath("/html/body/div[2]/div[3]/div[3]/div/div[9]/div[1]/a")).click();
		
		System.out.println(driver.findElement(
				By.xpath("//div[@id='fd-wrap']/div[2]/h2")).getText());
		
		/*
		 * findElement().isDisplayed() works when an element is present in the
		 * code but not visible.
		 * Validate if an object is present in web page or code base by using
		 * findElements().size()
		 */
		int count = driver.findElements(By.xpath("//*[@id='hp-widget']")).size();
		
		if (count == 0) {
			System.out.println("Element does not exist!");
		}
	}
}