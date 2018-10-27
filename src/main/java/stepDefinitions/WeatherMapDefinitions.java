package stepDefinitions;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import pages.WeatherMapPage;

public class WeatherMapDefinitions {
	
	WeatherMapPage weatherMap = new WeatherMapPage();
	
	@Given("the user is on the OpenWeatherMap home page")
	public void givenUserIsOnWeatherMapHomePage() {
		weatherMap.isOnHomepage();
	}
	
	@Then("verify weather map tabs are displayed as '(.*)'")
	public void thenVerifyWeatherMapDetails(String tabs) {
		weatherMap.verifyTabsDisplayed(tabs);
	}

}
