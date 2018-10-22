import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JdbcConnection {

	public static void main(String[] args) {
		
		String host = "localhost";
		String port = "3306";
		
		try {
			System.setProperty("webdriver.chrome.driver", 
					"/home/edwin/Udemy/SeleniumWebDriver/drivers/chromedriver");
			WebDriver driver = new ChromeDriver();
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://" + host + ":" + port + "/demo?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", 
					"root", "root");
			Statement stm = connection.createStatement();
			
			ResultSet set = stm.executeQuery("select * from credentials where scenario = 'zerobalancecard';");
			driver.get("https://login.salesforce.com");
			
			while (set.next()) {
				driver.findElement(By.xpath("//*[@id='username']")).sendKeys(set.getString("username"));
				driver.findElement(By.xpath("//*[@id='password']")).sendKeys(set.getString("password"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
