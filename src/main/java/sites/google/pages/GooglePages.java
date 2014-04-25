package sites.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class GooglePages {
    private static WebDriver driver;

    public static void setDriver(WebDriver dr) {
        driver = dr;
    }

    protected WebElement findElement(By by) {
        return driver.findElement(by);
    }

}
