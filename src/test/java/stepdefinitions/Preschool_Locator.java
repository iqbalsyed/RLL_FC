package stepdefinitions;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.locator.PreSchool;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class Preschool_Locator {
	private static final Logger loggerObj = LogManager.getLogger(Preschool_Locator.class);
	private WebDriver driver ;
	private PreSchool preschool;
	
	public  Preschool_Locator() {
		driver = new ChromeDriver();
		preschool = new PreSchool(driver);
	}
	@Given("user is in the HomePage")
	public void user_is_in_the_home_page() {
		String siteUrl ="https://www.firstcry.com/";
		driver.get(siteUrl);
        driver.manage().window().maximize();
		assertEquals(siteUrl, driver.getCurrentUrl());
		loggerObj.info("user is in the HomePage");
        
	}

	@Given("user can click on storeandpreschool")
	public void user_can_click_on_storeandpreschool()  throws InterruptedException {

		preschool.clickonstoresandpreschool();
		String expectedTitle = "Baby Products Online India: Newborn Baby Products & Kids Online Shopping at FirstCry.com";
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expectedTitle);
		System.out.println(actualTitle);
		loggerObj.info("user can click on storeandpreschool");
	}

	@Given("user can click on findpreschool")
	public void user_can_click_on_findpreschool()  throws InterruptedException {

		preschool.clickonfindpreschool();
		loggerObj.info("user can click on findpreschool");
		
	}

	@Given("user switches to the new tab")
	public void user_switches_to_the_new_tab() throws InterruptedException {
		ArrayList<String> tabs=new ArrayList<String>(driver.getWindowHandles());
    	driver.switchTo().window(tabs.get(1));
		driver.findElement(By.id("school-finder-btn")).click();

		Thread.sleep(3000);
		loggerObj.info("user switches to the new tab");
	}

	@Given("user clicks on the available city")
	public void user_clicks_on_the_available_city() throws InterruptedException {
				preschool.clickonBangalore();

				loggerObj.info("user clicks on the available city");
	}

	@Given("click on findmy preschool")
	public void click_on_findmy_preschool() throws InterruptedException {
				preschool.clickonpincode();

				loggerObj.info("click on findmy preschool");
	}


	@Given("user must able to verify the firstcry Intellitots preschools in Banglore")
	public void user_must_able_to_verify_the_firstcry_intellitots_preschools_in_banglore() throws InterruptedException {
		preschool.clickonfindmypreschool();
		Thread.sleep(3000);
		WebElement errorEm = driver.findElement(By.cssSelector("#error_pincodes"));
//		System.out.println(">>>>"+errorEm);
		String actualTitle = errorEm.getText();
		System.out.println(">>>>"+actualTitle);
		String expectedTitle = "Pin Code does not match selected city";
		
		if(actualTitle != null) {
			captureScreenshot("image1");

		}
		assertEquals(actualTitle, expectedTitle);
		loggerObj.info("user must able to verify the firstcry Intellitots preschools in Banglore");

	}
	
	@Then("Verify page title")
	public void verify_page_title(){
		String expectedTitle = "FirstCry Intellitots Preschool Locator: Find a Preschool Near You";
		String actualTitle = driver.getTitle();
		assertEquals(actualTitle, expectedTitle);
		System.out.println(actualTitle);
		loggerObj.info("Verify page title");
	}

public void captureScreenshot(String testName) {
		
		TakesScreenshot takesscreenshot = (TakesScreenshot) driver;
		File file = takesscreenshot.getScreenshotAs(OutputType.FILE);
		File destfile = new File("./Screenshot_preschool_locator/"+testName+".png");
		
		try {
			FileUtils.copyFile(file, destfile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Screenshot saved successfully");
		
	}


}
