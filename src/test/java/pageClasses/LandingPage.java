package pageClasses;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import base.BaseClass;
import base.Constants;
import org.testng.Assert;


public class LandingPage extends BaseClass {
	// 1. locators
	// hotels link
	@FindBy(xpath = "//a[@href='/hotels/' and @class='nav-link']")
	private WebElement hotelsLink;

	// Bus link
	@FindBy(xpath = "(//span[contains(text(),'Bus')])[1]")
	private WebElement BusLink;

	// Flights link
	@FindBy(xpath="//a[@href='/flights/' and @class='nav-link active']")
	private WebElement flights;
	
	// 2. Constructor
	public LandingPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// 3. methods
	public void clickOnHotels() {
		hotelsLink.click();
	}

	public void clickOnBus() {
		BusLink.click();
	}
	public void clickOnFlights() {
		flights.click();
	}


	public void launchGoIBiBoWebsite(String browser) {
		if (browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			Map<String, Object> prefs = new HashMap<String, Object>();
			prefs.put("profile.default_content_setting_values.notifications", 2);
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			ChromeOptions options = new ChromeOptions();
			options.setExperimentalOption("prefs", prefs);
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-infobars");
			driver = new ChromeDriver(options);
	
			}
		else if (Constants.browser.equals("ie")) {
			driver= new InternetExplorerDriver();
		}
		driver.get(Constants.testsiteurl);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
	}
	
	public String getPageTitle() {
	return	driver.getTitle();
	}
	
	public void validatePageTitle(String pagetitle) {
			Assert.assertEquals(pagetitle, driver.getTitle());
	}
	
	public void clickOnButton(String buttonName) {
		 if (buttonName == "Hotels")
         { 
          clickOnHotels();
      	}
     	  else if (buttonName == "Flights")
  		{
     		 clickOnFlights();
              }
	}
}
