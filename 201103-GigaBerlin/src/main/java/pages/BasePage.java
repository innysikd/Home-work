package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * BasePage
 * Class implements the base methods and fields.
 *
 * @author Inna Drukerman innysik@gmail.com
 */
public class BasePage {

    public BasePage() {
    }

    /**
     *Sends keys to the field
     * @param searchField
     * @param searchText
     */
    public void sendKeysToElement(By searchField, String searchText){
        $(searchField).setValue(searchText);
    }

    /**
     * Clicks the button
     * @param searchBtn
     */
    public void clickElement(By searchBtn){
        $(searchBtn).click();
    }

}
