package stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import com.locator.AddToCartPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class AddToCartSteps {

	private static final Logger loggerObj = LogManager.getLogger(AddToCartSteps.class);
	WebElement searchBox;
	AddToCartPage a;
	static WebDriver driver;
	public  AddToCartSteps() {
		driver = new ChromeDriver();
		a = new AddToCartPage(driver);
	}
	
	@Given("Open the Firstcry application in chrome Browser")
	public void open_the_firstcry_application_in_chrome_browser() {
		String siteUrl ="https://www.firstcry.com/";
		driver.get(siteUrl);
        driver.manage().window().maximize();
		assertEquals(siteUrl, driver.getCurrentUrl());
		loggerObj.info("Open the Firstcry application in chrome Browser");

	}

	@Given("Browser should be maximized")
	public void browser_should_be_maximized() {
		driver.manage().window().maximize();
		loggerObj.info("Browser should be maximized");
	}

	@When("Search for a product \"([^\"]*)\"$")
	public void search_for_a_product(String productName) throws InterruptedException {
		searchBox=driver.findElement(By.xpath("//*[@id=\"search_box\"]"));
		a.enterSearchText();
		searchBox.sendKeys(productName);
		loggerObj.info("Search for a product");
	}

	@Then("Click Search Button")
	public void click_search_button() {
		a.clickSearchButton();
		loggerObj.info("Click Search Button");
	}
	
	@Then("Click a specific product to view")
	public void click_a_specific_product_to_view() throws InterruptedException {
	    a.ClickSelectedBathTub();
	    Thread.sleep(1000);
	    a.ClickSelectedBathTub();
	   // a.clickSelectedTricycles();
	    Thread.sleep(2000);
	    takeScreenShot("addtocart-bathtub.png");
	    takeScreenShot("addtocart-tricycles.png");
	    loggerObj.info("Click a specific product to view");
	}

	@Then("Click AddToCart for a product")
	public void click_add_to_cart_for_a_product() throws InterruptedException {
//		a.addCartSelectedBathTub();
//		Thread.sleep(2000);
//	    a.addCartSelectedTricycles();
//	    Thread.sleep(2000);
		loggerObj.info("Click AddToCart for a product");
	}

	@Then("Verify the title of the product page \"([^\"]*)\"$")
	public void verify_the_title_of_the_product_page(String pageTitle) {
		assertEquals(pageTitle, driver.getTitle());
		driver.close();
		loggerObj.info("Verify the title of the product page");
	}
	
	public static void takeScreenShot(String fileName) {
		// 1. type cast driver instance too take screen shot
		TakesScreenshot tsc = (TakesScreenshot) driver ;
		
		// 2. call take screen shot method with file type
		File src = tsc.getScreenshotAs(OutputType.FILE);
		
		// 3. create  file  with screen shot
		try {
			FileHandler.copy(src, new File("screenshot-addtocart_search\\"+fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
}
