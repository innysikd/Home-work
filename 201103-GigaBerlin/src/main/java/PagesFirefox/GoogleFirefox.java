package PagesFirefox;

import org.openqa.selenium.By;
import pages.BasePage;
import pages.Google;

import static com.codeborne.selenide.Selenide.$;

public class GoogleFirefox extends BasePage {

    private By searchField = By.id("newtab-search-text");
    private By searchBtn = By.name("searchSubmit");

    public Google searchGoogle(String searchText){
        sendKeysAndClick(searchField, searchBtn, searchText);
        return new Google();
    }
}
