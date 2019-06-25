package runner;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="C:/Users/AamirKamal/workspace/Project_Assignment/src/main/java/features/Assignment1.feature"
,glue = {"StepDefinations"}
,tags = {"@Tag1"}
		)
public class TestRunner {

}
