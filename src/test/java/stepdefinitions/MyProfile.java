package stepdefinitions;

import org.testng.AssertJUnit;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



import com.locator.LoginLocator;


import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MyProfile {
	
	private WebDriver driver;
	private LoginLocator lc;
	public   MyProfile() {
		driver = new ChromeDriver();
		lc = new LoginLocator(driver);
	}
	private static final Logger loggerObj = LogManager.getLogger(MyProfile.class);
	@Given("^Open FirstCry Website$")
	public void open_first_cry_website() {
		driver.manage().window().maximize();
		String url = "https://www.firstcry.com/m/login";
		lc.openPage(url);
		loggerObj.info("user is on login page");
	}

	@Then("^Login by mkfbdhvmg@gmail.com$")
	public void login_by_credentials() throws InterruptedException {
		    //String email = "mkfbdhvmg@gmail.com";
		    lc.sendemail();
		    lc.clickcont();
		    loggerObj.info("user enters otp");
	}

	@Then("Click on My Profile under My Account")
	public void click_on_my_profile_under_my_account() throws InterruptedException {
		Thread.sleep(30000);
		lc.hover();
		lc.clickprofile();
		loggerObj.info("user clicks on my profile page");
	}

	@Then("get the url and verify My Profile Page is reached")
	public void get_the_url_and_verify_my_profile_page_is_reached() {
		String ActualUrl = lc.getDriver().getCurrentUrl();
		String ExpectedUrl = "https://www.firstcry.com/accountdetails";
		loggerObj.info("Verify profile page via url");
		AssertJUnit.assertEquals(ExpectedUrl, ActualUrl);
		loggerObj.info("Profile Page Verified");
		driver.close();
	}
//	@AfterStep
//	public void addss(Scenario scenario) {
//		if(scenario.isFailed()) {
//			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
//			scenario.attach(screenshot, "image/png", scenario.getName());
//		}
//	}

}
