package pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.assertj.core.api.Assertions.assertThat;

public class WeatherMapPage extends BasePage { 
	
	By homepageTabs = By.xpath("//ul[contains(@class,'navbar-right')]/li[contains(@class,'nav__item')]");

	public void isOnHomepage() {
		opeUrl();
		
	}

	public void verifyTabsDisplayed(String tabs) {
		List<WebElement> actualTabElements = this.driver.findElements(homepageTabs);
		
		List<String> expectedTabNames = new ArrayList<String>(Arrays.asList(tabs.split(",")));
		
		List<String> actualTabNames = new ArrayList<String>();
		
		for(WebElement element : actualTabElements) {
			String tabName = element.getText().trim();
			actualTabNames.add(tabName);
			assertThat(tabName).as(tabName + "is not displayed on HomePage!!").isIn(expectedTabNames);
		}
		
		assertThat(actualTabNames.size()).as("All tabs are displayed").isEqualTo(expectedTabNames.size());
		
		
	}

}
