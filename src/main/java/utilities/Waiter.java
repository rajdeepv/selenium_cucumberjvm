package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waiter {
    public static WebDriverWait waitForAMinuite(WebDriver driver){
        return new WebDriverWait(driver,60,1);
    }

    public static WebDriverWait waitFor15Seconds(WebDriver driver){
        return new WebDriverWait(driver,15,1);
    }
}
