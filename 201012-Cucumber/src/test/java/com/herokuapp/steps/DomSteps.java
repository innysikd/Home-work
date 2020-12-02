package com.herokuapp.steps;

import io.cucumber.java8.En;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.herokuapp.pages.DomPage.*;
import static com.herokuapp.steps.CommonSteps.textBeforeClick;
import static org.junit.Assert.*;

/**
 * DomSteps
 * Class implements the step definitions for testing the Challenging Dom page.
 *
 * @author Inna Drukerman innysik@gmail.com
 */
public class DomSteps implements En {

    public DomSteps() {

        Then("I find Definiebas7 element on the page", () -> {
            assert $(definiebas7).exists();
        });

        Then("I see a different name on it", () -> {
            assertNotEquals(textBeforeClick, $(blueButton).getText());
        });

        Then ("I see the url's end point is changed to #edit", () -> {
            assert url().endsWith("#edit");
        });

        Then ("I see the url's end point is changed to #delete", () -> {
            assert url().endsWith("#delete");
        });



    }
}
