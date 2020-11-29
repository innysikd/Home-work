package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * UserPage
 * Class implements the base methods and fields.
 *
 * @author Inna Drukerman innysik@gmail.com
 */
public class UserPage extends BasePage{

    public static final By text = By.xpath("/html/body/h1");

    public UserPage(WebDriver driver) {
        super(driver);
    }
}
