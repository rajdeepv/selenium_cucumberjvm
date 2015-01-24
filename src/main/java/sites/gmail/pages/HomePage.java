package sites.gmail.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.Waiter;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver dr) {
        driver = dr;
    }

    public WebElement chatList(String name) {
        return driver.findElement(By.xpath("//span[.='" + name + "']"));
    }

    public String latestMessage() {
        return driver.findElement(By.xpath("//div[@role='chatMessage' and @class='km'][last()]")).getText();
    }

    public WebElement chatTextBox() {
        return driver.findElement(By.xpath("//div[@class='AD']//textarea"));
    }

    public void sendPingTo(String name, String message) {
        waitForContactOnline(name);
        chatList(name).click();
        Waiter.waitFor15Seconds(driver).until(ExpectedConditions.elementToBeClickable(chatTextBox()));
        chatTextBox().sendKeys(message);
        chatTextBox().sendKeys(Keys.ENTER);
    }

    public String lastMessage(){
        Waiter.waitForAMinuite(driver).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@role='log']")));
        return latestMessage();
    }

    private void waitForContactOnline(final String name){
        Waiter.waitForAMinuite(driver).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                WebElement img = driver.findElement(By.xpath("//tr[contains(.,'"+name+"')]//img"));
                String status = img.getAttribute("Alt");
                if (status.contains("Available"))
                    return true;
                else
                    return false;
            }
        });
    }


}
