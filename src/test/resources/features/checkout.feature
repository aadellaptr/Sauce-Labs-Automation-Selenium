Feature: Checkout

  Background:
    Given User is on login page
    When User fill username and password
    And User click login button
    Then User verify login result
    When User adds products "onesie, bolt-t-shirt" to the cart
    Then Shopping cart badge should display the correct count

  @Checkout @VerifyPrice
  Scenario Outline: Verify Checkout Overview Total and Tax
    Given User is on the shopping cart page
    And Check the total price, tax, and total price + tax of the products
    Then User goes to the checkout information page
    When User fill <first_name>, <last_name>, and <zip_code>
    And User clicks the continue
    Then Verifies that the total on the checkout overview matches the calculated total and tax
    When User clicks the finish button
    Then Checkout is complete

    Examples:
      |first_name|last_name|zip_code| result |
      |John      |Doe      |12345   | Passed |
