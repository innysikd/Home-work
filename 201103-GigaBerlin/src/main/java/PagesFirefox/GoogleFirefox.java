package PagesFirefox;

import org.openqa.selenium.By;
import pages.BasePage;
import pages.Google;
import pages.Wikipedia;

import static com.codeborne.selenide.Selenide.$;

public class GoogleFirefox extends BasePage {

    private By searchField = By.id("newtab-search-text");
    private By searchBtn = By.name("searchSubmit");
    private By wikiLink = By.xpath("/html/body/div[7]/div[2]/div[10]/div[1]/div[2]/div/div[2]/div[2]/div/div/div[1]/div/div[1]/a/h3/span");

    public Google searchGoogle(String searchText){
        sendKeysToElement(searchField, searchText);
        clickElement(searchBtn);
        return new Google();
    }

    public Wikipedia clickWiki(){
        clickElement(wikiLink);
        return new Wikipedia();
    }
}
