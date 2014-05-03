package cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import sites.Sites;
import sites.gmail.Gmail;

import static org.fest.assertions.api.Assertions.assertThat;

public class GmailSteps {

    private Gmail senderGmail;
    private Gmail receiverGmail;

    @Given("^Sender is logged into Gmail as user \"([^\"]*)\"$")
    public void Sender_is_logged_into_Gmail_as_user(String senderEmail) throws Throwable {
        senderGmail = new Gmail();
        Sites.launchedSites.put("SenderGmail",senderGmail);
        senderGmail.setPositionAndSize(0,0,700,1000);
        senderGmail.loginPage().SignIn(senderEmail,"******");
    }

    @And("^Receiver is logged into Gmail as user \"([^\"]*)\"$")
    public void Receiver_is_logged_into_Gmail_as_user(String recieverEmail) throws Throwable {
        receiverGmail = new Gmail();
        Sites.launchedSites.put("receiverGmail",receiverGmail);
        receiverGmail.setPositionAndSize(800, 0, 700, 1000);
        receiverGmail.loginPage().SignIn(recieverEmail,"*****");
    }

    @When("^Sender sends a ping$")
    public void Sender_sends_a_ping() throws Throwable {
        senderGmail.homePage().sendPingTo("babu","Love you");
    }

    @Then("^Receiver should recieve it$")
    public void Receiver_should_recieve_it() throws Throwable {
        String latestMessage = receiverGmail.homePage().lastMessage();
        assertThat(latestMessage).contains("Love you");
    }
}
