package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * BasePage
 * Class implements the base methods and fields.
 *
 * @author Inna Drukerman innysik@gmail.com
 */
public class BasePage {

    public static WebDriver driver;
    public static String basicURL = "https://www.google.com/";
    public static String googleMapsUrl = "https://www.google.com/maps";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public static void sendKeysToWebElement(WebElement element, String text){
        element.sendKeys(text);
    }


}
