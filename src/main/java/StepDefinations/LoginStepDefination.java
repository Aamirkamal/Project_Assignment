package StepDefinations;


import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefination {
	
	MethodsAvailable methavl= new MethodsAvailable();

@Given("^Launch the browser$")
public void launch_the_browser() throws Throwable {
	methavl.LaunchBrowser();
}

@When("^Navigate to here documentation Page$")
public void navigate_to_here_documentation_Page() throws Throwable {
	methavl.NavigateToURL();
}

@Then("^verify page loaded sucessfully$")
public void varify_page_loaded_sucessfully() throws Throwable {
	methavl.Verify_PageLoad();
}

@Then("^Count and validate the number of links present with Angular on Developer Page$")
public void count_and_validate_the_number_of_links_present_on_Developer_Page() throws Throwable {
	methavl.countLink_And_VerifyDeveloperPage();
}







	
}
