package com.qa.demoblaze.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.demoblaze.base.DemoBlaze_TestBase;
import com.qa.demoblaze.pages.LandinPage;

public class DemoBlaze_Landingage extends DemoBlaze_TestBase {
	public DemoBlaze_Landingage() throws Exception {
		super();
		
	}
	public static WebDriver driver;
	public static ChromeOptions options;
	public static SoftAssert softassert = new SoftAssert();

	@BeforeMethod
	public void launchUrl() {
		driver = initializeBrowser(prop.getProperty("browserName1"));
		
	}

	@Test(priority=1)
	public void pageTitleAndUrl() {
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());

		String actualPageTitle = prop.getProperty("actualPageTile");
		String expectedPageTitle = driver.getTitle();

		String actualPageUrl = prop.getProperty("actualPageUrl");
		String expectedPageUrl = driver.getCurrentUrl();

		if (actualPageTitle.equals(expectedPageTitle) && actualPageUrl.equals(expectedPageUrl)) {
			System.out.println("Webpage is functional and valid");
		} else {
			System.out.println("Webpage is non functional and not valid");
		}
	}

	@Test(priority=2)
	public void presenceOfProductStoreLink() {
		LandinPage landingpage = new LandinPage(driver);
		landingpage.productStoreLinkIsDisplayed();
		softassert.assertTrue(landingpage.productStoreLinkIsDisplayed(), "prdoductStoreLink is not displayed");
		softassert.assertAll();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

}
