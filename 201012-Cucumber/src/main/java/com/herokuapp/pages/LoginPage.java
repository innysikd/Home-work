package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * LoginPage
 * Class implements the base methods and fields.
 *
 * @author Inna Drukerman innysik@gmail.com
 */
public class LoginPage extends BasePage {

    public static final By inputUserName = By.id("username");
    public static final By inputUserPass = By.id("password");
    public static final By loginButton = By.xpath("//i[contains(text(),'Login')]");
    public static final By errorMessage = By.id("flash");

    public LoginPage(WebDriver driver) {
        super(driver);
    }
}
