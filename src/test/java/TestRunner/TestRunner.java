package TestRunner;



import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		plugin= {"pretty", "html:target/cucumberreport.html"},
				monochrome = true,
				tags = "",
				features= {"src/test/resources/Features"},
				glue = {"StepDefinitions"}
		
		
		
		
		)



public class TestRunner {

}

