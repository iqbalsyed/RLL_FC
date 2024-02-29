@Deletechild
Feature: Delete Child
  User wants to delete child

  Scenario Outline: Verify deletion of Child
    Given Open up Website
    When Login using the email
    Then Click on the Profile
    Then Delete the child
