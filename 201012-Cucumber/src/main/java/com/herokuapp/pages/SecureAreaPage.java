package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePage {

    public static final By pageTitle = By.tagName("h2");
    public SecureAreaPage(WebDriver driver) {
        super(driver);
    }
}
