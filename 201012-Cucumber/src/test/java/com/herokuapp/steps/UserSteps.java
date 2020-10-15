package com.herokuapp.steps;

import io.cucumber.java8.En;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.herokuapp.pages.UserPage.text;
import static org.openqa.selenium.By.tagName;

public class UserSteps implements En {

    public UserSteps() {
        Then("I observe Not Found text", () -> {
            $(tagName("h1")).shouldHave(text("Not Found"));
        });
    }
}
