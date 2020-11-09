package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleMaps extends BasePage {

    public static final By searchField = By.id("");

    public GoogleMaps(WebDriver driver) {
        super(driver);
    }
}
