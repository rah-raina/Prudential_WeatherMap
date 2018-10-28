package stepDefinitions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * @author rahulr
 * Cucumber runner class
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber-html-report", "json:target/cucumber-report.json",
		"junit:target_junit/cucumber.xml" }, tags = {
				"@openWeatherMap" }, features = "src/test/resources/features", glue = "stepDefinitions")

public class RunCukesTest {

}
