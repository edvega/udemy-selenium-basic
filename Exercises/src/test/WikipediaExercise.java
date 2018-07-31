package test;

import java.util.*;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WikipediaExercise {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\workspace\\utils\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Actions actions = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		driver.get("http://en.wikipedia.org/");
		driver.findElement(By.id("searchInput")).click();
		driver.findElement(By.id("searchInput")).sendKeys("Taylor Swift");
		driver.findElement(By.id("searchInput")).sendKeys(Keys.ENTER);
		
		List<String> discography = Arrays.asList("Taylor Swift", "Fearless", 
				"Speak Now", "Red", "1989", "Reputation");
		List<WebElement> albums = driver.findElements(
				By.xpath("//*[@id='mw-content-text']/div/div[17]/table/tbody/tr[3]/td/div/ul/li"));
		
		if (albums.size() == discography.size()) {
			for (WebElement item : albums) {
				String album = item.findElement(By.tagName("a")).getText();
				if(!discography.contains(album)) {
					System.out.println("Album from different artist. Discography not valid.");
					break;
				}
				System.out.println("Album: " + album);
			}
		} else {
			System.out.println("Number of albums distinct to 6.");
		}
		
		actions.moveToElement(driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div/div[17]/table/tbody/tr[3]/td/div/ul/li[6]/i/a")))
				.perform();
		
		if (!driver.findElement(By.xpath(("//div[@class='mwe-popups-container']"))).isDisplayed()) {
			System.out.println("Reputation Album hover message not displayed!");
		} else {
			System.out.println("Hover message visible.");
			System.out.println(driver.findElement(
					By.xpath(("//div[@class='mwe-popups-container']/a/p"))).getText());
		}
	}
}