package sites.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import sites.IwebSite;
import sites.Sites;
import sites.google.pages.GooglePages;
import sites.google.pages.HomePage;
import sites.google.pages.SearchResultsPage;

import java.util.concurrent.TimeUnit;


public class Google implements IwebSite {
    private String base_url;
    private WebDriver driver;
    private HomePage homePage;
    private SearchResultsPage searchResultsPage;


    public Google() {
        DesiredCapabilities dCaps = new DesiredCapabilities();
        dCaps.setJavascriptEnabled(true);
        dCaps.setCapability("takesScreenshot", true);

        base_url = "http://www.google.com";
//        driver = new PhantomJSDriver(dCaps);
        driver = new ChromeDriver();
//        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(base_url);
        GooglePages.setDriver(driver);
        driver.manage().window().maximize();
    }

    public void close() {
        driver.close();
    }

    public HomePage homePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;
    }

    public SearchResultsPage searchResultsPage() {
        if (searchResultsPage == null) {
            searchResultsPage = PageFactory.initElements(driver, SearchResultsPage.class);
        }
        ;
        return searchResultsPage;
    }


}
