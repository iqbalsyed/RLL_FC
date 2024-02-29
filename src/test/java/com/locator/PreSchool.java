package com.locator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PreSchool{

	WebDriver driver;

//		@FindBy(xpath="/html/body/div[1]/div[5]/div/div[3]/ul/li[7]/span[1]")
//	    WebElement Loginicon;

	@FindBy(xpath = "/html/body/div[1]/div[5]/div/div[3]/ul/li[2]/span/span")
	WebElement storesandpreschool;

	@FindBy(xpath = "/html/body/div[1]/div[5]/div/div[3]/ul/li[2]/ul/li[2]/a/span")
	WebElement findpreschool;

	@FindBy(xpath = "/html/body/header/div/div/div[3]/div/div[2]/a[1]")
	WebElement preschoollocator;

	@FindBy(xpath = "//*[@id=\"city\"]/option[15]")
	WebElement Bangalore;

	@FindBy(id = "pincode-finder")
	WebElement pincode;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div/div[2]/div/div[2]/form/div[3]/div/input")
	WebElement findmypreschool;



	public PreSchool(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void navigateToURL(String url) {
		driver.get("www.firstcry.com");
	}

//	    public void clickonLoginIcon() {
//			
//	    	Loginicon.click();
//		}

	public void clickonstoresandpreschool() {

		storesandpreschool.click();
	}

	public void clickonfindpreschool() {

		findpreschool.click();

	}

	public void preschoollocator() {

		preschoollocator.click();

	}

	public void clickonBangalore() {

		Bangalore.click();

	}

	public void clickonpincode() {

		pincode.sendKeys("560061");
	}

	public void clickonfindmypreschool() {

		findmypreschool.click();
	}



}
