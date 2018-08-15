package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Cinepolis {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", 
				"/home/edwin/Udemy/SeleniumWebDriver/drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);	
		driver.get("http://www.cinepolis.com");
		Cinepolis movie = new Cinepolis();
		
		movie.selectCity(driver);
		movie.closeVipAndXtremeTheaters(driver);
		//movie.setTimeAndDateForNextDay(driver);
		
	}
	
	public void selectCity(WebDriver driver) {
		
		Select city = new Select(driver.findElement(
				By.id("cmbCiudades")));
		
		city.selectByVisibleText("Querétaro");
		driver.findElement(By.xpath("/html/body/form/div[3]/header/div[1]/div[2]/div/div[3]/input")).click();
	}
	
	
	public void closeVipAndXtremeTheaters(WebDriver driver) {
		
		WebElement theaters = driver.
				findElement(By.className("search-choice"));
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElements(theaters));
		
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
		WebElement sliderTo = driver.findElement(
				By.xpath("//div[@id='slider-range']/a[2]"));
		String timelimit = driver.findElement(By.className("rangoTiempo")).
				getText().split(" - ")[1];
		
		day.selectByIndex(2);
		
		while (!timelimit.contains("10:00 PM"))	{
			action.click(sliderTo).sendKeys(Keys.ARROW_LEFT).build().perform();
		}
	}
}