package com.locator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;


	@FindBy(id="search_box")
	static WebElement searchBar;
	
	@FindBy(xpath="/html/body/div[1]/div[5]/div/div[2]/form/span")
	static WebElement searchButton;
	
	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void navigateToURL(String url) {
		driver.get("www.firstcry.com");
	}
	
	public WebElement enterSearchText() {
		searchBar.click();
		return null;	
	}
	
	public void clickSearchButton() {
		searchButton.click();
	}
}
