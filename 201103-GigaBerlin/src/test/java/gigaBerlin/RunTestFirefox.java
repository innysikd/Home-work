package gigaBerlin;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static utils.Constants.*;

public class RunTestFirefox extends FunctionalTest {

    @Test
    public void test(){

        Selenide.open(BASE_URL);

        //Selenide.switchTo().frame(0);

        googleFirefox.searchGoogle(WIKI_SEARCH_TEXT);
        googleFirefox.clickWiki();
        wikipediaFirefox.search(SEARCH_GIGA);

        assert ($(LOGISTICS_FIREFOX).getText().contains("Logistics"));
        assert ($(SITE_CONCERNS_FIREFOX).getText().contains("Site concerns"));

        googleMaps.searchCoordinates(wikipediaFirefox.getCoordinates());

        assert ($(By.tagName("h1")).getText().contains("52°24'00.0\"N 13°48'00.0\"E"));
    }
}
