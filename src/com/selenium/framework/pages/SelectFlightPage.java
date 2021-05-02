package com.selenium.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectFlightPage extends BasePage{

	public SelectFlightPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//button[text()='Continue']")
	WebElement continueButton;
	
	public void clickContinueButton() {
		continueButton.click();
	}

}
