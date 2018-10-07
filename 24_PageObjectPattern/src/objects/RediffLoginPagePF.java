package objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffLoginPagePF {

	private WebDriver driver;
		
	@FindBy(xpath="//*[@id='login1']")
	private WebElement username;
	
	@FindBy(name="passwd")
	private WebElement password;
	
	@FindBy(name="proceed")
	private WebElement submit;
	
	@FindBy(linkText="Home")
	private WebElement home;
	
	public RediffLoginPagePF(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getEmailId(){
		
		return username;
	}
	
	public WebElement getPassword(){
		
		return password;
	}
	
	public WebElement getSubmit(){
		
		return submit;
	}
	
	public WebElement getHome(){
		
		return home;
	}
}
