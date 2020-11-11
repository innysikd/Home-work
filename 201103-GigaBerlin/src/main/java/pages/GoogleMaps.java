package pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static utils.Constants.*;

public class GoogleMaps extends BasePage {

    public static final By searchField = By.id("searchboxinput");
    public static final By searchBtn = By.id("searchbox-searchbutton");


    public GoogleMaps() {
    }

    public GoogleMaps searchCoordinates(String coordinates){
        Selenide.open(MAPS_URL);
        $(searchField).setValue(coordinates);
        clickElement(searchBtn);
        return new GoogleMaps();
    }
}
