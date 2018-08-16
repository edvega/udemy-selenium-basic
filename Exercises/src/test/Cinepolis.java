package test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Cinepolis {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", 
				"/home/edwin/Udemy/SeleniumWebDriver/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.cinepolis.com");
		Cinepolis movie = new Cinepolis();
		
		movie.selectCity(driver);
		movie.closeVipAndXtremeTheaters(driver);
		movie.setTimeAndDateForNextDay(driver);
	}
	
	public void selectCity(WebDriver driver) {
		
		Select city = new Select(driver.findElement(
				By.id("cmbCiudades")));
		
		city.selectByVisibleText("Querétaro");
		driver.findElement(By.xpath("/html/body/form/div[3]/header/div[1]/div[2]/div/div[3]/input")).click();
	}
	
	
	public void closeVipAndXtremeTheaters(WebDriver driver) {
				
		for (WebElement movieTheater : driver.
				findElements(By.className("search-choice"))) {
			String text = movieTheater.findElement(By.tagName("span")).getText();
			
			if(text.contains("VIP") || text.contains("Xtreme")) {
				movieTheater.findElement(By.tagName("a")).click();
				System.out.println("Removed " + text);
			}
		}
		
		
	}
	
	
	public void setTimeAndDateForNextDay(WebDriver driver) {
		
		Actions action = new Actions(driver);
		Select day = new Select(driver.findElement(By.id("cmbFechas")));
		WebElement sliderTo = driver.findElement(By.xpath("//div[@id='slider-range']/a[2]"));
		WebElement sliderFrom = driver.findElement(By.xpath("//div[@id='slider-range']/a"));
		String timelimit = driver.findElement(By.className("rangoTiempo")).	getText();
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
		String timeFrom = timelimit.split(" - ")[0];
		LocalTime from = LocalTime.parse(timeFrom, formatter);
				
		day.selectByIndex(2);
		
		if (from.isAfter(LocalTime.parse("10:00 PM", formatter))) {
			while (!timeFrom.contains("7:00 PM")) {
				action.click(sliderFrom).sendKeys(Keys.ARROW_LEFT).build().perform();
			}
		}
		
		while (!timelimit.split(" - ")[1].contains("10:00 PM"))	{
			action.click(sliderTo).sendKeys(Keys.ARROW_LEFT).build().perform();
		}
	}
}