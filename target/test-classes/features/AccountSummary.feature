Feature: Account Summary
@c
  Scenario: Checking Account Summary Page
    Given User able to login
    Then be on the "account-summary" page
    And the page must have "Zero - Account Summary" title
    And the page must have following Account types
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts      |
      | Loan Accounts       |
    Then Credit Accounts must have following columns
      | Account     |
      | Checking    |
      | Credit Card |