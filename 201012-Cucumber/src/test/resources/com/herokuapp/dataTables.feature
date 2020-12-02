@dataTables
Feature: Data Tables Page
  I click "Last Name" on  Example 2 table to sort it in an ascending and descending order

  Background:
    Given I am on the Data Tables page

  Scenario: Order the last name alphabetically
    When I click Last Name
    Then I see the table is in the ascending order
    When I click Last Name
    Then I see the table is in the descending order

