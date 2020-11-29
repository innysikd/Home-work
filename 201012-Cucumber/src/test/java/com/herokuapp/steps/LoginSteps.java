package com.herokuapp.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import org.openqa.selenium.By;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.herokuapp.pages.LoginPage.*;

/**
 * LoginSteps
 * Class implements the step definitions for testing the Login page.
 *
 * @author Inna Drukerman innysik@gmail.com
 */
public class LoginSteps implements En {

    public LoginSteps() {

        When("I enter user credentials:", (DataTable table) -> {
            List<Map<String, String>> dataTable = table.asMaps();
            String userName = dataTable.get(0).get("username");
            String userPass = dataTable.get(0).get("password");

            $(inputUserName).setValue(userName);
            $(inputUserPass).setValue(userPass);
        });

        When("I press the login button", () -> {
            $(loginButton).click();
        });

        Then("I'm still on the login page", () -> {
            $(By.tagName("h2")).shouldHave(text("Login Page"));
        });

        Then ("I see error message {}", (String message) -> {
            $(errorMessage).shouldHave(text(message));
        });



    }
}
