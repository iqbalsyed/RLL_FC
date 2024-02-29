package stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.locator.LoginLocator;

import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Addtoshortlist {
	
	private WebDriver driver;
	private LoginLocator lc;
	public Addtoshortlist() {
		driver = new ChromeDriver();
		lc = new LoginLocator(driver);
	}
	
	private static final Logger loggerObj = LogManager.getLogger(Addtoshortlist.class);
	@Given("Open the FirstCRY Website")
	public void open_the_firstcry_website() {
		driver.manage().window().maximize();
		String url = "https://www.firstcry.com/m/login";
		lc.openPage(url);
		loggerObj.info("user is on login page");
	}

	@When("Login on using email")
	public void login_on_using_email() {
		String email = "mkfbdhvmg@gmail.com";
		lc.sendemail();
	    lc.clickcont();
	    loggerObj.info("user logs in");
	}

	@Then("Click on bestseller and add product to shortlist")
	public void click_on_bestseller_and_add_product_to_shortlist() throws InterruptedException {
		Thread.sleep(30000);
		lc.hoverbf();
		loggerObj.info("user hovers on BoysFashion");
		Thread.sleep(200);
		lc.bestseller.click();
		Thread.sleep(600);
		loggerObj.info("user clicks on Bestseller");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,330)", "");
		loggerObj.info("user scrolls the page");
		lc.hoversi();
		lc.addshortlist.click();
		loggerObj.info("user clicks and adds a product to shortlist");
		Thread.sleep(400);
		
	}

	@Then("Verify product is added")
	public void verify_product_is_added() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-330)", "");
		Thread.sleep(300);
		lc.shortlist.click();
		Thread.sleep(1000);
		boolean present;
		try {
			   driver.findElement(By.xpath("//*[@id=\"LoginLocation\"]/div[4]/div"));
			   present = true;
			} catch (NoSuchElementException e) {
			   present = false;
			}
		if (present ==true) {
			lc.confirmadd.click();
			Thread.sleep(5000);
		}
		lc.logo.click();
		lc.hover();
		Thread.sleep(200);
		lc.clickshortlist.click();
		Thread.sleep(1000);
		String Actual = lc.checkshortlist.getText();
		String Expected = "OLLYPOP Sinker Half Sleeves Trucks Print Night Suit - B]...";
		Assert.assertEquals(Expected, Actual);
		loggerObj.info("user has successfully added product to shortlist");
		driver.close();
		
	}


}
