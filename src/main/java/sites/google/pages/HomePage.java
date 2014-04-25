package sites.google.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends GooglePages {
//    @FindBy(name = "q")
//    private WebElement searchBox = Sites.getGoogle().getDriver().findElement(By.name("q"));

    public WebElement searchBox() {
        return findElement(By.name("q"));
    }

    public void searchFor(String criteria) {
        searchBox().sendKeys(criteria);
        searchBox().sendKeys(Keys.RETURN);
    }

}
