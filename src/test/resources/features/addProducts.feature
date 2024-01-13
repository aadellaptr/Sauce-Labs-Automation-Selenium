@All
Feature: Cart Management

  Background:
    Given User is on login page
    When User fill username and password
    And User click login button
    Then User verify login result

    @Cart @Update
    Scenario: Add Products to Cart
      When User adds products "onesie, bolt-t-shirt" to the cart
      Then Shopping cart badge should display the correct count
      When User click cart icon
      Then Cart should display the correct products

    @Cart @Delete
    Scenario: Delete Products from Cart
      Given User has added products "onesie, bolt-t-shirt" to the cart
      When User clicks remove button for "onesie"
      Then Shopping cart badge should be reduced by 1
      When User clicks cart icon
      Then Cart should not contain "onesie"

