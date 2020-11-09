package gigaBerlin;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import driver.ChromeWebDriver;
import driver.GeckoWebDriver;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import pages.BasePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.Google;
import pages.Wikipedia;

import static com.codeborne.selenide.Selenide.$;
import static utils.Constants.*;

public class RunTest {

    protected static WebDriver driver;
    protected static Wikipedia wikipedia = new Wikipedia(driver);
    protected static Google google = new Google(driver);

    @Parameters("browser")
    @BeforeTest
    public void setupBrowser(String browser){
        if (browser.equals("Chrome")){
            driver = ChromeWebDriver.getWebDriverInstance();
            WebDriverRunner.setWebDriver(driver); //set Selenide WebDriver
            System.setProperty("selenide.browser", "chrome");
        } else if (browser.equals("Firefox")){
            driver = GeckoWebDriver.getWebDriverInstance();
            WebDriverRunner.setWebDriver(driver); //set Selenide WebDriver
            //driver = new FirefoxDriver();
            System.setProperty("selenide.browser", "firefox");
        }
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void test(){
        driver.get(BASE_URL);

        //driver.findElement(By.className("RveJvd snByac")).click();
        //driver.switchTo().activeElement();#introAgreeButton > span > span
        Selenide.executeJavaScript("document.querySelector('#introAgreeButton > span > span').click()");
        By test = By.tagName("h1");
       // google.acceptCookies();
        assert ($(test).getText().contains("Bevor Sie fortfahren"));
        google.searchGoogle(WIKI_SEARCH_TEXT);
        google.clickWiki(WIKI_LINK_TEXT);


    }


}
