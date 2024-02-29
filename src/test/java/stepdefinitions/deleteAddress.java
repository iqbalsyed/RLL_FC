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

public class deleteAddress {
	
	private WebDriver driver;
	private LoginLocator lc;
	private static final Logger loggerObj = LogManager.getLogger(deleteAddress.class);
	public  deleteAddress() {
		driver = new ChromeDriver();
		lc = new LoginLocator(driver);
	}
	
	@Given("Open Fc Website and add the Login Details")
	public void open_fc_website_and_add_the_login_details() {
		driver.manage().window().maximize();
		String url = "https://www.firstcry.com/m/login";
		lc.openPage(url);
		loggerObj.info("user is on login page");
		String email = "mkfbdhvmg@gmail.com";
		lc.sendemail();
	    lc.clickcont();
	}

	@Then("Click on the Profile page")
	public void click_on_the_profile_page() throws InterruptedException {
		Thread.sleep(30000);
		lc.hover();
		lc.clickprofile();
		Thread.sleep(300);
		loggerObj.info("user is on profile page");
	}

	@Then("click to delete address")
	public void click_to_delete_address() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,650)", "");
		lc.deladdress.click();
		Thread.sleep(400);
		lc.cofirmdeladdress.click();
		loggerObj.info("user deletes address successfully");
		driver.close();
	}

}
