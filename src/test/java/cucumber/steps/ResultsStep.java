package cucumber.steps;

import cucumber.api.java.en.Then;
import sites.Sites;
import sites.google.Google;
import java.util.List;

import static org.fest.assertions.api.Assertions.assertThat;


public class ResultsStep {

    private Google google;

    public ResultsStep(){
        google = Sites.getGoogle();
    }

    @Then("^I should get each result relevant to \"([^\"]*)\"$")
    public void I_should_get_results_relevant_to(String expectedResult) throws Throwable {
        List<String> results = google.searchResultsPage().allResults();

        for (String result:results){
            assertThat(result).contains(expectedResult);
        }
    }
}
