package TestRunner;



import org.junit.runner.RunWith;

import Utilities.ScenarioContext;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions;
@RunWith(Cucumber.class)
@CucumberOptions(
		plugin= {"pretty", "html:target/cucumberreport.html"},
				monochrome = true,
				tags = "",
				features= {"src/test/resources/Features"},
				glue = {"StepDefinitions"}
		
		
		
		
		)



public class Testrunner {

	 // Cucumber will automatically inject the ScenarioContext instance here
    // and make it available for all step definitions.
    // You can also use a DI framework like Spring for more complex setups.
    public static ScenarioContext scenarioContext = new ScenarioContext();
}

