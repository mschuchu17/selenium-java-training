package com.selenium.framework.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class Hooks {
	
	protected WebDriver driver;
	
	@BeforeSuite
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://book.cebupacificair.com/");
	}
	
	@AfterSuite
	public void tearDown() {
		if(driver != null) {
			driver.close();
			driver.quit();
		}
	}
	
	public WebDriver getDriver() {
		return driver;
	}

}
