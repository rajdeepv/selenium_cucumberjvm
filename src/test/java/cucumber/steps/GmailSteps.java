package cucumber.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import sites.Sites;
import sites.gmail.Gmail;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created with IntelliJ IDEA.
 * User: rajdeepverma
 * Date: 5/2/14
 * Time: 3:18 PM
 * To change this template use File | Settings | File Templates.
 */
public class GmailSteps {

    private Gmail senderGmail;
    private Gmail receiverGmail;

    @Given("^Sender is logged into Gmail as user \"([^\"]*)\"$")
    public void Sender_is_logged_into_Gmail_as_user(String senderEmail) throws Throwable {
        senderGmail = new Gmail();
        Sites.launchedSites.put("SenderGmail",senderGmail);
        senderGmail.loginPage().SignIn(senderEmail,"<password>");
        senderGmail.setPositionAndSize(0,0,700,1000);
    }

    @And("^Receiver is logged into Gmail as user \"([^\"]*)\"$")
    public void Receiver_is_logged_into_Gmail_as_user(String recieverEmail) throws Throwable {
        receiverGmail = new Gmail();
        Sites.launchedSites.put("receiverGmail",receiverGmail);
        receiverGmail.loginPage().SignIn(recieverEmail,"<password>");
        receiverGmail.setPositionAndSize(800, 0, 700, 1000);
    }

    @When("^Sender sends a ping$")
    public void Sender_sends_a_ping() throws Throwable {
        senderGmail.homePage().sendPingTo("babu","Good Evening");
    }

    @Then("^Receiver should recieve it$")
    public void Receiver_should_recieve_it() throws Throwable {
        String latestMessage = receiverGmail.homePage().lastMessage();
        assertThat(latestMessage).contains("Good Evening");
    }
}
