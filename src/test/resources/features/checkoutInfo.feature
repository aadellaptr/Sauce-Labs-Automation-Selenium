Feature: Checkout Information

  Background:
    Given User is on login page
    When User fill username and password
    And User click login button
    Then User verify login result
    When User adds products "onesie, bolt-t-shirt" to the cart
    And User click cart icon
    And User click checkout button
    Then User is on the checkout information page

  @Checkout @VerifyPrice
  Scenario Outline: Verify Checkout Information
    Given User is on the checkout information page
    When User click checkout button
    And User fill <first_name>, <last_name>, and <zip_code>
    And User clicks the continue
    Then Verify checkout information <result>

    Examples:
      |first_name|last_name|zip_code| result |
      |John      |Doe      |12345   | Passed |
      |      |Doe      |12345   | Failed |
      |John      |      |12345   | Failed |
      |John      |Doe      |  | Failed |