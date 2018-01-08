package test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", 
				"/home/edwin/Udemy/SeleniumWebDriver/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.spicejet.com");
		
		/*
		 *  These methods can be used with a Select html tag element 
		 */
		Select adultDropdown = new Select(driver.findElement(
				By.id("ctl00_mainContent_ddl_Adult")));
		adultDropdown.selectByValue("2");
		adultDropdown.selectByIndex(6);
		adultDropdown.selectByVisibleText("5");
		
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='GOI']")).click();
		driver.findElement(By.xpath("(//a[@value='DEL'])[2]")).click();
	}
}