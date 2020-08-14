package tmdb;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.FunctionalTest;

import java.util.List;

import static org.junit.Assert.*;


public class TestTmdb extends FunctionalTest {

    String baseUrl = "https://www.themoviedb.org/";
    HomePage homePage = new HomePage(driver);
    NowPlaying nowPlaying = new NowPlaying(driver);

    @Before
    public void init() {
        driver.get(baseUrl);
    }

    /*
     TestCase1. Caption:  Navigation panel
    Action:
    1.goto baseURI
    2. Select any available element from Navigation panel (e.g. Movies->Popular), click
    Expected result:
    Title matches the selection, e.g. "Popular Movies"
     */
    @Test
    public void TestCase1(){
        homePage.chooseFromTheMenu();
        assertEquals("Now Playing Movies", nowPlaying.checkTitleText());
    }

    /*
    TestCase2.
    Caption:  Basic search from mainPage
    Action:
    1.goto baseURI
    2. Enter search criteria (full match), e.g. One Flew Over the Cuckoo's Nest into Search inputBox
    Expected result:
    Each element in found list contains search string (e.g. "One Flew Over the Cuckoo's Nest)"
    TODO: Extend to more cases (low, upper register, fuzzy search etc.)
     */
    @Test
    public void TestCase2(){
        homePage.findMovie("one flew over the cuckoo's nest");

        List<WebElement> moviesList = driver.findElements(By.className("title"));

        for (WebElement listItem : moviesList){
            driver.findElement(By.tagName("h2"));
            System.out.println(listItem.getText());
            assertTrue (listItem.getText().toLowerCase().contains("one flew over the cuckoo's nest"));
        }
    }

    /*
    TestCase3.
    Caption:  Basic search from mainPage via Search icon including autocomplete
    1.goto baseURI
    2. Click on
    3. Enter search criteria, e.g. "nest"
    Expected result:
    Autocomplete list items contains search string
     */
    @Test
    public void testCase3(){

    }


}
