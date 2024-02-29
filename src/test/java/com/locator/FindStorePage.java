package com.locator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FindStorePage {
	
	WebDriver driver;
	
	//@FindBy(xpath="//span[@class='anch poplogin_main poplogin R12_61']")
    //WebElement Loginicon;

	@FindBy(xpath="//span[text()='Stores & Preschools']")
    WebElement storespreschool;
	
	@FindBy(xpath="//span[text()='Find Stores']")
	WebElement findstores;
	
	@FindBy(xpath="//option[@value='FirstCry']")
    WebElement FirstCry;
	
	@FindBy(xpath="//option[@value='Andhra Pradesh']")
    WebElement AndhraPradesh;
	
	@FindBy(xpath="//option[@value='Anantapur Raju Road']")
    WebElement Anantapur;
	
	@FindBy(xpath="//option[@value='Please Select Store Type']")
    WebElement SelectStoreType;
	
	/**@FindBy(xpath="//span[@id='storetypeErrMsg']")
	WebElement error;
	

	public void errormssg (WebDriver driver) {
		
	}**/
	
	public FindStorePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void navigateToURL(String url) {
		driver.get(url);
	}
	
	public void clickonstorespreschool() {
		
		storespreschool.click();
	}
	
	public void clickonfindstores() {
		
		findstores.click();
		
	}
	
	public void clickonFirstCry() {
		
		FirstCry.click();
		
	}
	
	public void clickonAndhraPradesh() {
		
		AndhraPradesh.click();
		
	}
	
	public void clickonAnantapur () {
		
		Anantapur.click();
	}	
	
	}
