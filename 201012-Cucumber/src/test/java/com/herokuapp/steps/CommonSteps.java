package com.herokuapp.steps;

import com.herokuapp.pages.DataTablesPage;
import io.cucumber.java8.En;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.herokuapp.pages.BasePage.basicURL;
import static com.herokuapp.pages.DataTablesPage.lastName;
import static com.herokuapp.pages.DataTablesPage.lastNameColumn;

/**
 * CommonSteps
 * Class implements the common step definitions for several feature files.
 *
 * @author Inna Drukerman innysik@gmail.com
 */
public class CommonSteps implements En {

    public CommonSteps() {

        Given("I am on the {} page", (String page) -> {
            String partialUrl = null;
            if (page.equals("Hovers"))
                partialUrl = "/hovers";
            if (page.equals("Login"))
                partialUrl = "/login";
            if (page.equals("Data Tables"))
                partialUrl = "/tables";
            open(basicURL + partialUrl);
        });

        When("I click {}", (String btnName) -> {
            if (btnName.equals("Last Name"))
                $(lastName).click();
            if (btnName.equals("View profile"))
                $(By.linkText("View profile")).click();
        });
    }
}
