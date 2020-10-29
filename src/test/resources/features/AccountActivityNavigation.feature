@AccountActivity
Feature: Navigating to specific accounts in Accounts Activity Scenario: Savings account redirect

  Scenario Outline: <options> account redirect
    Given the user is logged in
    When the user clicks on "<options>" link on the Account Summary page
    Then the "Account Activity" page should be displayed
    And Account drop down should have "<options>" selected

    Examples:
      | options     |
      | Savings     |
      | Brokerage   |
      | Checking    |
      | Credit Card |
      | Loan        |
