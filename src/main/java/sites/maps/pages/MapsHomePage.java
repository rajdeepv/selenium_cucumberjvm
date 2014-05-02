package sites.maps.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.sikuli.api.*;
import org.sikuli.api.robot.Key;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopMouse;
import org.sikuli.webdriver.ImageElement;
import utilities.Env;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class MapsHomePage extends MapsPages {

    private WebElement searchBox() {
        return driver.findElement(By.name("q"));
    }

    private WebElement searchButton() {
        return driver.findElement(By.className("gbqfb"));
    }

    private ImageElement bhosri() throws IOException {
        return driver.findImageElement(new URL("file:///"+Env.ProjectRoot+"/src/main/resources/ImageLocators/bhosari.png"));
    }

    private ImageElement directionToHere() throws IOException {
        return driver.findImageElement(new URL("file:///"+Env.ProjectRoot+"/src/main/resources/ImageLocators/DirectionToHere.png"));
    }

    private WebElement defaultRouteDistance(){
        return driver.findElement(By.cssSelector("#altroute_0 .altroute-rcol"));
    }

    public void searchPlace(String placeName) {
        searchBox().sendKeys(placeName);
        searchButton().click();
    }

    public void getDirectionToBhosari() throws IOException {
        bhosri().doubleClick();
        bhosri().doubleClick();
        Target tg = new ImageTarget(new File(Env.ProjectRoot+"/src/main/resources/ImageLocators/bhosari.png"));
        ScreenRegion sr = new DesktopScreenRegion();
        Mouse mouse = new DesktopMouse();
        mouse.rightClick(sr.find(tg).getCenter());
        directionToHere().click();

    }

    public String distanceFromPuneToBhosari(){
        return defaultRouteDistance().getText().split(",")[0];
    }


}
