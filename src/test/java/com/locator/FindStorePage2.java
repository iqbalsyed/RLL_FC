package com.locator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FindStorePage2 {
	
	WebDriver driver;
	
	@FindBy(xpath="//span[@class='anch poplogin_main poplogin R12_61']")
    WebElement LoginIcon;

	@FindBy(xpath="//span[text()='Stores & Preschools']")
    WebElement Storespreschool;
	
	@FindBy(xpath="//span[text()='Find Stores']")
	WebElement Findstores;
	
	/*@FindBy(xpath="//option[@value='FirstCry']")
    WebElement FirstCry;
	
	@FindBy(xpath="//option[@value='Karnataka']")
    WebElement Karnataka;
	
	@FindBy(xpath="//option[@value='Bangalore KR Puram']")
    WebElement Bangalorekrpuram;
	
	@FindBy(xpath="//option[@value='Please Select Store Type']")
    WebElement SelectStoreType;
	
	@FindBy(xpath="//span[@id='storetypeErrMsg']")
	WebElement error;*/
	
	
	public FindStorePage2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
		}
	public void navigateToURL(String url) {
		driver.get(url);
	}
	
	public void clickonstorespreschool() {
		
		Storespreschool.click();
	}
	
	public void clickonfindstores() {
		
		Findstores.click();
		
	}
	
	/**public void clickonFirstCry() {
		
		FirstCry.click();
		
	}
	
	public void clickonKarnataka() {
		
		Karnataka.click();
		
	}
	
	public void clickonBangalorekrpuram () {
		
		Bangalorekrpuram.click();
	}	
	*/
	}
