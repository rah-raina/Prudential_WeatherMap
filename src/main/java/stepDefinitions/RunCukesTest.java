package stepDefinitions;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber-html-report", "json:target/cucumber-report.json",
		"junit:target_junit/cucumber.xml" }, tags = {
				"@test" }, features = "src/test/resources/features", glue = "stepDefinitions")

public class RunCukesTest {

}
