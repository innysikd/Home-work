package com.herokuapp.steps;

import com.codeborne.selenide.commands.Hover;
import com.herokuapp.pages.HoversPage;
import io.cucumber.java8.En;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.matchesText;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.herokuapp.pages.HoversPage.*;
import static com.herokuapp.pages.UserPage.*;


/**
 * HoverSteps
 * Class implements the step definitions for testing the Hovers page.
 *
 * @author Violeta Abramova abramova.violetta@gmail.com
 */
public class HoverSteps implements En {
    public HoverSteps() {
        When("I hover avatar {}", (String index) -> {
            $(generateXpath(index)).hover();
        });

        Then("I observe the {} username", (String username) -> {
            By user;
            if(username.equals("user1")){
                user = user1;
                assert ($(user1).getText().contains(username));
            }
            if(username.equals("user2")){
                user = user2;
                assert ($(user2).getText().contains(username));
            }
            if(username.equals("user3")){
                user = user3;
                assert ($(user3).getText().contains(username));
            }
        });

        When("I click {}", (String text) -> {
            $(By.linkText("View profile")).click(); //search by text
        });


    }


}
