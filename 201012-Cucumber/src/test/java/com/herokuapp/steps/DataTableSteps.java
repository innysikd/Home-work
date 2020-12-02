package com.herokuapp.steps;

import io.cucumber.java8.En;

import java.util.Collections;

import static com.herokuapp.steps.CommonSteps.lastNamesBefore;
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

    public DataTableSteps(){

        Then("I see the table is in the ascending order", () -> {
            Collections.sort(lastNamesBefore);
            assertEquals (lastNamesBefore, $$(lastNameColumn).texts());
        });

        Then("I see the table is in the descending order", () -> {
            Collections.reverse(lastNamesBefore);
            assertEquals (lastNamesBefore, $$(lastNameColumn).texts());
        });
    }
}
