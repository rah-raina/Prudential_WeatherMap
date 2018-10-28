package pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import stepDefinitions.Hooks;
import utilities.FileReader;

/**
 * @author rahulr
 * 
 * Base Page provides methods which are common across all the web pages and also provides web driver methods
 *
 */
public class BasePage extends Hooks {

	WebDriver driver;

	public BasePage() {
		this.driver = Hooks.driver;
		PageFactory.initElements(this.driver, this);
	}

	public void opeUrl() {
		String url = FileReader.getInstance().getConfigReader().getApplicationUrl();
		this.driver.get(url);
	}

	public boolean isDisplayed(By element) {
		boolean flag = false;
		flag = this.driver.findElement(element).isDisplayed();
		return flag;
	}

	public boolean isDisplayed(WebElement element) {
		boolean flag = false;
		flag = element.isDisplayed();
		return flag;
	}

	public void setTextInBox(WebElement element, String city) {
		element.sendKeys(city);

	}

	public void clickAWebElement(WebElement element) {
		element.click();

	}

	public String getTextOfWebElement(WebElement element) {
		String text = element.getText().trim();

		return text;
	}

	public void clickALink(String city) {
		this.driver.findElement(By.linkText(city));

	}

	public WebElement selectLinkFromTable(WebElement element, String text) {
		WebElement target = null;
		WebElement table = element.findElement(By.tagName("table"));
		List<WebElement> allLinks = table.findElements(By.tagName("a"));
		for (WebElement link : allLinks) {
			String linkText = link.getText();
			if (text.equalsIgnoreCase(linkText)) {
				target = link;
				break;
			}
		}
		return target;
	}

	public String currentDateFormat() {

		Calendar cal = Calendar.getInstance();

		String todayDate = cal.getTime().toString();

		Date dateParsed;
		String todaysDateFormatted = null;

		SimpleDateFormat currentFormat = new SimpleDateFormat("E MMM dd HH:mm:ss Z yyyy");
		SimpleDateFormat expectedFormat = new SimpleDateFormat("HH:mm MMM dd");
		try {
			dateParsed = currentFormat.parse(todayDate);
			todaysDateFormatted = expectedFormat.format(dateParsed);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return todaysDateFormatted;

	}

	public Double celsiusToFahrenheit(String temp) {
		double celsius = Double.parseDouble(temp);
		double fahrenheit;
		fahrenheit = Math.round(((celsius * 9 / 5) + 32));
		return fahrenheit;
	}

	public Double fahrenheitToCelsius(String temp) {
		double fahrenheit = Double.parseDouble(temp);
		double celsius;
		celsius = Math.round((fahrenheit - 32) * 5 / 9);
		return celsius;
	}
	
	public void waitABit(long timeInMilliseconds) {
		try {
			Wait<WebDriver> wait = new WebDriverWait(driver, 150);
			wait.wait(timeInMilliseconds);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
