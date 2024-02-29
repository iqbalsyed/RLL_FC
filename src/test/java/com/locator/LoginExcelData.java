package com.locator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginExcelData {
	
WebDriver driver;
	
	@FindBy(id = "lemail")
	private WebElement enterEmail;
	
	
	@FindBy(id = "verfiedbtn")
	private WebElement submitbtn;
	
	@FindBy(css="body > div.fc_sh.fc_transform > div.fc_hs > div > div.fc_login > ul > li.logreg > span.anch.poplogin_main.poplogin.R12_61")
	private WebElement loginButton;

	
	
	public LoginExcelData(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void clickloginButton() {
        loginButton.click();
    }
	
	public void Login(String email) {
		enterEmail.sendKeys(email);
	}
	
	
	
	public void clickonSubmitBTN() throws InterruptedException {
		Thread.sleep(40000);
		submitbtn.click();
	}

}
