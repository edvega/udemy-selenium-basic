package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RediffHomePage {

	private WebDriver driver;
	private By searchLink = By.xpath("//*[@id='srch_show_hide_btn']/div[2]/u");
	private By searchBox = By.id("srchword");
	private By searchButton = By.xpath("//*[@id='queryTop']/div/input[6]");
	
	public RediffHomePage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	public WebElement getSearchLink() {
		
		return this.driver.findElement(this.searchLink);
	}
	
	public WebElement getSearchBox() {
		
		return this.driver.findElement(this.searchBox);
	}
	
	public WebElement getSearchButton() {
		
		return this.driver.findElement(this.searchButton);
	}
}
