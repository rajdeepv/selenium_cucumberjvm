package sites.gmail;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import sites.IwebSite;
import sites.gmail.pages.HomePage;
import sites.gmail.pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class Gmail implements IwebSite {

    private String base_url;
    private WebDriver driver;

    private LoginPage loginPage;
    private HomePage homePage;


    public Gmail() {
        DesiredCapabilities dCaps = new DesiredCapabilities();
        dCaps.setJavascriptEnabled(true);
        dCaps.setCapability("takesScreenshot", true);
        base_url = "http://www.gmail.com";

//        driver = new PhantomJSDriver(dCaps);
//        driver = new ChromeDriver();
        driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(base_url);

    }

    public void close() {
        driver.close();
    }

    public LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public HomePage homePage() {
        if (homePage == null) {
            homePage = new HomePage(driver);
        }
        return homePage;
    }

    public void setPositionAndSize(int height, int width, int x, int y) {
        driver.manage().window().setPosition(new Point(height, width));
        driver.manage().window().setSize(new Dimension(x, y));
    }


}
