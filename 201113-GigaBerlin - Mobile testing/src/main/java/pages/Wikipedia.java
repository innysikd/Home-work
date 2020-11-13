package pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Wikipedia extends BasePage{

    public static final By searchField = By.id("searchInput");
    public static final By searchBtn = By.xpath("//i[contains(text(),'Search')]");
    public static final By coordinates = By.xpath("//tbody/tr[5]/td[1]/span[1]/span[1]/a[1]/span[3]/span[1]");
    public String coordinatesData;

    public Wikipedia() {
    }

    public Wikipedia search(String searchText){
        sendKeysToElement(searchField, searchText);
        clickElement(searchBtn);
        return new Wikipedia();
    }

    public String getCoordinatesData(){
        coordinatesData = $(coordinates).getText();
        return coordinatesData;
    }
}
