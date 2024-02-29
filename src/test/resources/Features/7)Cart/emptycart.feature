#Author: Srikanth Mudadla
Feature: Verify empty cart module check product visibility
  user clicks on add to cart, the product should be added to cart.

  Scenario Outline: Verify add to cart module check product visibility
    Given Open app(firstcry.com) in Browser
    And Browser maximized to view
    Then Click cart button in the homepage
    When The cart has no products
    And Can add products to the cart now
    Then Verify cart is empty