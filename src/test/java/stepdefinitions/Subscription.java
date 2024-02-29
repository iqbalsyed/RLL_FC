package stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.locator.LoginLocator;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Subscription {
	private WebDriver driver;
	private LoginLocator lc;
	public Subscription() {
		driver = new ChromeDriver();
		lc = new LoginLocator(driver);
	}
	
	private static final Logger loggerObj = LogManager.getLogger(Subscription.class);
	
	
	@Given("Open Firstcry Website and Login Details")
	public void open_firstcry_website_and_login_details() {
		driver.manage().window().maximize();
		String url = "https://www.firstcry.com/m/login";
		lc.openPage(url);
		loggerObj.info("User is on Login Page");
		String email = "mkfbdhvmg@gmail.com";
		lc.sendemail();
	    lc.clickcont();
	}

	@Then("Click on My Profile page")
	public void click_on_my_profile_page() throws InterruptedException {
		Thread.sleep(30000);
		lc.hover();
		lc.clickprofile();
		Thread.sleep(300);
		loggerObj.info("user is on Profile Page");
	}

	@Then("Click to manage subscription details")
	public void click_to_manage_subscription_details() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(300);
		lc.topoffer.click();
		lc.topdeals.click();
		loggerObj.info("User is able to manipulate subscriptions");
		driver.close();
	    
	}


}
