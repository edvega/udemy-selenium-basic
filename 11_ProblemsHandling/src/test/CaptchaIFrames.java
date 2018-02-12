package test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CaptchaIFrames {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", 
				"/home/edwin/Udemy/SeleniumWebDriver/drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.google.com/recaptcha/api2/demo");
		
		int number = CaptchaIFrames.getIframeNumberOfElement(driver, 
				By.xpath("//*[@id='recaptcha-anchor']/div[5]"));
		driver.switchTo().frame(number);
		driver.findElement(By.xpath("//*[@id='recaptcha-anchor']/div[5]")).click();
	}
	
	public static int getIframeNumberOfElement(WebDriver driver, By by) {
		
		int frameThatHasElement = 0;
		int frameCount = driver.findElements(By.tagName("iframe")).size();
		
		for (int i = 0; i < frameCount; i++) {
			driver.switchTo().frame(i);
			List<WebElement> frames = new ArrayList<WebElement>(driver.findElements(by));
			
			if (frames.size() > 0) {
				frameThatHasElement = i;
				break;
			} else {
				System.out.println("Continue looping. Searching iframe...");
			}
		}
		
		driver.switchTo().defaultContent();
		return frameThatHasElement;
	}
}