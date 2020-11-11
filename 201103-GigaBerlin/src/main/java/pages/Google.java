package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selenide.$;

public class Google extends BasePage{

    private By searchField = By.name("q");
    private By searchBtn = By.name("btnK");
    private By acceptCookiesBtn = By.cssSelector("#introAgreeButton .RveJvd");
    private By wikiLink = By.xpath("//*[@id=\"rso\"]/div[1]/div/div[1]/a/h3/span");

    public Google() {
    }

    public Google searchGoogle(String searchText){
        sendKeysToElement(searchField, searchText);
        clickElement(searchBtn);
        return new Google();
    }

    public Wikipedia clickWiki(){
        clickElement(wikiLink);
        return new Wikipedia();
    }

    public void acceptCookies(){
        clickElement(acceptCookiesBtn);
    }
}
