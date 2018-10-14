package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	private WebDriver driver;
	private By title = By.cssSelector(".text-center>h2");
	private By signIn = By.cssSelector("a[href*='sign_in']");
	private By navBar = By.cssSelector(".nav.navbar-nav.navbar-right>li>a");
	
	public LandingPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public WebElement getLogin() {
		
		return this.driver.findElement(this.signIn);
	}
	
	public WebElement getTitle() {
		
		return this.driver.findElement(this.title);
	}
	
	public WebElement getNavBar() {
		
		return this.driver.findElement(this.navBar);
	}
}