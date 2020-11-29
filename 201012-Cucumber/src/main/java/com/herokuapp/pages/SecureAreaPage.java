package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * SecureAreaPage
 * Class implements the base methods and fields.
 *
 * @author Inna Drukerman innysik@gmail.com
 */
public class SecureAreaPage extends BasePage {

    public static final By pageTitle = By.tagName("h2");
    public SecureAreaPage(WebDriver driver) {
        super(driver);
    }
}
