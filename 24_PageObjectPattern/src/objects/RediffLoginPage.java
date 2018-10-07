package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffLoginPage {

	private WebDriver driver;
	private By username = By.xpath("//*[@id='login1']");
	private By password = By.name("passwd");
	private By submit = By.name("proceed");
	private By home = By.linkText("Home");
	
	public RediffLoginPage(WebDriver driver){
		
		this.driver = driver;
	}
	
	public WebElement getEmailId(){
		
		return this.driver.findElement(this.username);
	}
	
	public WebElement getPassword(){
		
		return this.driver.findElement(this.password);
	}
	
	public WebElement getSubmit(){
		
		return this.driver.findElement(this.submit);
	}
	
	public WebElement getHome(){
		
		return this.driver.findElement(this.home);
	}
}
