package SeleniumFunctionalTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class ReceiptPage extends PageObject {

    @FindBy(tagName = "h1")
    private WebElement header;
    public ReceiptPage(WebDriver driver) {
        super(driver);
    }

    //it is a common way to make an initializer
    public boolean isInitialized() {
        return header.isDisplayed();
    }

    public String confirmationHeader() {
        return header.getText();
    }
}
