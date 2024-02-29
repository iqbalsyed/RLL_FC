package com.locator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {
	WebDriver driver;
	
	@FindBy(id="search_box")
	static WebElement searchBar;
	
	@FindBy(xpath="/html/body/div[1]/div[5]/div/div[2]/form/span")
	static WebElement searchButton;
	
	public WebElement enterSearchText() {
		searchBar.click();
		return null;	
	}
	
	public void clickSearchButton() {
		searchButton.click();
	}
	
	@FindBy(xpath="//*[@id=\"maindiv\"]/div[1]/div/div[1]/div[1]/a/img")
	static WebElement selectBathTub;
	
	@FindBy(xpath="//*[@id=\"maindiv\"]/div[1]/div/div[1]/div[1]/a/img")
	static WebElement selectTricycles;
	
	@FindBy(xpath="//*[@id=\"9714851\"]")
	static WebElement addBathTub;
	
	@FindBy(xpath="//*[@id=\"11525180\"]")
	static WebElement addTricycles;
	
	public AddToCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void navigateToURL(String url) {
		driver.get("www.firstcry.com");
	}
	
	public void ClickSelectedBathTub() {
		selectBathTub.click();	
	}
	
	public void clickSelectedTricycles() {
		selectTricycles.click();
	}
	
	public void addCartSelectedBathTub() {
		addBathTub.click();	
	}
	
	public void addCartSelectedTricycles() {
		addTricycles.click();
	}
}
