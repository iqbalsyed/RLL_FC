@Addtoshortlist
Feature: ShortList
  User wants to add product to shortlist

  Scenario Outline: Verify shortlist works
    Given Open the FirstCRY Website
    When Login on using email
    Then Click on bestseller and add product to shortlist
    Then Verify product is added
