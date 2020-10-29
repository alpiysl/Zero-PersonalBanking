Feature: Account Activity

  @a
  Scenario: Checking Account Activity Page
    Given User able to login
    Then click on Account Activity
    Then be on the "account-activity" page
    And the page must have "Zero - Account Activity" title
    And Account drop down should have "Savings" selected
    And the page must have following Account options
      | Checking    |
      | Savings     |
      | Loan        |
      | Credit Card |
      | Brokerage   |
    Then clicks search
    Then Transactions table must have following columns
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |