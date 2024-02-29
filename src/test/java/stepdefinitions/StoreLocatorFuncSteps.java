package stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.locator.FindStorePage;

import java.nio.file.Files;
//import com.google.common.io.Files;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StoreLocatorFuncSteps {
	
		private static final Logger logger = LogManager.getLogger(StoreLocatorFuncSteps.class);
		private final WebDriver driver;
		private final FindStorePage findstorepage;
		public StoreLocatorFuncSteps() {
			driver = new ChromeDriver();
			findstorepage = new FindStorePage(driver);
	}
	
	@Given("a User navigates to the web URL")
	public void a_user_navigates_to_the_web_url() {

		logger.info("a User navigates to the URL");
		driver.manage().window().maximize();
		findstorepage.navigateToURL("https://www.firstcry.com/");
	}

	@Given("the User can access the Homepage")
	public void the_user_can_access_the_home_page() {
		logger.info("the User can access the Homepage");
		System.out.println(driver.getTitle());
		String actualtitle="Baby Products Online India: Newborn Baby Products & Kids Online Shopping at FirstCry.com";
		assertEquals(driver.getTitle(),actualtitle);
		}

	@When("User must hover over the stores&preschool" )
	public void user_must_hover_over_the_stores_preschool() {
		logger.info("User must hover over the stores&preschool");
		//driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div[3]/ul/li[2]/span/span")).click();
		findstorepage.clickonstorespreschool();
		
	}

	@When("User must click on the find stores from drop down")
	public void user_must_click_on_the_find_stores_from_drop_down() {
	    
		logger.info("User must click on the find stores from drop down");
		//driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div[3]/ul/li[2]/ul/li[1]/a/span")).click();
		findstorepage.clickonfindstores();
	}
	
	@When("switches focus to the new tab")
	public void switches_focus_to_the_new_tab() {
		logger.info("switches focus to the new tab");
		ArrayList<String> tabs=new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));   
	}

	@When("selects the store type, state, and city")
	public void selects_the_store_type_state_and_city() throws IOException, InterruptedException {
		logger.info("selects the store type, state, and city");
		//driver.findElement(By.xpath("//option[@value='FirstCry']")).click();
		findstorepage.clickonFirstCry();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//option[@value='Andhra Pradesh']")).click();
		findstorepage.clickonAndhraPradesh();
		Thread.sleep(3000);
		//driver.findElement(By.xpath("//option[@value='Anantpur']")).click();
		findstorepage.clickonAnantapur();
		Thread.sleep(10000);	
	}
	
	@When("clicks on the search button")
	public void clicks_on_the_search_button() throws InterruptedException {
		
		logger.info("clicks on the search button");
		WebElement submitButton = driver.findElement(By.xpath("/html/body/div[9]/div[2]/div[1]/input[4]"));
		submitButton.click(); 
	
	}

	@Then("the User should be able to view the store locations")
	public void the_User_should_be_able_to_view_the_store_locations() throws InterruptedException {
		
		logger.info("the User should be able to view the store locations");
		String title = driver.getTitle();
		String expectedurl=driver.getCurrentUrl();
		System.out.println("The title is"+title);
		String actualURl="https://www.firstcry.com/store-locator?ref2=topstrip";
		assertEquals(expectedurl ,actualURl);
		//driver.close();
		
	}
}
	
