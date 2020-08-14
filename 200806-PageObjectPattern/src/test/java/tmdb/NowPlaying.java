package tmdb;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class NowPlaying extends PageObject {

    public NowPlaying(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"media_v4\"]/div/div/div[1]/h2")
    WebElement title;

    public String checkTitleText(){
        return title.getText();
    }
}
