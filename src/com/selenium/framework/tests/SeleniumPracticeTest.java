package com.selenium.framework.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.selenium.framework.flows.BookFlightFlow;
//import com.selenium.framework.pages.HomePage;
import com.selenium.framework.utils.Hooks;

public class SeleniumPracticeTest extends Hooks{
	
	@Test
	public void testBookingFlow() {
//		HomePage home = new HomePage(getDriver());
//		home.goToUrl("https://www.cebupacificair.com/");
//		home.waitForPageToLoad();
//		home.selectPlaceOfOrigin("Manila");
//		home.implicitlyWait();
//		home.selectDestination("Boracay");
//		home.setDepartureDate("04/21/2021");
		
		BookFlightFlow bookFlight = new BookFlightFlow();
		bookFlight.bookOneWayFlight(getDriver(), "One-way", "MNL", "TAG", "27, Tuesday April 2021");
		
	}
	

}
