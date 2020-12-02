package com.herokuapp.steps;

import io.cucumber.java8.En;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.herokuapp.pages.BasePage.basicURL;
import static com.herokuapp.pages.DataTablesPage.lastName;
import static com.herokuapp.pages.DataTablesPage.lastNameColumn;
import static com.herokuapp.pages.DomPage.*;

/**
 * CommonSteps
 * Class implements the common step definitions for several feature files.
 *
 * @author Inna Drukerman innysik@gmail.com
 */
public class CommonSteps implements En {

    public static List<String> lastNamesBefore;
    public static String textBeforeClick;

    public CommonSteps() {

        Given("I am on the {} page", (String page) -> {
            String partialUrl = null;
            if (page.equals("Hovers"))
                partialUrl = "/hovers";
            if (page.equals("Login"))
                partialUrl = "/login";
            if (page.equals("Data Tables"))
                partialUrl = "/tables";
            if (page.equals("Challenging Dom"))
                partialUrl = "/challenging_dom";
            open(basicURL + partialUrl);
        });

        When("I click {}", (String btnName) -> {
            if (btnName.equals("Last Name")){
                lastNamesBefore = $$(lastNameColumn).texts();
                $(lastName).click();
            }
            if (btnName.equals("View profile"))
                $(By.linkText("View profile")).click();
            if (btnName.equals("Blue Button")){
                textBeforeClick = $(blueButton).getText();
                $(blueButton).click();
            }
            if (btnName.equals("Edit Button"))
                $(forthRowEditButton).click();
            if (btnName.equals("Delete Button"))
                $(forthRowDeleteButton).click();
        });
    }
}
