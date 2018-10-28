package stepDefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * @author rahulr
 *
 * This class performs Before and After Scenario operations
 *
 */
public class BaseDefinitions extends Hooks {
	
	@Before()
	public void before(Scenario scenario){
		setupwebdriver();
	}
	
	@After
	public void after(Scenario scenario){
		embedScreenshot(scenario);
		closeDriver();
	}


}
