#Author: nagamani@your.domain.com
@FirstCry
Feature: I want to verify login with user credentials

  @Login
  Scenario: Login with valid email
    Given user should on the Firstcry website
    When User click on the login
    And User enters email
    And User will click on continue button
    And User manually enter the OTP
    Then User login should be successful
    