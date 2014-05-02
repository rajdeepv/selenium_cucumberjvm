package cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import sites.Sites;
import sites.google.Google;

public class SearchSteps {

    private Google google;

    @Given("^I am on google home page$")
    public void I_am_on_google_home_page() throws Throwable {
        google = new Google();
        Sites.launchedSites.put("google",google);


    }

    @When("^I search for \"([^\"]*)\"$")
    public void I_search_for(String criteria) throws Throwable {
        google.homePage().searchFor(criteria);
    }
}
