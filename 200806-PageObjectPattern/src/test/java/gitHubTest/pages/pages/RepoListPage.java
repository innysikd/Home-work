package gitHubTest.pages.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

public class RepoListPage extends PageObject {

    public RepoListPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "your-repos-filter")
    private WebElement newRepoName;

    @FindBy(xpath = "//*[@id=\"user-repositories-list\"]/ul/li/div[1]/div[1]/h3/a")
    private WebElement searchResult;

    public void fillRepoName (String repoName){
        newRepoName.sendKeys(repoName);
        newRepoName.submit();
    }

    public String getSearchResult() {
        return searchResult.getText();
    }

    public void searchRepo(String repoName){

    }
}
