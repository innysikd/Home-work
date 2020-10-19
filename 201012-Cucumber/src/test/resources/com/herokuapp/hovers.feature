@hovers
Feature: Hovers Page
  In order to see the usernames
  I hover over the avatar pictures

Background:
    Given I am on the Hovers page

  Scenario Outline: Hover avatars
    When I hover avatar <avatar_index>
    Then I observe the <user_name> username
    Examples:
      | avatar_index  | user_name |
      |3              | user3         |
      |2              | user2         |
      |1              | user1         |

  Scenario: View profile
    When I hover avatar 3
    And I click View profile
    Then I observe Not Found text


