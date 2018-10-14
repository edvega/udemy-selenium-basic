package resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public static WebDriver driver;
	private String homeUrl;

	public WebDriver initializeDriver(){
		
		Properties properties = new Properties();
		InputStream file = getClass().getResourceAsStream("data.properties");
				
		try {
			properties.load(file);
			String browser = properties.getProperty("browser");
			this.homeUrl = properties.getProperty("url");
			
			switch (browser) {
				case "chrome":
					System.setProperty("webdriver.chrome.driver", 
							"/home/edwin/Udemy/SeleniumWebDriver/drivers/chromedriver");
					Base.driver = new ChromeDriver();
					break;
				case "firefox":
					System.setProperty("webdriver.gecko.driver", 
							"/home/edwin/Udemy/SeleniumWebDriver/drivers/geckodriver");
					Base.driver = new FirefoxDriver();
					break;
				default:
					break;
			}
			
			System.out.println(browser);
			Base.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return Base.driver;
	}
	
	public String getHomeUrl() {
		
		return this.homeUrl;
	}
	
	public void tearDown() {
		
		if (Base.driver != null) {
			try {
				Base.driver.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			Base.driver = null;
		}
	}
	
	public void getScreenshot(String testName) {
		
		File img = ((TakesScreenshot) Base.driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(img, new File("resources/" + testName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}