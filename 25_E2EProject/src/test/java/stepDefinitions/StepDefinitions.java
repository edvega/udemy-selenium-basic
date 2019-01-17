package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.And;
import cucumber.api.junit.Cucumber;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import pageObjects.PortalHomePage;
import resources.Base;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.testng.Assert;

@RunWith(Cucumber.class)
public class StepDefinitions extends Base {

    @Given("^initialized browser with chrome$")
    public void initialized_browser_with_chrome() throws Throwable {
        Base.driver = initializeDriver();
    }

    @When("^user enters (.+) and (.+) and logs in$")
    public void user_enters_and_and_logs_in(String username, String password) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    	LoginPage login = new LoginPage(Base.driver);
		login.getMail().sendKeys(username);
		login.getPassword().sendKeys(password);
		login.getSubmit().click();
    }
    	

    @Then("^verify that user is successfully logged in$")
    public void verify_that_user_is_successfully_logged_in() throws Throwable {
    	PortalHomePage portal = new PortalHomePage(Base.driver);
    	Assert.assertTrue(portal.getSearchBox().isDisplayed());
    }

    @And("^navigate to \"([^\"]*)\" site$")
    public void navigate_to_something_site(String strArg1) throws Throwable {
    	Base.driver.get(strArg1);
    }

    @And("^click on login link in home page to land on sign in page$")
    public void click_on_login_link_in_home_page_to_land_on_sign_in_page() throws Throwable {
    	LandingPage page = new LandingPage(Base.driver);
		
		String logInPopup = "//*[@id='homepage']/div[5]/div[2]/div/div/div/span/div/div[7]/div/div/div[2]";
		if (!Base.driver.findElements(By.xpath(logInPopup)).isEmpty()) {
			Base.driver.findElement(By.xpath(logInPopup)).click();
		}
		
		page.getLogin().click();
    }
    
    @And("^close browsers$")
    public void close_browsers() throws Throwable {
        Base.driver.quit();
    }

}
