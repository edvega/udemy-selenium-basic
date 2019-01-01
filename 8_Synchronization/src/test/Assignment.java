package test;

import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Assignment {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/home/edwin/Udemy/SeleniumWebDriver/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/jquery/tryit.asp?filename=tryjquery_ajax_ajaxcomplete");
		
		driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
		
		driver.findElement(By.tagName("button")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textMatches(By.id("txt"), Pattern.compile("art")));
		
		System.out.println(driver.findElement(By.id("txt")).getText());
	}
}