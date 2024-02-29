@MoveToCart
Feature: Move Product From ShortList to Cart
  User wants to move product from shortlist to cart

  Scenario Outline: Verify the product is moved to cart
    Given Open  firstCry Website
    Then Use email for login
    Then Click on shortlist and move product
    Then Verify product is moved to cart