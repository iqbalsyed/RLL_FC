package com.locator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver driver;
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(id="search_box")
	static WebElement searchBar;
	
	@FindBy(xpath="/html/body/div[1]/div[5]/div/div[2]/form/span")
	static WebElement searchButton;
	
	@FindBy(xpath="//*[@id=\"maindiv\"]/div[1]/div/div[1]/div[1]/a/img")
	static WebElement selectTricycles;
	
	@FindBy(xpath="//*[@id=\"p_breadcrumb\"]/div[2]/div/div[2]/div[6]/div/div[2]/div[2]/div[1]/div/span[1]")
	static WebElement addTricycles;
	
	public WebElement enterSearchText() {
		searchBar.click();
		return null;	
	}
	
	public void clickSearchButton() {
		searchButton.click();
	}
	
	public void clickSelectedTricycles() {
		selectTricycles.click();
	}
	
	public void addCartSelectedTricycles() {
		addTricycles.click();
	}
}