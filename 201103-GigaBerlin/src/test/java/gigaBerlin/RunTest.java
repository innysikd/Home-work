package gigaBerlin;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

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

public class RunTest extends FunctionalTest{

    @Test
    public void test(){

        Selenide.open(BASE_URL);

        Selenide.switchTo().frame(0);

        google.acceptCookies();
        google.searchGoogle(WIKI_SEARCH_TEXT);
        google.clickWiki();
        wikipedia.search(SEARCH_GIGA);

        assert ($(LOGISTICS).getText().contains("Logistics"));
        assert ($(SITE_CONCERNS).getText().contains("Site concerns"));

        googleMaps.searchCoordinates(wikipedia.getCoordinates());

        assert ($(By.tagName("h1")).getText().contains("52°24'00.0\"N 13°48'00.0\"E"));
    }


}
