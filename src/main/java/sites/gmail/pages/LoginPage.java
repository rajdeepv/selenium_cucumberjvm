package sites.gmail.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.Waiter;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver dr) {
        driver = dr;
    }

    public WebElement loginTextBox() {
        return driver.findElement(By.id("Email"));
    }

    public WebElement passwordTextBox() {
        return driver.findElement(By.id("Passwd"));
    }

    public WebElement signInButton() {
        return driver.findElement(By.id("signIn"));
    }

    public void SignIn(String emailId, String password) {
        loginTextBox().sendKeys(emailId);
        passwordTextBox().sendKeys(password);
        signInButton().click();
        Waiter.waitFor15Seconds(driver).until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
        Waiter.waitForAMinuite(driver).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='vB']")));
    }
}
