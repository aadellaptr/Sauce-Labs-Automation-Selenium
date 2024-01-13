Feature: Login with TDD

  @TDD @Login
  Scenario Outline: Login with TDD
    Given User is on login pages
    When User input <username> and <password>
    And User clicks login button
    Then User login <results>

    Examples:
    | username | password | results |
    | standard_user | secret_sauce | Passed |
    | locked_out_user | secret_sauce | Passed |
    | problem_user | secret_sauce | Passed |
    | performance_glitch_user | secret_sauce | Passed |
    | error_user | secret_sauce | Passed |
    | visual_user | secret_sauce | Passed |
    | invalid_username | secret_sauce | Failed |
    | standard_user | invalid_password | Failed |
    |  | secret_sauce | Failed |
    | standard_user |  | Failed |