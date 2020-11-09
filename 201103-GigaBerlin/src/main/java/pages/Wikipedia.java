package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;

public class Wikipedia extends BasePage{

    public static final By searchField = By.id("searchInput");
    public static final By searchBtn = By.xpath("//*[@id=\"search-form\"]/fieldset/button/i");

    public Wikipedia(WebDriver driver) {
        super(driver);
    }

    public static Giga search(String searchText){
        $(searchField).setValue(searchText);
        $(searchBtn).click();
        return new Giga(driver);
    }
}
