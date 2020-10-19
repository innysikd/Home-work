@positive_login
Feature: Login page

  Scenario: Positive login
    Given I am on the Login page
    When I enter user credentials:
      | username | password             |
      | tomsmith | SuperSecretPassword! |
    And I press the login button
    Then I see Secure Area text

  @negative_login
  Scenario Outline: Negative login
    Given I am on the Login page
    When I enter user credentials:
      | username   | password   |
      | <username> | <password> |
    And I press the login button
    Then I see error message
    Then I'm still on the login page

    Examples:
      | username | password            |
      | inna     | SuperSecretPassword |
      | blah     |                     |
      |          |  ****** ****        |
      | tomsmith |                     |
      |          |                     |
      |  111111  |    222222           |

