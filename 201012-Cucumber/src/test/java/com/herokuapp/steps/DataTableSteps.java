package com.herokuapp.steps;

import io.cucumber.java8.En;

import java.util.Collections;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;
import static com.herokuapp.pages.DataTablesPage.*;
import static org.junit.Assert.assertEquals;

/**
 * DataTableSteps
 * Class implements the step definitions for testing the Data Table page.
 *
 * @author Inna Drukerman innysik@gmail.com
 */
public class DataTableSteps implements En {

    List<String> lastNames;

    public DataTableSteps(){

        Then("I see the table is in the ascending order", () -> {
            lastNames = $$(lastNameColumn).texts();
            Collections.sort(lastNames);
            assertEquals (lastNames, $$(lastNameColumn).texts());
        });

        Then("I see the table is in the descending order", () -> {
            Collections.reverse(lastNames);
            assertEquals (lastNames, $$(lastNameColumn).texts());
        });
    }
}
