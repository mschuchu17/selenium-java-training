package com.selenium.framework.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	private WebDriverWait wait;
	private WebDriver driver;
	private static final int TIMEOUT = 5;
	private static final int POLLING = 10;
	
	@FindBy(css = "a[aria-current*='step'] h1")
	private WebElement currentTab;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, TIMEOUT, POLLING);
		PageFactory.initElements(driver, this);
	}
	
	public void waitForElementToBeVisible(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void waitForElementToBeInvisible(By locator) {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	public void waitForElementToBeLocated(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public void implicitlyWait() {
		driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
	}
	
	public void pageIsShown() {
		implicitlyWait();
	}
	
	public boolean seeCurrentTab(String tabName) {
		implicitlyWait();
		if(currentTab.getText().contains(tabName)) {
			return true;
		}
		return false;
	}
	
}
