Feature: Logout

  Background:
    Given User is on login page
    When User fill username and password
    And User click login button
    Then User verify login result
  @Logout
  Scenario: Logout User
    Given User is logged in
    When User clicks the side button
    And User clicks the logout button
    Then Verify logout result
