package gitHubTest.pages.pages;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.FunctionalTest;

import static jdk.vm.ci.meta.JavaKind.Char;
import static org.junit.Assert.*;

@FixMethodOrder
public class BasicTest extends FunctionalTest {

    LoginPage loginPage = new LoginPage(driver);
    MainPage mainPage;
    String user = "innysikd";
    String password = "12togo34";
    String baseURL = "https://github.com/login";
    String repoListURL = "https://github.com/innysikd?tab=repositories";
    CreateRepoPage createPage;
    String repoName = "test_name2";
    String repoDescr = "some description";
    //SettingsPage settingsPage;
    RepoListPage repoListPage = new RepoListPage(driver);
    SettingsPage settings;

    @Before
    public void init() {
        driver.get(baseURL);
        mainPage = loginPage.login(user, password);
    }

    @After
    public void logOut() {
        driver.findElement(By.xpath("/html/body/div[1]/header/div[7]/details/summary")).click();
        driver.findElement(By.xpath("/html/body/div[1]/header/div[7]/details/details-menu/form/button")).click();
    }

    @Test
    public void createRepo() throws InterruptedException {
        createPage = mainPage.createRepo(user, password);
        assertFalse(createPage.createBtnEnabled());

		createPage.fillRequiredProperties(repoName, repoDescr);
		Thread.sleep(3000);
        assertTrue(createPage.createBtnEnabled());

		createPage.create();

        assertTrue(createPage.getRepoLabel().equals(repoName)); //strictly speaking we need particular page for it
        assertTrue(createPage.getUserLabel().equals(user));

        // Assert for created repo search result
        driver.get(repoListURL);
        repoListPage.fillRepoName(repoName);
        assertEquals(repoName, repoListPage.getSearchResult());
        System.out.println("Created repo " + repoName);
    }

    @Test
    public void deleteRepo(){
        driver.get("http://github.com/" + user + "/" + repoName + "/settings");
        settings = new SettingsPage(driver);
        //TODO check that submition is disabled

        settings.deleteRepo(user + "/" + repoName);

        //TODO to assert the label the label "Your repository "prokov/Repo175188" was successfully deleted."

        //*[@id="js-flash-container"]/div/div

        //Assert the deleted repo search result
        driver.get(repoListURL);
        repoListPage.fillRepoName(repoName);
        String searchResult = driver.findElement(By.xpath("//*[@id=\"user-repositories-list\"]/div[1]/div[1]")).getText();
        assertEquals('0', searchResult.charAt(0));
        System.out.println("Deleted repo " + repoName);


    }

}
