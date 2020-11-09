package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * ChromeWebDriver
 * Class sets the system suitable chromedriver and instantiates a Chrome WebDriver object.
 *
 * @author Violeta Abramova abramova.violetta@gmail.com
 */
public class GeckoWebDriver {

    private static final String DRIVER_PATH_WIN = "src\\main\\resources\\geckodrivers\\win\\geckodriver.exe";
    private static final String DRIVER = "webdriver.firefox.driver";

    /**
     * Static method checks for the system name and architecture type and sets the suitable system geckodriver properties.
     *
     * @return new WebDriver object which corresponds local system Firefox properties.
     */
    public static WebDriver getWebDriverInstance() {
        System.setProperty(DRIVER, DRIVER_PATH_WIN);
        return new FirefoxDriver();
    }
}
