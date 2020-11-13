package pages;

import org.openqa.selenium.By;

public class Google extends BasePage{

    private By searchField = By.name("q");
    private By searchBtn = By.name("btnK");
    private By acceptCookiesBtn = By.cssSelector("#introAgreeButton .RveJvd");
    private By wikiLink = By.xpath("//span[contains(text(),'Wikipedia.org')]");

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
