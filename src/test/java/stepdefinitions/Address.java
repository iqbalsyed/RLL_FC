package stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


import com.locator.LoginLocator;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Address {
	private WebDriver driver;
	private LoginLocator lc;
	private static final Logger loggerObj = LogManager.getLogger(Address.class);
	public  Address() {
		driver = new ChromeDriver();
		lc = new LoginLocator(driver);
	}

	@Given("Open up Fc Website and add Login Details")
	public void open_up_website() {
		driver.manage().window().maximize();
		String url = "https://www.firstcry.com/m/login";
		lc.openPage(url);
		loggerObj.info("user is on login page");
		String email = "mkfbdhvmg@gmail.com";
		lc.sendemail();
	    lc.clickcont();
	}

	@Then("Click the Profile")
	public void click_on_the_profile() throws InterruptedException {
		Thread.sleep(30000);
		lc.hover();
		lc.clickprofile();
		loggerObj.info("user is on profile page");
	}

	@Then("^click and Add address as per \\\"([^\\\"]*)\\\"$")
	public void click_and_Add_address(String location) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)", "");
		lc.clickaddaddress();
		// Thread.sleep(200);
		lc.updateaddress(location);
		loggerObj.info("user adds an address");
		Thread.sleep(200);
		lc.saveaddbtn.click();
		loggerObj.info("user tries to save changes");

	}

	@Then("Verify address is saved")
	public void Verify_address_is_saved() throws InterruptedException {
		Thread.sleep(300);
		boolean present;
		try {
			driver.findElement(By.xpath("//span[@class='madd mtit Addrtitle']"));
			present = true;
		} catch (NoSuchElementException e) {
			present = false;
		}
		Assert.assertEquals(true, present);
		loggerObj.info("user is able to save changes successfully");

	}

}
