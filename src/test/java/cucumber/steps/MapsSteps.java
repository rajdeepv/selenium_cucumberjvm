package cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import sites.Sites;
import sites.maps.Maps;

import static org.fest.assertions.api.Assertions.assertThat;

public class MapsSteps {
    private Maps googleMaps;

    @Given("^I am on google maps home page$")
    public void I_am_on_google_maps_home_page() throws Throwable {
        googleMaps = new Maps();
        Sites.launchedSites.put("google",googleMaps);

    }

    @When("^I search for \"([^\"]*)\" on map$")
    public void I_search_for_Pune_on_map(String criteria) throws Throwable {
        googleMaps.mapsHomePage().searchPlace(criteria);

    }

    @And("^I locate Bhosari and get direction$")
    public void I_locate_Bhosari_and_get_direction() throws Throwable {
        googleMaps.mapsHomePage().getDirectionToBhosari();;
    }

    @Then("^I should see that Bhosari is \"([^\"]*)\" from Pune$")
    public void I_should_see_that_Bhosari_is_from_Pune(String expectedDistance) throws Throwable {
        String actualDistance = googleMaps.mapsHomePage().distanceFromPuneToBhosari();
        assertThat(expectedDistance).isEqualToIgnoringCase(actualDistance);
    }
}
