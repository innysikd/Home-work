package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * DataTablesPage
 * Class implements the base methods and fields.
 *
 * @author Inna Drukerman innysik@gmail.com
 */
public class DataTablesPage extends BasePage{

    public DataTablesPage(WebDriver driver) {
            super(driver);
    }

    public static final By lastName = By.xpath("//*[@id=\"table2\"]/thead/tr/th[1]/span");
    public static final By lastNameColumn = By.xpath("//*[@id=\"table2\"]/tbody/tr/td[1]");

}
