package resources;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	private WebDriver driver;

	public WebDriver initializeDriver(){
		
		Properties properties = new Properties();
		InputStream file = getClass().getResourceAsStream("data.properties");
				
		try {
			properties.load(file);
			String browser = properties.getProperty("browser");
			
			switch (browser) {
				case "chrome":
					System.setProperty("webdriver.chrome.driver", 
							"/home/edwin/Udemy/SeleniumWebDriver/drivers/chromedriver");
					this.driver = new ChromeDriver();
					break;
				case "firefox":
					System.setProperty("webdriver.gecko.driver", 
							"/home/edwin/Udemy/SeleniumWebDriver/drivers/geckodriver");
					this.driver = new FirefoxDriver();
					break;
				default:
					break;
			}
			
			this.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return this.driver;
	}

	public WebDriver getDriver() {
		
		return this.driver;
	}	
}