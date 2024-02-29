package stepdefinitions;

import java.sql.Time;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.locator.EmptyCartPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class emptycartSteps {
	
	private static final Logger loggerObj = LogManager.getLogger(emptycartSteps.class);
	WebElement searchBox;
	EmptyCartPage a;
	static WebDriver driver;
	public  emptycartSteps() {
		driver = new ChromeDriver();
		a = new EmptyCartPage(driver);
	}
	
	WebElement cart;
	
	
	@Given("Open app\\(firstcry.com) in Browser")
	public void open_app_firstcry_com_in_browser() {
		String siteUrl ="https://www.firstcry.com/";
		driver.get(siteUrl);
        //driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}

	@Given("Browser maximized to view")
	public void browser_maximized_to_view() {
		driver.manage().window().maximize();
	}

	@Then("Click cart button in the homepage")
	public void click_cart_button_in_the_homepage() throws InterruptedException {
	    a.entercartButton();
	    Thread.sleep(1000);
	}

	@When("The cart has no products")
	public void the_cart_has_no_products() throws InterruptedException {
	    System.out.println(driver.getCurrentUrl());
	    System.out.println(driver.getTitle());
	    Thread.sleep(1000);
	}


	@Then("Can add products to the cart now")
	public void can_add_products_to_the_cart_now() throws InterruptedException {
		System.out.println(driver.getCurrentUrl());
	    System.out.println(driver.getTitle());
	    Thread.sleep(1000);
	    
	}
	 @Then ("Verify cart is empty")
	 public void empty_cart() throws InterruptedException {
		 Thread.sleep(300);
			boolean present;
			try {
			   driver.findElement(By.xpath("//*[@id=\"shopping-cart\"]/div[1]/p[1]"));
			   present = true;
			} catch (NoSuchElementException e) {
			   present = false;
			}
			Assert.assertEquals(true, present);
			driver.close();
	 }
	
}
