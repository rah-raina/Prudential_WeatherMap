package pages;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author rahulr
 *
 * This Page file correspondes to Weather Map Home page and has methods and web elements present on Weather Map page
 */
public class WeatherMapPage extends BasePage { 
	
	By homepageTabs = By.xpath("//ul[contains(@class,'navbar-right')]/li[contains(@class,'nav__item')]");
	
	@FindBy(xpath="//div[@class='widget__graphic']//ul[@class='widget-tabs']")
	WebElement viewTabs;
	
	@FindBy(xpath="//a[@class='navbar-brand']/img")
	WebElement imgHomePage;
	
	@FindBy(xpath="//input[@placeholder='Your city name']")
	WebElement inputSearchBox;
	
	@FindBy(xpath="//button[contains(text(),'Search')]")
	WebElement btnSearch;
	
	@FindBy(id="forecast_list_ul")
	WebElement lstForcast;
	
	@FindBy(className="weather-widget__city-name")
	WebElement classWeatherWidget;
	
	@FindBy(xpath="//div[@id='weather-widget']//button/..")
	WebElement viewDate;
	
	@FindBy(id="imperial")
	WebElement spanImperial;
	
	@FindBy(id="metric")
	WebElement spanMetric;
	
	@FindBy(className="weather-widget__temperature")
	WebElement classTemp; 
	
	@FindBy(xpath="//div[@class='weather-forecast-list']")
	WebElement lstWeatherForcast;
	
	@FindBy(className="weather-forecast-list__header")
	WebElement classWeatherForecastList;
	
	
	public void isOnHomepage() {
		opeUrl();
		
	}

	public void verifyTabsDisplayed(String tabs) {
		List<WebElement> actualTabElements = this.driver.findElements(homepageTabs);
		
		List<String> expectedTabNames = new ArrayList<String>(Arrays.asList(tabs.split(",")));
		
		List<String> actualTabNames = new ArrayList<String>();
		
		for(WebElement element : actualTabElements) {
			String tabName = getTextOfWebElement(element).trim();
			actualTabNames.add(tabName);
			assertThat(tabName).as(tabName + "is not displayed on HomePage!!").isIn(expectedTabNames);
		}
		
		assertThat(actualTabNames.size()).as("All tabs are not displayed").isEqualTo(expectedTabNames.size());
		
		
	}

	public void isHomepageDisplayed() {
		assertThat(isDisplayed(imgHomePage)).as("Hompage image is not displayed").isTrue();
	}

	public void userSearchesCity(String city) {
		setTextInBox(inputSearchBox,city);
		clickAWebElement(btnSearch);
		
	}

	public void verifyErrorMessage(String errorMsg) {
		assertThat(getTextOfWebElement(lstForcast)).as("Hompage image is not displayed").contains(errorMsg);
		
	}

	public void userSelectsCity(String city) {
		assertThat(getTextOfWebElement(lstForcast)).as("Hompage image is not displayed").contains(city);
		WebElement element = selectLinkFromTable(lstForcast,city);
		clickAWebElement(element);
	}
	
	public void verifyCityWeather(String city) {
		assertThat(getTextOfWebElement(classWeatherWidget)).as("Hompage image is not displayed").contains("Weather in " + city);
	}
	
	public void verifyTabsDisplayedForViewingForcast(String tabs) {
		List<WebElement> actualTabElements = viewTabs.findElements(By.tagName("li"));
		
		List<String> expectedTabNames = new ArrayList<String>(Arrays.asList(tabs.split(",")));
		
		List<String> actualTabNames = new ArrayList<String>();
		
		for(WebElement element : actualTabElements) {
			String tabName = getTextOfWebElement(element).trim();
			actualTabNames.add(tabName);
			assertThat(tabName).as(tabName + "is not displayed for viewing on HomePage!!").isIn(expectedTabNames);
		}
		
		assertThat(actualTabNames.size()).as("All forcast viewing tabs are not displayed").isEqualTo(expectedTabNames.size());
		
		
	}

	public void verifyDateAndTimeDisplayed() {
		String toReplace = "Wrong data?";
		String dateDisplayed  = getTextOfWebElement(viewDate);
		dateDisplayed = dateDisplayed.replace(toReplace, "");
		
		String todaysDate = currentDateFormat();
		
		assertThat(todaysDate).as("Date displayed is not correct").isEqualTo(dateDisplayed);
	}

	public void verifyTemperatureDisplayed(String tempIn) {
		String temp = "";
		Double expectedTemp = null;
		Double actualTemp = null;
		switch (tempIn) {
		
		case "Fahrenheit":
			temp = getTextOfWebElement(classTemp);
			expectedTemp = celsiusToFahrenheit(temp.split(" ")[0]);
			clickAWebElement(spanImperial);
			temp = getTextOfWebElement(classTemp);
			actualTemp = Double.parseDouble(temp.split(" ")[0]);
			break;

		case "Celsius":
			temp = getTextOfWebElement(classTemp);
			expectedTemp = fahrenheitToCelsius(temp.split(" ")[0]);
			clickAWebElement(spanMetric);
			temp = getTextOfWebElement(classTemp);
			actualTemp = Double.parseDouble(temp.split(" ")[0]);
			break;
			
		default :
			break;

		}
		
		assertThat(actualTemp).as("Temperature displayed is not correct for " +tempIn).isEqualTo(expectedTemp);

	}

	public void verifyWeatherForcastInDays() {
		String text = getTextOfWebElement(classWeatherForecastList);
		
		String[] expectedDaysArray = text.split(" ");
		
		int expectedDays = Integer.parseInt(expectedDaysArray[0]);
		
		WebElement table = lstWeatherForcast.findElement(By.tagName("table"));
		List<WebElement> noOfDays = table.findElements(By.tagName("tr"));
		
		assertThat(noOfDays.size()).as("Weather forcast is not displayed for " + expectedDays + "days").isEqualTo(expectedDays);
		
		
	}
	
}
