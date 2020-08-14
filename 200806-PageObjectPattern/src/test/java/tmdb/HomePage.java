package tmdb;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.PageObject;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends PageObject {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "/html/body/div[1]/header/div[1]/div/div[1]/ul/li[1]/a")
    private WebElement movies;

    @FindBy (xpath = "/html/body/div[1]/header/div[1]/div/div[1]/ul/li[1]/div/ul/li[2]/a")
    private WebElement nowPlaying;

    @FindBy (id = "inner_search_v4")
    private WebElement searchBox;

    @FindBy (xpath = "//*[@id=\"inner_search_form\"]/input")
    private WebElement searchBtn;

    public void chooseFromTheMenu(){
        clickOnWebElement(movies);
        clickOnWebElement(nowPlaying);
    }

    public void findMovie(String movieName){
        sendTextToWebElement(searchBox, movieName);
        clickOnWebElement(searchBtn);
    }



}
