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

public class Contact {
	private WebDriver driver;
	private LoginLocator lc;
	public  Contact() {
		driver = new ChromeDriver();
		lc = new LoginLocator(driver);
	}
	private static final Logger loggerObj  = LogManager.getLogger(Contact.class);
	
	@Given("Open fc Website and do login")
	public void open_fc_website_and_do_login() {
		driver.manage().window().maximize();
		String url = "https://www.firstcry.com/m/login";
		lc.openPage(url);
		loggerObj.info("user is on login page");
		String email = "mkfbdhvmg@gmail.com";
		lc.sendemail();
	    lc.clickcont();
	}

	@Then("Navigate to My Profile")
	public void navigate_to_my_profile() throws InterruptedException {
		Thread.sleep(30000);
		lc.hover();
		lc.clickprofile();
		loggerObj.info("user is on My Profile page");
	}

	@Then("update contact {string}")
	public void update_contact_number(String number) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,80)", "");
		lc.clickeditcontact();
		Thread.sleep(400);
		lc.addcontact.clear();
		lc.sendcontact(number);
		lc.clicksavecontact();
		Thread.sleep(2000);
		loggerObj.info("user updates the contact");
	}

	@Then("verify it gets passed")
	public void verify_it_gets_passed() {
		loggerObj.info("user is trying to verify submit otp page");
		boolean present;
		try {
		   driver.findElement(By.xpath("//*[@id='otpsubmit']"));  //submit otp
		   driver.findElement(By.xpath("//span[@class='R14_link cur-point']"));   //resend otp
		   driver.findElement(By.xpath("//span[@class='otp-popup-close']"));           //close otp popup
		   present = true;
		} catch (NoSuchElementException e) {
		   present = false;
		   Assert.assertFalse(present);
		   driver.close();
		}
		Assert.assertEquals(true, present);
		loggerObj.info("user verifies the updation");
		driver.close();
	}
	
}
