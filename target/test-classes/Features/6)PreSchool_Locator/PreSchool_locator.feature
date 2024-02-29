Feature: FirstCry Preschool Locator Automation

  Scenario: Preschool to FirstCry
    Given user is in the HomePage
    Given user can click on storeandpreschool
    And user can click on findpreschool
    And user switches to the new tab
    And user clicks on the available city
    And click on findmy preschool
    And user must able to verify the firstcry Intellitots preschools in Banglore
    Then Verify page title
