@firstcry
Feature: Store Locator Functionality with Error

  Background: 
    Given User navigates to the web URL

  Scenario: User should be able to find store locations in FirstCry
    Given User must be able to access HomePage
    When User must click over the stores&preschool
    When User must clicks on the find stores from drop down
    When User switch to the new tab
    When User views store page and click on search button with empty fields
