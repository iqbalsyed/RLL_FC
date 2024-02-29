package com.locator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	 WebDriver driver;
	
	@FindBy(id = "lemail")
	private WebElement emailfield;
	
	@FindBy(xpath = "//span[@class='J14SB_42 cl_fff']")
	private WebElement contbtn;
	
	@FindBy(id = "verfiedbtn")
	private WebElement submitbtn;
	
	@FindBy(css="body > div.fc_sh.fc_transform > div.fc_hs > div > div.fc_login > ul > li.logreg > span.anch.poplogin_main.poplogin.R12_61")
	private WebElement loginButton;

	
	
	public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
	
	public void clickLoginButton() {
        loginButton.click();
    }
	
	public void login(String mail) {
		emailfield.sendKeys(mail);
	}
	
	public void clickOnCont() {
		contbtn.click();
	}
	
	public void clickOnSubmitBTN() throws InterruptedException {
		Thread.sleep(40000);
		submitbtn.click();
	}

	

	

}
