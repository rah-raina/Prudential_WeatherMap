package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import stepDefinitions.Hooks;
import utilities.FileReader;

public class BasePage extends Hooks {
	

	WebDriver driver;
	
	public BasePage(){
		this.driver = Hooks.driver;
		PageFactory.initElements(this.driver, this);
	}

	public void opeUrl() {
		String url = FileReader.getInstance().getConfigReader().getApplicationUrl();
		this.driver.get(url);
	}


}
