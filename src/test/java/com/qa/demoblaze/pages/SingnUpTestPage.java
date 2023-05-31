package com.qa.demoblaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SingnUpTestPage {
	public WebDriver driver;
	
	@FindBy(id = "signin2")
	private WebElement signUpLink;
	
	@FindBy(id = "sign-username")
	private WebElement userNameTextBox;
	
	@FindBy(id = "sign-password")
	private WebElement passwordTextBox;
	
	@FindBy(xpath = "//button[text()='Sign up']")
	private WebElement signUpButton;
	
	public SingnUpTestPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnSignUpLink() {
		 signUpLink.click();
	}
	public void enterUserName(String usernameText) {
	       userNameTextBox.sendKeys(usernameText);
	}
	public void enterPassword(String passwordText) {
		passwordTextBox.sendKeys(passwordText);
	}
	public void clickOnSignUpButton() {
		signUpButton.click();
		
	}
	
	
	
	

}