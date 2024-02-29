package stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.locator.LoginLocator;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateProfile {
	private WebDriver driver;
	private LoginLocator lc;
	public  UpdateProfile() {
		driver = new ChromeDriver();
		lc = new LoginLocator(driver);
	}
	
	private static final Logger loggerObj = LogManager.getLogger(UpdateProfile.class);
	@Given("^Open Website$")
	public void open_website() {
		driver.manage().window().maximize();
		String url = "https://www.firstcry.com/m/login";
		lc.openPage(url);
		loggerObj.info("user is on login page");
	}
	@Then("^Login using mkfbdhvmg@gmail.com$")
	public void login_by_credentials() throws InterruptedException {
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		    //String email = "mkfbdhvmg@gmail.com";
		    lc.sendemail();
		    lc.clickcont();
		    loggerObj.info("user enters otp");
	}
	@Then("Click on My Profile")
	public void click_on_my_profile_under_my_account() throws InterruptedException {
		Thread.sleep(30000);
		lc.hover();
		lc.clickprofile();
		loggerObj.info("user clicks on my profile page");
	}

  
	@Then ("^update fields and check$")
	public void update_fields_and_check() {
		for(int row = 1;row<=6;row++) {
			lc.clickedit();
			lc.updatecontact(row);
		}
		loggerObj.info("user enters profile details");
		
	}
	@Then("verify test is passed")
	public void verify_test_is_passed() throws InterruptedException {
		Thread.sleep(1000);
		boolean present;
		try {
		   driver.findElement(By.xpath("//*[@id=\"parent_1\"]"));
		   present = true;
		} catch (NoSuchElementException e) {
		   present = false;
		}
		Assert.assertEquals(true, present);
		loggerObj.info("The profile details have been added");
		driver.close();
	}

}
