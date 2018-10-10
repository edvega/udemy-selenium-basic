package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	private WebDriver driver;
	private By email = By.xpath("//input[@id='user_email']");
	private By password = By.xpath("//*[@id='user_password']");
	private By submit = By.xpath("//input[@type='submit']");
	
	public LoginPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public WebElement getMail() {
		
		return this.driver.findElement(this.email);
	}
	
	public WebElement getPassword() {
		
		return this.driver.findElement(this.password);
	}
	
	public WebElement getSubmit() {
		
		return this.driver.findElement(this.submit);
	}
}
