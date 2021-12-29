

package stepDefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageClasses.LandingPage;

public class CommonStepDefinitions {
	        WebDriver driver;
	
		     private LandingPage landingPage = new LandingPage(driver);
		   

		    @Given("^I launch the '(.*)' Browser and navigate to Webpage$")
		    public void i_launch_the_browser_and_navigate_to_webpage(String browser) throws Throwable {
		    	 landingPage.launchGoIBiBoWebsite(browser);
		    }
		
		    @When("I verify the '(.*)' Page is displayed$")
		    public void i_select_india_and_enter_city_name(String pagetitle) throws Throwable {
		    	landingPage.validatePageTitle(pagetitle);
		    }

        	@Then("I click on {string} Button")
        	public void i_click_on_button(String buttonName) {
        		System.out.println("inside unmapped page");
        	    landingPage.clickOnButton(buttonName);
        	}
    		
        }
    