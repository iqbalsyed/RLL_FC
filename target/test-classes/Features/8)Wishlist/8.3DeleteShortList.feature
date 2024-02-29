@DelteFomShortList
Feature: Delete Product From ShortList
  User wants to delete from shortlist

  Scenario Outline: Verify delete product from shortlist functionality
    Given Open the firstCry Website
    Then Use email to login
    Then Click on shortlist and delete product
    Then Verify product is deleted
