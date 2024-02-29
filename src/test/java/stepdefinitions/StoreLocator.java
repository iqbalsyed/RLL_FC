package stepdefinitions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
//import java.util.logging.FileHandler;

import org.openqa.selenium.io.FileHandler;

import com.locator.FindStorePage2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import java.nio.file.Files;
//import com.google.common.io.Files;

//import PageFactory.FindStorePage;

import io.cucumber.java.en.Given;
//import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StoreLocator {
	
		private static final Logger logger = LogManager.getLogger(StoreLocator.class);
		static WebDriver driver;
		private final FindStorePage2 findstorepage;
		public StoreLocator() {
			driver = new ChromeDriver();
			findstorepage = new FindStorePage2(driver);
	}
	
	@Given("User navigates to the web URL")
	public void user_navigates_to_the_web_url() {

		logger.info("User navigates to the web URL");
		driver.manage().window().maximize();
		findstorepage.navigateToURL("https://www.firstcry.com/");
	}

	@Given("User must be able to access HomePage")
	public void user_must_be_able_to_access_home_page() {
		logger.info("User must be able to access HomePage");
		System.out.println(driver.getTitle());
		
	}

	@When("User must click over the stores&preschool" )
	public void user_must_click_over_the_stores_preschool() {
		logger.info("User must click over the stores&preschool");
		//driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div[3]/ul/li[2]/span/span")).click();
		//findstorepage.clickonstorespreschool();
		WebElement store = driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div[3]/ul/li[2]/span/span"));
				store.click();
	}

	@When("User must clicks on the find stores from drop down")
	public void user_must_clicks_on_the_find_stores_from_drop_down() {
	    
		logger.info("User must clicks on the find stores from drop down");
		//driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div[3]/ul/li[2]/ul/li[1]/a/span")).click();
		findstorepage.clickonfindstores();
	}
	
	@When("User switch to the new tab")
	public void user_switch_to_the_new_tab() {
		logger.info("User switches to the new tab");
		ArrayList<String> tabs=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
	    
	}
	
	@When("User views store page and click on search button with empty fields")
	public void User_views_store_page_and_click_on_search_button_with_empty_fields() throws InterruptedException {
		
		logger.info("User views store page and click on search button with empty fields");
		WebElement submitButton = driver.findElement(By.xpath("/html/body/div[9]/div[2]/div[1]/input[4]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", submitButton);
		//captureScreenshot(driver, "pass1.png");
		//WebElement search = driver.findElement(By.xpath("/html/body/div[9]/div[2]/div[1]/input[4]"));
		//search.click(); 
		takeScreenShot("negTc.png");
		driver.close();
	
	}
	
	
	public static void takeScreenShot(String fileName) {
		// 1. type cast driver instance too take screen shot
		TakesScreenshot tsc = (TakesScreenshot) driver ;
		
		// 2. call take screen shot method with file type
		File src = tsc.getScreenshotAs(OutputType.FILE);
		
		// 3. create  file  with screen shot
		try {
			FileHandler.copy(src, new File("screenshots_storeLocator\\"+fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	  // driver.close();
	}