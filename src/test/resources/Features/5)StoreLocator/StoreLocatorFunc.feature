@firstcry
Feature: Store Locator Functionality

  Background: 
    Given a User navigates to the web URL

  Scenario: User should be able to find FirstCry store locations
    Given the User can access the Homepage
    When User must hover over the stores&preschool
    And User must click on the find stores from drop down
    And switches focus to the new tab
    And selects the store type, state, and city
    And clicks on the search button
    Then the User should be able to view the store locations