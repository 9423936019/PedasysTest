package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"features"},
		glue= {"StepDefinitionfile"},
		monochrome=true,
		dryRun=true//
		
//		strict=true//
		)
public class TestRunner {

}
