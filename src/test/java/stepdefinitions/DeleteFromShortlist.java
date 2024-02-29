package stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.locator.LoginLocator;
import com.locator.PreSchool;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class DeleteFromShortlist {
	private WebDriver driver;
	private LoginLocator lc;
	//LoginLocator lc = PageFactory.initElements(driver, LoginLocator.class);
	private static final Logger loggerObj = LogManager.getLogger(DeleteFromShortlist.class);
	public  DeleteFromShortlist() {
		driver = new ChromeDriver();
		lc = new LoginLocator(driver);
	}
	@Given("Open the firstCry Website")
	public void open_the_first_cry_website() {
		driver.manage().window().maximize();
		String url = "https://www.firstcry.com/m/login";
		lc.openPage(url);
		loggerObj.info("user is on login page");
	}

	@Then("Use email to login")
	public void use_email_to_login() throws InterruptedException {
		String email = "mkfbdhvmg@gmail.com";
		lc.sendemail();
	    lc.clickcont();
	    Thread.sleep(30000);
	    loggerObj.info("user logs in ");
	}

	@Then("Click on shortlist and delete product")
	public void click_on_shortlist_and_delete_product() throws InterruptedException {
		lc.hover();
		Thread.sleep(200);
		lc.clickshortlist.click();
		Thread.sleep(500);
		lc.delfromshortlist.click();
		loggerObj.info("user deletes product from shortlist");
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(500);
		loggerObj.info("user clicks OK on the popup");
	}

	@Then("Verify product is deleted")
	public void verify_product_is_deleted() {
		boolean present;
		try {
		   driver.findElement(By.xpath("//*[@id=\"StartShopping\"]"));
		   present = true;
		} catch (NoSuchElementException e) {
		   present = false;
		}
		Assert.assertEquals(true, present);
		loggerObj.info("user has successfully deleted product from shortlist");
		driver.close();
	}


}
