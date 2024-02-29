package stepdefinitions;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.locator.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.apache.logging.log4j.Logger;

public class LoginStepsDef {

	
	 WebDriver driver=new ChromeDriver();

	private static final Logger logger = LogManager.getLogger(LoginStepsDef.class);
	LoginPage lp = PageFactory.initElements(driver, LoginPage.class);
	

	@Given("user should on the Firstcry website")
	public void user_should_on_the_firstcry_website() {
		logger.info("user should on the Firstcry website");
		driver.manage().window().maximize();
		driver.get("https://www.firstcry.com/");
		String et = "Baby Products Online India: Newborn Baby Products & Kids Online Shopping at FirstCry.com";
		String at = driver.getTitle();
		Assert.assertEquals(et, at, "User on homepage");

	}

	@When("User click on the login")
	public void user_click_on_the_login() {
		logger.info("User click on the login");
		// driver.findElement(By.xpath("/html/body/div[1]/div[5]/div/div[3]/ul/li[7]/span[1]")).click();
		lp.clickLoginButton();
		String url = "https://www.firstcry.com/m/login?URL=https://www.firstcry.com/";
		Assert.assertEquals(url, driver.getCurrentUrl());

	}

	@When("User enters email")
	public void user_enters_email() {
		logger.info("User enters email");
		//driver.findElement(By.id("lemail")).sendKeys("shreyareddy2425@gmail.com");
		lp.login("mkfbdhvmg@gmail.com");
	}

	@When("User will click on continue button")
	public void user_will_click_on_continue_button() {
		logger.info("User will click on continue button");
		// driver.findElement(By.xpath("//*[@id=\"login\"]/div/div[3]/span")).click();
		WebElement continuebtn=driver.findElement(By.xpath("//*[@id=\"login\"]/div/div[3]/span"));
		continuebtn.click();
	}

	@When("User manually enter the OTP")
	public void user_manually_enter_the_otp() throws InterruptedException {
		logger.info("User manually enter the OTP");
		Thread.sleep(30000);
		// driver.findElement(By.id("verfiedbtn")).click();
		lp.clickOnSubmitBTN();
	}

	@Then("User login should be successful")
	public void user_login_should_be_successful() {
		String aUrl = "https://www.firstcry.com/";
		Assert.assertEquals(aUrl, driver.getCurrentUrl());
		System.out.println("logged in sucessfully");
		driver.close();
	}

}
