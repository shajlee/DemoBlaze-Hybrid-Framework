package com.qa.demoblaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoriesTestPage {
	public WebDriver driver;
	
	@FindBy(xpath = "//a[text()='Phones']")
	private WebElement phoneLink;
	
	@FindBy(linkText = "Samsung galaxy s6")
	private WebElement telephone;
	
	@FindBy(xpath = "//a[text()='Laptops']")
	private WebElement laptopLink;
	
	@FindBy(linkText = "Sony vaio i5")
	private WebElement laptop;
	
	@FindBy(xpath = "//a[text()='Monitors']")
	private WebElement monitorLink;
	
	@FindBy(linkText = "Apple monitor 24")
	private WebElement monitor;
	
	public CategoriesTestPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void clickOnPhoneLink() {
		phoneLink.click();
	}
	public boolean phoneLinkDisplay() {
		boolean displayStatus = telephone.isDisplayed();
		return  displayStatus;
	}
	public void clickOnLaptopLink() {
		laptopLink.click();
	}
	public boolean laptopLinkDisplay() {
		boolean displayStatus = laptop.isDisplayed();
		return displayStatus;
	}
	public void clickOnMonitorLink() {
		monitorLink.click();
	}
	public boolean MonitorLinkDisplay() {
		boolean displayStatus = monitor.isDisplayed();
		return displayStatus;
		
		
		
	}
	
	
	
	
		
		
		

}
