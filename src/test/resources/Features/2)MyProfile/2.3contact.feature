@UpdateContact
Feature: Update Contact
  User wants to update contact

  Scenario Outline: Verify updation of Contact
    Given Open fc Website and do login
    Then Navigate to My Profile
    Then update contact "<Number>"
    Then verify it gets passed

    Examples: 
      | Number     |
      | 9931345964 |
       #9934          less than 10
       #6853975642     random
