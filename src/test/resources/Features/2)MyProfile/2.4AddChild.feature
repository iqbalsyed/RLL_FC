@Updatechild
Feature: Update Child
  User wants to update child

  Scenario Outline: Verify updation of Child
    Given Open up Website
    When Login using the email
    Then Click on the Profile
    Then Add child details
    Then Verify it is saved