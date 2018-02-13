package test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Tables {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.gecko.driver", 
				"/home/edwin/Udemy/SeleniumWebDriver/drivers/geckodriver");
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.cricbuzz.com/live-cricket-scorecard/20035/ken-vs-nep-10th-match-icc-world-cricket-league-division-two-2018");
		
		WebElement scoreTable = driver.findElement(
				By.cssSelector("div[class='cb-col cb-col-100 cb-ltst-wgt-hdr']"));
		List<WebElement> scores = new ArrayList<WebElement>(
				scoreTable.findElements(
					By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms'] div:nth-child(3)")));
		
		for (int i = 0; i < (scores.size() - 2); i++) {
			System.out.println(scores.get(i).getText());
		}
	}
}