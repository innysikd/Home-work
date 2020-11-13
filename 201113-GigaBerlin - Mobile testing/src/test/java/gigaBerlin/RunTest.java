package gigaBerlin;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.*;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Selenide.$;
import static utils.Constants.*;

/*
TODO
Please try to start your automation using Google as a starting point and try to
reach the following page:
1) From www.google.com, your automation should take you to
www.wikipedia.com.
2) From there, it should find the article “Giga Berlin” using the search box.
3) Your automation should find the Coordinates of the location and the
following data: Logistics, Site concerns.
4) The automation should open a new tab to check Google Maps with the
location.
Make the tests work with multiple browsers (Chrome, Safari, etc.)
 */

public class RunTest extends FunctionalTest implements WebDriverProvider {

    @Nonnull
    @BeforeTest
    public WebDriver createDriver(@Nonnull DesiredCapabilities caps) {
        caps.setCapability("noReset", "false");
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Emulator");
        caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        caps.setCapability("chromedriverExecutable", "C:\\Users\\Alex\\Desktop\\tel-ran\\Testing\\201103-GigaBerlin\\src\\main\\resources\\chromedrivers\\win\\chromedriver.exe");
        URL url = null;
        try {
            url = new URL("http://localhost:4723/wd/hub");//appium url
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return new AndroidDriver(url, caps);
    }

    @Test
    public void test(){

        Selenide.open();

        Selenide.open(BASE_URL);

        Selenide.switchTo().frame(0);
        google.acceptCookies();
        Selenide.switchTo().parentFrame();

        google.searchGoogle(WIKI_SEARCH_TEXT);
        google.clickWiki();
        wikipedia.search(SEARCH_GIGA);

        assert ($(LOGISTICS).getText().contains("Logistics"));
        assert ($(SITE_CONCERNS).getText().contains("Site concerns"));

        googleMaps.searchCoordinates(wikipedia.getCoordinatesData());

        Selenide.switchTo().activeElement();
        assert ($(By.tagName("h1")).getText().contains("52°24'00.0\"N 13°48'00.0\"E"));
    }

}
