package cucumber.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;
import sites.IwebSite;
import sites.Sites;
import org.junit.runner.RunWith;
import utilities.Env;

import java.util.HashMap;


@RunWith(Cucumber.class)
public class RunCukesTest {


    @Before()
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", Env.ProjectRoot+"/src/main/resources/chromedriver");
        Sites.launchedSites.clear();
    }

    @After()
    public void closeAllSites(){
        for(IwebSite site: Sites.launchedSites.values()){
            site.close();
        }
    }



}
