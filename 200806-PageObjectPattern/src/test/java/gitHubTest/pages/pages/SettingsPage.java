package gitHubTest.pages.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class SettingsPage extends PageObject {

    public SettingsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath="//*[@id=\"options_bucket\"]/div[10]/ul/li[4]/details/summary")
    private WebElement deleteRepo;

    @FindBy(xpath="//*[@id=\"options_bucket\"]/div[10]/ul/li[4]/details/details-dialog/div[3]/form/p/input")
    private WebElement inputBox;

    @FindBy(xpath="//*[@id=\"options_bucket\"]/div[10]/ul/li[4]/details/details-dialog/div[3]/form/button")
    private WebElement deleteRepoBtn;

    public void deleteRepo(String repoName){
        deleteRepo.click();
   //     driver.switchTo().activeElement();
        inputBox.sendKeys(repoName);
        deleteRepoBtn.click();
    }
}
