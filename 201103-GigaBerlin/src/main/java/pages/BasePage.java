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
     *Sends keys to the field and clicks the button
     * @param searchField
     * @param searchText
     */
    public void sendKeysToElement(By searchField, String searchText){
        $(searchField).setValue(searchText);
    }

    public void clickElement(By searchBtn){
        $(searchBtn).click();
    }

}
