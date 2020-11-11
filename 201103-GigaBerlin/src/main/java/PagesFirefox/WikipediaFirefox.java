package PagesFirefox;

import org.openqa.selenium.By;
import pages.BasePage;
import pages.Wikipedia;

import static com.codeborne.selenide.Selenide.$;

public class WikipediaFirefox extends BasePage {

    public static final By searchField = By.id("searchInput");
    public static final By searchBtn = By.xpath("/html/body/div[3]/form/fieldset/button/i");
    public static final By location = By.xpath("/html/body/div[4]/div[3]/div[5]/div[1]/table[1]/tbody/tr[5]/td/span[1]/span/a/span[3]/span[1]");
    public String coordinates;

    public WikipediaFirefox() {
    }

    public Wikipedia search(String searchText){
        sendKeysToElement(searchField, searchText);
        clickElement(searchBtn);
        return new Wikipedia();
    }

    public String getCoordinates(){
        coordinates = $(location).getText();
        return coordinates;
    }
}
