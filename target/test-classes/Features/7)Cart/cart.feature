#Author: Srikanth Mudadla
Feature: Verify add to cart module check product visibility
  user clicks on add to cart, the product should be added to cart.

  Scenario Outline: Verify add to cart module check product visibility
    Given Open the Firstcry application in firefox Browser
    And Browser maximized
    When Search product "<product_name>"
    Then Click Search
    And view specific product
    Then add product to cart
    Then Click on cart button to view cart
    When The cart has the products
    Examples: 
      | product_name  |
      | Tricycles     |
