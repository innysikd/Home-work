package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Wikipedia extends BasePage{

    public static final By searchField = By.id("searchInput");
    public static final By searchBtn = By.xpath("//*[@id=\"search-form\"]/fieldset/button/i");
    public static final By location = By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table[1]/tbody/tr[5]/td/span[1]/span/a/span[3]/span[1]");
    public String coordinates;

    public Wikipedia() {
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
