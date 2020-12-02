@dom
Feature: Challenging Dom Page
  Performing the tasks

  Background:
    Given I am on the Challenging Dom page

  Scenario: See the name on the blue button is changed
    When I click Blue Button
    Then I see a different name on it

  Scenario: Find Definiebas7
    Then I find Definiebas7 element on the page

  Scenario: Click on Edit on the 4th row of Action column
    When I click Edit Button
    Then I see the url's end point is changed to #edit

  Scenario: Click on Delete on the 4th row of Action column
    When I click Delete Button
    Then I see the url's end point is changed to #delete


