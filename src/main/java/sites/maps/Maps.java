package sites.maps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.sikuli.webdriver.SikuliFirefoxDriver;
import sites.IwebSite;
import sites.maps.pages.MapsHomePage;
import sites.maps.pages.MapsPages;

import java.util.concurrent.TimeUnit;

public class Maps implements IwebSite {
    private String base_url;
    private SikuliFirefoxDriver driver;
    private MapsHomePage homePage;


    public Maps() {
        base_url = "http://www.maps.google.com";
        driver = new SikuliFirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(base_url);
        MapsPages.setDriver(driver);
    }

    public void close() {
        driver.close();
    }

    public MapsHomePage mapsHomePage() {
        if (homePage == null) {
            homePage = new MapsHomePage();
        }
        return homePage;
    }

}