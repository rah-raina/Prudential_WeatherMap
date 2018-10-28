package stepDefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.WeatherMapPage;

/**
 * @author rahulr
 *
 * A Step definition class to work as a glue code for Scenarios steps created in feature file
 */
public class WeatherMapDefinitions {
	
	WeatherMapPage weatherMap = new WeatherMapPage();
	
	@Given("the user is on the OpenWeatherMap home page")
	public void givenUserIsOnWeatherMapHomePage() {
		weatherMap.isOnHomepage();
	}
	
	@Then("verify OpenWeatherMap home page image is displayed")
	public void thenVerifyHomePageIsDisplayed() {
		weatherMap.isHomepageDisplayed();
	}
	
	@Then("verify weather map tabs are displayed as '(.*)'")
	public void thenVerifyWeatherMapDetails(String tabs) {
		weatherMap.verifyTabsDisplayed(tabs);
	}

	@When("user searches for city '(.*)'")
	public void whenUserSearchesForCity(String city) {
		weatherMap.userSearchesCity(city);
	}
	
	@Then("verify error message displayed as '(.*)'")
	public void thenVerifyErrorMessage(String errorMsg) {
		weatherMap.verifyErrorMessage(errorMsg);
	}
	
	@When("user selects '(.*)' for more information")
	public void whenUserSelectsCity(String city) {
		weatherMap.userSelectsCity(city);
	}
	
	@Then("verify weather information is displayed for '(.*)'")
	public void thenVerifyWeatherInformationIsDisplayed(String city) { 
		weatherMap.verifyCityWeather(city);
	}
	
	@Then("verify weather report can be viewed as '(.*)'")
	public void thenVerifyWeatherReportCanBeViewed(String tabs) { 
		weatherMap.verifyTabsDisplayedForViewingForcast(tabs);
	}
	
	@Then("verify date and time displayed is correct")
	public void thenVerifyDateAndTimeDisplayed() { 
		weatherMap.verifyDateAndTimeDisplayed();
	}
	
	@Then("verify '(.*)' temperature displayed is correct")
	public void thenVerifyTemeratureDisplayed(String tempIn) { 
		weatherMap.verifyTemperatureDisplayed(tempIn);
	}
	
	@Then("verify weather forcast is displayed for as mentioned days")
	public void thenVerifyWeatherForcastInDays() { 
		weatherMap.verifyWeatherForcastInDays();
	}
	
	
}
