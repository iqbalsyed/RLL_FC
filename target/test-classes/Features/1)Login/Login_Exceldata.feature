#Author: nagamani@your.domain.com
@FirstCry
Feature: Login with user inavlid credential

  @InvalidLogin
  Scenario: Invalid login of User
    Given User lands on the homepage
    When user clikcs on the loginbtn
    And user enters the email from row <RowNumber>
    And user clicks on continuebtn <RowNumber>
    Then user gets the login status
    Examples:
    | RowNumber |
    | 0         |
    | 1         |
    
