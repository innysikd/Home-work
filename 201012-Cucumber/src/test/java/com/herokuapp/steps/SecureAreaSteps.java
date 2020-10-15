package com.herokuapp.steps;

import io.cucumber.java8.En;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.tagName;

public class SecureAreaSteps implements En {

    public SecureAreaSteps() {
        Then("I see Secure Area text", () -> {
            $(By.tagName("h2")).shouldHave(text("Secure Area"));
        });
    }
}
