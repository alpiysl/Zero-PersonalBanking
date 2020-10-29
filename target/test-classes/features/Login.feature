@test
Feature:Login Page

  Scenario Outline: Login with <Credentials> credentials
    Given users should be able to login to the application.
      | username | username |
      | password | password |
    Then "Account Summary" page should be displayed.

    Examples:
      | Credentials |
      | authorized  |
      | valid       |


  Scenario: login with wrong credentials
    Given login with wrong username or wrong password should not be able to login.
      | username | Alpaslan |
      | password | 123456   |
    Then error message "Login and/or password are wrong." should be displayed.

  Scenario: login with blank credentials
    Given login with blank username or password should also not be able to login.
    Then error message "Login and/or password are wrong." should be displayed.

