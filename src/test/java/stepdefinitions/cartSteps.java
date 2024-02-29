package stepdefinitions;

import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.locator.CartPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class cartSteps {
	private static final Logger loggerObj = LogManager.getLogger(cartSteps.class);
	WebElement searchBox;
	CartPage a;
	static WebDriver driver;
	public  cartSteps() {
		driver = new ChromeDriver();
		a = new CartPage(driver);
	}
	
	WebElement cart;
	
	@Given("Open the Firstcry application in firefox Browser")
	public void open_the_firstcry_application_in_firefox_browser() {
		String siteUrl ="https://www.firstcry.com/";
		driver.get(siteUrl);
        //driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	}

	@Given("Browser maximized")
	public void browser_maximized() {
		driver.manage().window().maximize();
	}

	@When("Search product \"([^\"]*)\"$")
	public void search_product(String productName) {
		searchBox=driver.findElement(By.xpath("//*[@id=\"search_box\"]"));
		a.enterSearchText();
		searchBox.sendKeys(productName);
	}

	@Then("Click Search")
	public void click_search() {
		a.clickSearchButton();
	}

	@Then("view specific product")
	public void view_specific_product() throws InterruptedException {
	    a.clickSelectedTricycles();
	    Thread.sleep(2000);
	    driver.close();
	}

	@Then("add product to cart")
	public void add_product_to_cart() throws InterruptedException {
	   // a.addCartSelectedTricycles();
	    Thread.sleep(2000);
	}
	
	@Then("Click on cart button to view cart")
	public void click_on_cart_button_to_view_cart() throws InterruptedException {
//		cart=driver.findElement(By.xpath("//*[@id=\"cart_TotalCount\"]"));
//		cart.click();
	}

	@When("The cart has the products")
	public void the_cart_has_the_products() throws InterruptedException {
		Thread.sleep(2000);
	    System.out.println(driver.getCurrentUrl());
	    System.out.println(driver.getTitle());
	    //driver.close();
	}
}
