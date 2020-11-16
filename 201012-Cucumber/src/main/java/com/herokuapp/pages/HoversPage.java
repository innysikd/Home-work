
package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * HoversPage
 * Class implements the hover methods and fields of the Hovers page.
 *
 * @author Violeta Abramova abramova.violetta@gmail.com
 */
public class HoversPage extends BasePage {

    /* properties */

    public static final By user3 = By.xpath("//div[3]/div/h5");
    public static final By user2 = By.xpath("//*[@id=\"content\"]/div/div[2]/div/h5");
    public static final By user1 = By.xpath("//*[@id=\"content\"]/div/div[1]/div/h5");

    public HoversPage(WebDriver driver) {
        super(driver);
    }

    public static By generateXpath(String index) {
        return By.xpath("(//img[@alt='User Avatar'])[" + index + "]");
    }

    public static UserPage clickViewProfile(WebElement element){
        element.click();
        return new UserPage(driver);
    }
}
