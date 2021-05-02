package com.selenium.framework.flows;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.selenium.framework.pages.HomePage;
import com.selenium.framework.pages.SelectFlightPage;

public class BookFlightFlow {
	HomePage home;
	SelectFlightPage select;
	
	public void bookOneWayFlight(WebDriver driver, String flightType, String origin, String destination, String departure) {
		home = new HomePage(driver);
		select = new SelectFlightPage(driver);
		assertTrue(home.seeCurrentTab("Search Flight"));
		home.selectFlightType(flightType);
		home.selectPlaceOfOrigin(origin);
		home.selectDestination(destination);
		home.selectDepartureDate(departure);
		home.clickCalendarConfirmButton();
//		home.clickFindFlightButton();
//		assertTrue(select.seeCurrentTab("Search Flight"));
//		select.clickContinueButton();
	}
}
