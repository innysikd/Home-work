package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserPage extends BasePage{

    public static final By text = By.xpath("/html/body/h1");

    public UserPage(WebDriver driver) {
        super(driver);
    }
}
