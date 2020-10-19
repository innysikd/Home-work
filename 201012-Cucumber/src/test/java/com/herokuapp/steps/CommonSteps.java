package com.herokuapp.steps;

import io.cucumber.java8.En;

import static com.codeborne.selenide.Selenide.open;
import static com.herokuapp.pages.BasePage.basicURL;

/**
 * CommonSteps
 * Class implements the common step definitions for several feature files.
 *
 * @author Violeta Abramova abramova.violetta@gmail.com
 */
public class CommonSteps implements En {

    public CommonSteps() {

        Given("I am on the {} page", (String page) -> {
            String partialUrl = null;
            if (page.equals("Hovers"))
                partialUrl = "/hovers";
            if (page.equals("Login"))
                partialUrl = "/login";
            open(basicURL + partialUrl);
        });
    }
}
