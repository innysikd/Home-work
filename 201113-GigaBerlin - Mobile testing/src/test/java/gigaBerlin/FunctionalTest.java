package gigaBerlin;

import com.codeborne.selenide.Configuration;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.testng.annotations.*;
import pages.Google;
import pages.GoogleMaps;
import pages.Wikipedia;

import java.net.URL;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class FunctionalTest  {

    public Google google = new Google();
    public Wikipedia wikipedia = new Wikipedia();
    public GoogleMaps googleMaps = new GoogleMaps();
    private AppiumDriverLocalService service;

    @BeforeSuite
    public void globalSetup () {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
        Configuration.browser = FunctionalTest.class.getName();
        Configuration.browserSize = null;
        Configuration.startMaximized = false;
    }

    @AfterSuite
    public void globalTearDown () {
        if (service != null) {
            closeWebDriver();
            service.stop();
        }
    }

    public URL getServiceUrl () {
        return service.getUrl();
    }



}
