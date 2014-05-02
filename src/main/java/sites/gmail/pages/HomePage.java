package sites.gmail.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Waiter;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver dr) {
        driver = dr;
    }

    public WebElement chatList(String name) {
        return driver.findElement(By.xpath("//span[.='" + name + "']"));
    }

    public WebElement latestMessage() {
        return driver.findElement(By.xpath("//div[@role='log']/div/div[last()-1]"));
    }

    public WebElement chatTextBox() {
        return driver.findElement(By.xpath("//div[@class='AD']//textarea"));
    }

    public void sendPingTo(String name, String message) {
        Waiter.waitForAMinuite(driver).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='vB']")));
        chatList(name).click();
        chatTextBox().sendKeys(message);
        chatTextBox().sendKeys(Keys.RETURN);
    }

    public String lastMessage(){
        Waiter.waitForAMinuite(driver).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='log']")));
        return latestMessage().getText();
    }


}
