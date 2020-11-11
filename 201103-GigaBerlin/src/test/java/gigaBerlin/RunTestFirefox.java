package gigaBerlin;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static utils.Constants.*;

public class RunTestFirefox extends FunctionalTest {




    @Test
    public void test(){

        Selenide.open(BASE_URL);

      //  Selenide.switchTo().frame(0);

        googleFirefox.searchGoogle(WIKI_SEARCH_TEXT);

    }
}
