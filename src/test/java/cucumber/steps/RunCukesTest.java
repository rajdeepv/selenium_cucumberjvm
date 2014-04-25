package cucumber.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import sites.Sites;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.Map;


@RunWith(Cucumber.class)
public class RunCukesTest {

    @After()
    public void closeLms(){
        Sites.getGoogle().close();
    }


}
