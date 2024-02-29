@UpdateProfile
Feature: Update Profile
  User wants to update profile

  Scenario Outline: Verify updation of Contact
    Given Open Website
    Then Login using <email>
    Then Click on My Profile
    Then update fields and check
    Then verify test is passed

    Examples: 
      | email               |
      | mkfbdhvmg@gmail.com |
