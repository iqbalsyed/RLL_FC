@Profile
Feature: My Profile Page Under My Account
  User wants to verify that My Profile Page is availaible and reachable.

  @Profile
  Scenario Outline: Verification of My Profile Page
    Given Open FirstCry Website
    Then Login by <email>
    Then Click on My Profile under My Account
    Then get the url and verify My Profile Page is reached

    Examples: 
      | email               |
      | mkfbdhvmg@gmail.com |
