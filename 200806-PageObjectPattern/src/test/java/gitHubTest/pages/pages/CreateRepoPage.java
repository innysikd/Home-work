package gitHubTest.pages.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class CreateRepoPage extends PageObject {

    public CreateRepoPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id="repository_name")
    private WebElement name;

    @FindBy(id="repository_description")
    private WebElement description;

    @FindBy(xpath = "//*[@id=\"new_repository\"]/div[4]/button")
    private WebElement createButton;

    @FindBy(xpath="//*[@id='js-repo-pjax-container']/div[2]/div/div/h1/span[1]/a")
    private WebElement userLabel;

    @FindBy(xpath="//*[@id='js-repo-pjax-container']/div[2]/div/div/h1/strong/a")
    private WebElement repoLabel;

    public String getUserLabel() {
        return userLabel.getText();
    }

    public String getRepoLabel() {
        return repoLabel.getText();
    }

    public boolean createBtnEnabled(){
        waitForElementIsDispalyed(3000, createButton);
        return createButton.isEnabled();
    }

    //TODO To add all parameters like private, readme etc.
    public void  fillAllProperties(String repoName, String desc){
        name.sendKeys(repoName);
        description.sendKeys(desc);
    }

    public void  fillRequiredProperties(String repoName, String desc){
        name.sendKeys(repoName);
        description.sendKeys(desc);
    }

    public SettingsPage create(){
        createButton.click();
        return new SettingsPage(driver);
    }

}
