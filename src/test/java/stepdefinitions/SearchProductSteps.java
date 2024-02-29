package stepdefinitions;

import static org.testng.Assert.assertEquals;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

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

import com.locator.SearchPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class SearchProductSteps {

	private static final Logger loggerObj = LogManager.getLogger(SearchProductSteps.class);
	WebElement searchBox;
	SearchPage p;
	static WebDriver driver;
	public  SearchProductSteps() {
		driver = new ChromeDriver();
		p = new SearchPage(driver);
	}
	
	@Given("^Open the Chrome and launch Firstcry application$")
	public void open_the_chrome_and_launch_firstcry_application() {
		
		String siteUrl ="https://www.firstcry.com/";
		driver.get(siteUrl);
		assertEquals(siteUrl, driver.getCurrentUrl());
		loggerObj.info("Open the Chrome and launch Firstcry application");

	}

	@Given("Maximize the Chrome browser window")
	public void maximize_the_chrome_browser_window() {
		driver.manage().window().maximize();
		loggerObj.info("Maximize the Chrome browser window");

	}

	@When("^Enter the Product that has to be searched \"([^\"]*)\"$")
	public void enter_the_product_that_has_to_be_searched(String productName) throws InterruptedException {
		searchBox=driver.findElement(By.xpath("//*[@id=\"search_box\"]"));
		p.enterSearchText();
		searchBox.sendKeys(productName);
		loggerObj.info("Enter the Product that has to be searched");

	}

	@Then("^Click the Search button$")
	public void click_the_search_button() {
		p.clickSearchButton();
		takeScreenShot("search-products.png");
		loggerObj.info("Click the Search button");

	}

	@Then("^Verify the title \"([^\"]*)\"$")
	public void verify_the_title(String pageTitle) {
		assertEquals(pageTitle, driver.getTitle());
		driver.close();
		loggerObj.info("Verify the title");

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