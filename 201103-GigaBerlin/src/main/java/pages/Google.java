package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static com.codeborne.selenide.Selenide.$;

public class Google extends BasePage{

    private By searchField = By.name("q");
    private By searchBtn = By.name("btnK");
    private By acceptCookiesBtn = By.className("RveJvd snByac");

    public Google(WebDriver driver) {
        super(driver);
    }

    public Google searchGoogle(String searchText){
        $(searchField).setValue(searchText);
        $(searchBtn).click();
        return new Google(driver);
    }

    public Wikipedia clickWiki(String linkText){
        $(By.linkText(linkText)).click();
        return new Wikipedia(driver);
    }

    public void acceptCookies(){
        $(acceptCookiesBtn).click();
    }
}
