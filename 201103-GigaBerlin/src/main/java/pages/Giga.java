package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Giga extends BasePage {

    @FindBy(linkText = "Logistics")
    private static WebElement logisticsLink;

    @FindBy(linkText = "Site concerns")
    private static WebElement siteConcernsLink;

    @FindBy(className = "geo-dec")
    private static WebElement coordinates;

    public Giga(WebDriver driver) {
        super(driver);
    }

    public static void getText(){
        coordinates.getText();
    }
}
