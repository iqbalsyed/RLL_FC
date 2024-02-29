package com.locator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmptyCartPage {
	WebDriver driver;
	public EmptyCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	@FindBy(xpath="//*[@id=\"cart_TotalCount\"]/span[1]")
	static WebElement cartButton;
	
	@FindBy(xpath="//*[@id=\"shopping-cart\"]/div[1]/p[2]")
	static WebElement previousButton;
	
	public void entercartButton() {
		cartButton.click();	
	}
	
	public void clickpreviousButton() {
		previousButton.click();
	}
}
