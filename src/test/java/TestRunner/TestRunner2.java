package TestRunner;
import org.junit.runner.RunWith;

import Utilities.ScenarioContext;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin= {"pretty", "html:target/cucumberreport.html"},
				monochrome = true,
				tags = "@pranitha",
				features= {"src/test/resources/features"},
				glue = {"StepDefinitions"}
		
		
		
		
		)

public class TestRunner2 {
 
	public static ScenarioContext scenarioContext = new ScenarioContext();
}
