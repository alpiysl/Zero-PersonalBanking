Feature: Pay Bills Module
  @p
  Scenario: Checking Pay Bills Module
    Given User able to login
    Then click on Pay Bills
    And the page must have "Zero - Pay Bills" title
    When user fills the blanks
    And Amount field should not accept alphabetical or special characters.
    And Date field should not accept alphabetical characters.
    Then click On Pay
    And The payment was successfully submitted. displayed
    When user tries to make a payment without entering the amount or date,
    Then Please fill out this field displayed.

