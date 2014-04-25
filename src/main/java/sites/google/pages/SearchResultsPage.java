package sites.google.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.ArrayList;
import java.util.List;


public class SearchResultsPage {

    @FindBy(xpath = "//li[@class='g' and not(@id = 'newsbox')]//h3//a")
    List<WebElement> searchResultsTitle;

    public List<String> allResults(){
        List<String> results = new ArrayList<String>();

        for(WebElement e:searchResultsTitle){
            results.add(e.getText());
            System.out.println(e.getText());
        }
        System.out.println("*************");
        System.out.println("****** Total: "+ results.size() + " Results ******");
        System.out.println("*************");
        return results;
    }
}
