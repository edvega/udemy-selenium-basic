package test;

import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TourExercise {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\workspace\\utils\\drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
	}
	
	
	public void register(WebDriver driver) {
		
		Properties properties = new Properties();
		InputStream input = getClass().getResourceAsStream("/test/data.properties");
		Actions actions = new Actions(driver);
		
		driver.findElement(
				By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]")).click();
		
		actions.click(driver.findElement(By.xpath("//input[@name='firstName']"))).sendKeys()
	}

}
