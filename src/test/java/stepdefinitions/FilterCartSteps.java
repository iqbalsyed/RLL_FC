package stepdefinitions;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.PageFactory;

import com.locator.FilterCartPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class FilterCartSteps {

	private static final Logger loggerObj = LogManager.getLogger(FilterCartSteps.class);
	WebElement searchBox;
	FilterCartPage a;
	static WebDriver driver;
	public  FilterCartSteps() {
		driver = new ChromeDriver();
		a = new FilterCartPage(driver);
	}
	
	@Given("Open the ChromeBrowser and launch application")
	public void open_the_chrome_browser_and_launch_application() {
		String siteUrl ="https://www.firstcry.com/";
		driver.get(siteUrl);
		assertEquals(siteUrl, driver.getCurrentUrl());
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		loggerObj.info("Open the ChromeBrowser and launch application");

	}

	@Given("Maximize the browser")
	public void maximize_the_browser() {
		driver.manage().window().maximize();
		loggerObj.info("Maximize the browser");

	}
	
	@When("The pages loades click any one category from homepage")
	public void the_pages_loades_click_any_one_category_from_homepage() throws InterruptedException {
		 a.ClickSelectedMenuButton();
		 Thread.sleep(2000);
			loggerObj.info("The pages loades click any one category from homepage");

	}

	@Then("Move to the redirected page and scroll down to view products")
	public void move_to_the_redirected_page_and_scroll_down_to_view_products() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scroll down by 500 pixels
        js.executeScript("window.scrollBy(0,500)");
		loggerObj.info("Move to the redirected page and scroll down to view products");

	}

	@When("apply filters according to your requirements")
	public void apply_filters_according_to_your_requirements() throws InterruptedException {
		a.clickSelectedDiscountFilter();
		a.clickSelectedBrands();
		Thread.sleep(3000);
		takeScreenShot("filters-advancesearch.png");
		loggerObj.info("apply filters according to your requirements");

	}

	@When("select a product and add to cart")
	public void select_a_product_and_add_to_cart() throws InterruptedException {
		a.ClickSelectedToy();
//		a.addToCartSelectedToy();
		Thread.sleep(3000);
		driver.close();
		loggerObj.info("select a product and add to cart");

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
