package test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class TourExercise {

	private static final String HOME = "http://www.newtours.demoaut.com/";
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", 
				"/home/edwin/Udemy/SeleniumWebDriver/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(HOME);
		
		TourExercise t = new TourExercise();
		t.register(driver);
		t.signIn(driver);
		t.findFlight(driver);
	}
	
	
	public void register(WebDriver driver) {
		
		Properties properties = new Properties();
		InputStream input = getClass().getResourceAsStream("/test/data.properties");
		Actions actions = new Actions(driver);
		
		driver.findElement(
				By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a")).click();
		
		WebElement firstName = driver.findElement(By.xpath("//input[@name='firstName']"));
		WebElement lastName = driver.findElement(By.xpath("//input[@name='lastName']"));
		WebElement phone = driver.findElement(By.xpath("//input[@name='phone']"));
		WebElement email = driver.findElement(By.xpath("//input[@name='userName']"));
		WebElement address = driver.findElement(By.xpath("//input[@name='address1']"));
		WebElement city = driver.findElement(By.xpath("//input[@name='city']"));
		WebElement state = driver.findElement(By.xpath("//input[@name='state']"));
		WebElement zip = driver.findElement(By.xpath("//input[@name='postalCode']"));
		Select country = new Select(driver.findElement(By.xpath("//select[@name='country']")));
		WebElement user = driver.findElement(By.xpath("//input[@name='email']"));
		WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement confirmUser = driver.findElement(By.xpath("//input[@name='confirmPassword']"));
		WebElement submit = driver.findElement(By.xpath("//input[@name='register']"));
		
		try {
			properties.load(input);
			actions.click(firstName).sendKeys(properties.getProperty("first_name")).perform();
			actions.click(lastName).sendKeys(properties.getProperty("last_name")).perform();
			actions.click(phone).sendKeys(properties.getProperty("phone")).perform();
			actions.click(email).sendKeys(properties.getProperty("email")).perform();
			actions.click(address).sendKeys(properties.getProperty("address")).perform();
			actions.click(city).sendKeys(properties.getProperty("city")).perform();
			actions.click(state).sendKeys(properties.getProperty("state")).perform();
			actions.click(zip).sendKeys(properties.getProperty("zip")).perform();
			country.selectByValue(properties.getProperty("country"));
			actions.click(user).sendKeys(properties.getProperty("user")).perform();
			actions.click(pass).sendKeys(properties.getProperty("pass")).perform();
			actions.click(confirmUser).sendKeys(properties.getProperty("user")).perform();
			actions.click(submit).perform();
			
			if (driver.findElements(
					By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td"
							+ "/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b")).
					isEmpty()) {
				System.out.println("Register FAILED!");
			} else if (driver.findElement(
					By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td"
							+ "/table/tbody/tr/td[2]/table/tbody/tr[3]/td/p[3]/a/font/b")).
					getText().equals(
							"Note: Your user name is " + 
							properties.getProperty("user") + ".")) {
				System.out.println("Register PASSED.");
			} else {
				System.out.println("Register FAILED!");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
	public void signIn(WebDriver driver) {
		
		Properties properties = new Properties();
		InputStream input = getClass().getResourceAsStream("/test/data.properties");
		Actions actions = new Actions(driver);
		
		driver.get(HOME);
		WebElement user = driver.findElement(By.xpath("//input[@name='userName']"));
		WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
		WebElement submit = driver.findElement(By.xpath("//input[@name='login']"));
		
		try {
			properties.load(input);
			actions.click(user).sendKeys(properties.getProperty("mercury_user")).perform();
			actions.click(pass).sendKeys(properties.getProperty("mercury_pass")).perform();
			actions.click(submit).perform();
			
			if (driver.findElements(
					By.xpath("//img[@src='/images/masts/mast_flightfinder.gif']")).
					isEmpty()) {
				System.out.println("Sign in FAILED!");
				return;
			}
			System.out.println("Sign in PASSED.");			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void findFlight(WebDriver driver) {
		
		Properties properties = new Properties();
		InputStream input = getClass().getResourceAsStream("/test/data.properties");
		Actions actions = new Actions(driver);
		
		Select fromPort  = new Select(driver.findElement(By.xpath("//select[@name='fromPort']")));
		Select fromMonth  = new Select(driver.findElement(By.xpath("//select[@name='fromMonth']")));
		Select fromDay  = new Select(driver.findElement(By.xpath("//select[@name='fromDay']")));
		Select toPort  = new Select(driver.findElement(By.xpath("//select[@name='toPort']")));
		Select toMonth  = new Select(driver.findElement(By.xpath("//select[@name='toMonth']")));
		Select toDay  = new Select(driver.findElement(By.xpath("//select[@name='toDay']")));
		WebElement serviceClass = driver.findElement(By.xpath("//input[@value='First']"));
		Select airline = new Select(driver.findElement(By.xpath("//select[@name='airline']")));
		WebElement submit = driver.findElement(By.xpath("//input[@name='findFlights']"));
		
		try {
			properties.load(input);
			fromPort.selectByValue(properties.getProperty("from_port"));
			fromMonth.selectByValue(properties.getProperty("from_month"));
			fromDay.selectByValue(properties.getProperty("from_day"));
			toPort.selectByValue(properties.getProperty("to_port"));
			toMonth.selectByValue(properties.getProperty("to_month"));
			toDay.selectByValue(properties.getProperty("to_day"));
			actions.click(serviceClass).perform();
			airline.selectByVisibleText(properties.getProperty("airline"));
			actions.click(submit).perform();
			
			if (driver.findElements(
					By.xpath("//img[@src='/images/masts/mast_selectflight.gif']")).
					isEmpty()) {
				System.out.println("Find flight FAILED!");
				return;
			}
			System.out.println("Find flight PASSED.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void selectFlight(WebDriver driver) {
		
		
	}
}
