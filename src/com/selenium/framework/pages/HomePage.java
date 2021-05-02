package com.selenium.framework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{
	
	WebDriver driver;
	private final By logo = By.xpath("//img[@alt='Cebu Pacific']");	
	
	@FindBy(css = "a[aria-current*='step'] h1")
	private WebElement currentTab;
	
	@FindBy(xpath = "//input[@placeholder='Select Your Origin']")
	private WebElement originTextbox;
	
	@FindBy(xpath = "//input[@placeholder='Select Your Destination']")
	private WebElement destinationTextbox;
	
	@FindBy(css = "div#flyout-FromStation.station-selector")
	private WebElement originSelector;
	
	@FindBy(css = "div#flyout-ToStation.station-selector")
	private WebElement destSelector;
	
	@FindBy(xpath = "//div[@class='cssRadio']//child::label")
	private List<WebElement> flightTypeRadioBtn;
	
	@FindBy(xpath = "//input[@id='startDateNew']")
	private WebElement departureTextbox;
	
	@FindBy(xpath = "//input[@id='endDateNew']")
	private WebElement arrivalTextbox;

	@FindBy(css = "td > div.day.toMonth.valid")
	private List<WebElement> calendarDay;
	
	@FindBy(css = "td > div.day.toMonth.valid.hovering")
	private List<WebElement> calendarDay2;
	
	@FindBy(xpath = "//button[@value='CONFIRM']")
	private WebElement calendarConfirmBtn;
	
	@FindBy(xpath = "//button[text()='Find Flights']")
	private WebElement findFlightButton;

	public HomePage(WebDriver driver) {
		super(driver);
//		this.driver=driver;
//		PageFactory.initElements(driver, this);
	}
	
	public void selectFlightType(String flightType) {
		for(WebElement element : flightTypeRadioBtn) {
			if(element.getText().contains(flightType)) {
				element.click();
				break;
			}
		}
	}
	
	public void selectPlaceOfOrigin(String origin) {
		implicitlyWait();
		originTextbox.clear();
		originTextbox.sendKeys(origin);
//		originTextbox.sendKeys(Keys.ENTER);
	}
	
	public void selectDestination(String destination) {
		this.implicitlyWait();
		destinationTextbox.sendKeys(destination);
//		destinationTextbox.sendKeys(Keys.ENTER);
	}
	
	public WebElement getDepartureTextBox(){
		return departureTextbox;
	}
	
	public WebElement getArrivalTextBox(){
		return arrivalTextbox;
	}
	
	public List<WebElement> getCalendarDate(){
		return calendarDay;
	}
	
	public void clickFindFlightButton() {
		implicitlyWait();
		findFlightButton.click();
	}
	
	public void selectDepartureDate(String departureDate) {
		implicitlyWait();
		departureTextbox.click();
		for(WebElement element : calendarDay) {
			if(element.getAttribute("aria-label").equals(departureDate)) {
				element.click();
				break;
			}
		}
	}
	
	public void selectArrivalDate(String arrivalDate) {
		implicitlyWait();
		for(WebElement element : calendarDay2) {
			if(element.getAttribute("aria-label").equals(arrivalDate)) {
				element.sendKeys(Keys.ENTER);
				element.click();
				break;
			}
		}
	}
	
	public void clickCalendarConfirmButton() {
		calendarConfirmBtn.click();
	}
}
