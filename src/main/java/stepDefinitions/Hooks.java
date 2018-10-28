package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import cucumber.api.Scenario;
import enums.DriverType;
import enums.ExecutionType;
import utilities.FileReader;

import org.openqa.selenium.OutputType;

/**
 * @author rahulr
 * 
 * Hooks class to setup webdriver and read config property file 
 *
 */
public class Hooks {
	public static WebDriver driver;
	private static DriverType driverType;
	private static ExecutionType environmentType;
	private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

	public Hooks() {
		driverType = FileReader.getInstance().getConfigReader().getBrowser();
		environmentType = FileReader.getInstance().getConfigReader().getEnvironment();
	}

	public WebDriver setupwebdriver() {
		if (driver == null)
			driver = createDriver();
		return driver;
	}

	private WebDriver createDriver() {
		switch (environmentType) {
		case LOCAL:
			driver = createLocalDriver();
			break;
		case REMOTE:
			driver = createRemoteDriver();
			break;
		}
		return driver;
	}

	private WebDriver createRemoteDriver() {
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}

	private WebDriver createLocalDriver() {
		switch (driverType) {
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		case CHROME:
			System.setProperty(CHROME_DRIVER_PROPERTY, FileReader.getInstance().getConfigReader().getDriverPath());
			driver = new ChromeDriver();
			break;
		case INTERNETEXPLORER:
			driver = new InternetExplorerDriver();
			break;
		}

		if (FileReader.getInstance().getConfigReader().getBrowserWindowSize())
			driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(FileReader.getInstance().getConfigReader().getImplicitlyWait(),
				TimeUnit.SECONDS);
		return driver;
	}

	public void closeDriver() {
		driver.close();
		driver.quit();
		driver = null;
	}
	
	public void embedScreenshot(Scenario scenario) {
		
		scenario.write("<br>");
		String screenshot = ((org.openqa.selenium.TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		byte[] decoded = org.apache.commons.codec.binary.Base64.decodeBase64(screenshot.getBytes());
		scenario.embed(decoded, "image/png");
		scenario.write("<br>");
		
	}

}