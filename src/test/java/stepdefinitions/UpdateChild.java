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

public class UpdateChild {
	private WebDriver driver;
	private LoginLocator lc;
	public UpdateChild() {
		driver = new ChromeDriver();
		lc = new LoginLocator(driver);
	}
	private static final Logger loggerObj = LogManager.getLogger(UpdateChild.class);
	@Given("Open up Website")
	public void open_up_website() {
		driver.manage().window().maximize();
		String url = "https://www.firstcry.com/m/login";
		lc.openPage(url);
		loggerObj.info("user is on login page");
	}

	@When("Login using the email")
	public void login_using_the_email() {
		String email = "mkfbdhvmg@gmail.com";
		lc.sendemail();
	    lc.clickcont();
	    loggerObj.info("user logs in via email");
	}

	@Then("Click on the Profile")
	public void click_on_the_profile() throws InterruptedException {
		Thread.sleep(30000);
		lc.hover();
		lc.clickprofile();
		loggerObj.info("user is on Profile page");
	}

	@Then("Add child details")
	public void add_child_details() throws InterruptedException {
		Thread.sleep(600);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,480)", "");
		lc.clickaddchild();
		lc.updatechild();
		Thread.sleep(1000);
		loggerObj.info("user tries to add child and its details");
	}

	@Then("Verify it is saved")
	public void verify_it_is_saved() {
		boolean present;
		try {
		   driver.findElement(By.xpath("//*[@id=\"ch_defalut\"]"));
		   present = true;
		} catch (NoSuchElementException e) {
		   present = false;
		}
		Assert.assertEquals(true, present);
		loggerObj.info("user has successfully added a child");
		driver.close();
	}
	 @Then ("Delete the child")
	 public void delete_the_child() throws InterruptedException {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,150)", "");
		 lc.clickdeletechild();
		 Thread.sleep(30000);
		 lc.clickconfirmdelete();
		 loggerObj.info("user deletes the child successfully");
		 driver.close();
	 }

}
