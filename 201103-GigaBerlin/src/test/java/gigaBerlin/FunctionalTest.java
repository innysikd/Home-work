package gigaBerlin;

import PagesFirefox.GoogleFirefox;
import PagesFirefox.WikipediaFirefox;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import pages.Google;
import pages.GoogleMaps;
import pages.Wikipedia;

public class FunctionalTest {

    public Google google = new Google();
    public GoogleFirefox googleFirefox = new GoogleFirefox();
    public Wikipedia wikipedia = new Wikipedia();
    public WikipediaFirefox wikipediaFirefox = new WikipediaFirefox();
    public GoogleMaps googleMaps = new GoogleMaps();

    @Parameters("browser")
    @BeforeTest
    public void setupBrowser(String browser){
        if (browser.equals("Chrome")){
            System.setProperty("selenide.browser", "chrome");
        } else if (browser.equals("Firefox")){
            System.setProperty("selenide.browser", "firefox");
        }
    }

}
