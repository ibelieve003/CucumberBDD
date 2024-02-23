package stepDefs.google;

import java.util.Map;

import commonutils.BaseUiActions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.GooglePage;

public class googleSearchStepDef extends BaseUiActions {

	GooglePage googlePage;

	public googleSearchStepDef() {
		googlePage = new GooglePage();
		setImplicitWaitTime(10);
	}

	@Given("User is on google homepage")
	public void launchGoogle() {
		launchGoogle();
	}

	@When("The search text box is loaded")
	public void the_search_text_box_is_loaded() {
		explicitlyWait(googlePage.googleLogo, 30);
	}

	@Then("User types {string} in the text box")
	public void user_types_in_the_text_box(String str) {
		sendKeys(googlePage.searchTextBox, str);
	}

	@Then("User clicks on the search button")
	public void clicks_on_the_search_button() {
		jseClick(googlePage.searchButton);
	}

	@Then("User waits for the search Result")
	public void user_waits_for_the_serach_result() {
		explicitlyWait(googlePage.searchResultDiv, 30);
	}

	@And("Add below details in log table")
	public void addTableTolog(DataTable table) {
		Map<String, String> map = table.asMap();
		map.forEach((key, value) -> System.out.println(key + ": " + value));
	}

}
