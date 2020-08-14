package utils;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class FunctionalTest {

    protected static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Alex/Desktop/tel-ran/Testing/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().deleteAllCookies();
    }
    @After
    public void cleanUp() {
    }

    @AfterClass
    public static void tearDown() {
        //	driver.close();
    }

    //to make a screenshot for each test where assert fails

    //our rule: print failed test name and exception name. then take a screenshot
    @Rule
    public final TestRule watchman = new TestWatcher() {
        // This method gets invoked if the test fails for any reason:
        @Override
        protected void failed(Throwable e, Description description) {
            // Print out the error message:
            System.out.println(description.getDisplayName() + " " + e.getClass().getSimpleName() + "\n");
            // Now you can do whatever you need to do with it, for example take a screenshot
            takeScreenShot(description.getDisplayName());
        }
    };

    private void takeScreenShot(String methodName) {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("src/screenshots/" + LocalDateTime.now().toString().substring(0, 19).replace(":", "-") + "_" + methodName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
