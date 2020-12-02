package com.herokuapp.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * DomPage
 * Class implements the base methods and fields.
 *
 * @author Inna Drukerman innysik@gmail.com
 */
public class DomPage extends BasePage {

    public DomPage(WebDriver driver) {
        super(driver);
    }

    public static final By blueButton = By.xpath(".//a[@class='button']");
    public static final By definiebas7 = By.xpath(".//td[contains(text(), 'Definiebas7')]");
    public static final By forthRowEditButton = By.xpath(".//tr[4]//td//a[@href='#edit']");
    public static final By forthRowDeleteButton = By.xpath(".//tr[4]//td//a[@href='#delete']");


}
