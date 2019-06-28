package StepDefinations;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefination {

	MethodsAvailable methavl = new MethodsAvailable();

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

	
	@Then("^test will fail if it contains external link$")
	public void test_will_fail_if_it_contains_external_link() throws Throwable {
		methavl.countLink_And_VerifyDeveloperPage();
	}

}
