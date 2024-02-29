package stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.locator.LoginLocator;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class MovetoCart {
	
	private WebDriver driver;
	private LoginLocator lc;
	public MovetoCart() {
		driver = new ChromeDriver();
		lc = new LoginLocator(driver);
	}
	private static final Logger loggerObj = LogManager.getLogger(MovetoCart.class);
	
	@Given("Open  firstCry Website")
	public void open_first_cry_website() {
		driver.manage().window().maximize();
		String url = "https://www.firstcry.com/m/login";
		lc.openPage(url);
		loggerObj.info("user is on Login page");
	}

	@Then("Use email for login")
	public void use_email_for_login() throws InterruptedException {
		String email = "mkfbdhvmg@gmail.com";
		lc.sendemail();
	    lc.clickcont();
	    Thread.sleep(30000);
	    loggerObj.info("user waits for manual otp login");
	}

	@Then("Click on shortlist and move product")
	public void click_on_shortlist_and_move_product() throws InterruptedException {
		lc.hover();
		Thread.sleep(200);
		lc.clickshortlist.click();
		Thread.sleep(500);
		lc.short2cart.click();
		Thread.sleep(300);
		loggerObj.info("user tries to move product from shortlist to cart");
		lc.done.click();
		loggerObj.info("user clicks on done");
	}

	@Then("Verify product is moved to cart")
	public void verify_product_is_moved_to_cart() throws InterruptedException {
	    lc.cart.click();
	    Thread.sleep(500);
	    driver.findElement(By.xpath("//*[@id=\"placeorder_btn\"]/p"));
	    loggerObj.info("user has successfully added product to cart");
	    driver.close();
	}

}
