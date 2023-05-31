package com.qa.demoblaze.base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.qa.demoblaze.utilities.Demoblaze_Utilities;

public class DemoBlaze_TestBase {
	public static WebDriver driver;
	public static ChromeOptions optionsC;
	public static FirefoxOptions optionsF;
	public static EdgeOptions optionsE;
	public static Properties prop;
	public static Properties dataprop;
	
	public DemoBlaze_TestBase() throws Exception {
		prop = new Properties();
		FileInputStream Ip = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\demoblaze\\properties\\demoblazeconfiguration.properties");
		prop.load(Ip);
		
		dataprop = new Properties();
		FileInputStream Ip1 = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\com\\qa\\demoblaze\\properties\\demoblazetestData.properties");
		dataprop.load(Ip1);
	}
	public WebDriver initializeBrowser(String browserName) {
		if(browserName.equalsIgnoreCase(prop.getProperty("browserName1"))) {
			optionsC = new ChromeOptions();
			optionsC.addArguments("--incognito");
			driver = new ChromeDriver(optionsC);
			driver.manage().window().maximize();
		}else if(browserName.equalsIgnoreCase(prop.getProperty("browserName2"))) {
			optionsF = new FirefoxOptions();
			optionsF.addArguments("--incognito");
			driver = new FirefoxDriver(optionsF);
			driver.manage().window().maximize();
		}else if(browserName.equalsIgnoreCase(prop.getProperty("browserName3"))) {
			optionsE = new EdgeOptions();
			optionsE.addArguments("--incognito");
			driver = new EdgeDriver(optionsE);
			driver.manage().window().maximize();
		}
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Demoblaze_Utilities.IMPLICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Demoblaze_Utilities.PAGELOAD_TIME));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Demoblaze_Utilities.SCRIPTLOAD_TIME));
		return driver;
			
		
		}
		
		
		
	}


