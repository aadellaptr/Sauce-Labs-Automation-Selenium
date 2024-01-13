@All
Feature: Login

  @Positive @Login
  Scenario: Login
    Given User is on login page
    When User fill username and password
    And User click login button
    Then User verify login result

  @Negative @Login
  Scenario: Login Failed
    Given User is on login page
    When User fill invalid username and password
    And User click login button
    Then User get error message