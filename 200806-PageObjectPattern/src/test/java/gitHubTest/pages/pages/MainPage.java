package gitHubTest.pages.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class MainPage extends PageObject {

    public MainPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath ="//*[@id=\"repos-container\"]/h2/a")
    private WebElement createRepoBtn;

    public CreateRepoPage createRepo(String user, String pass){
        createRepoBtn.click();
        return new CreateRepoPage(driver);
    }
}
