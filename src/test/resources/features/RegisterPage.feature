Feature: User Registration

  Scenario: User should navigate to register page successfully
    Given User is on homepage
    When User clicks on Register link
    Then User should navigate to register page successfully


  Scenario: User shall enter values in Register page
    Given User is on homepage
    When User clicks on Register link
    And User is on Register page
    When User enters valid personal information
    And User enters valid Userid and passwords
    And clicks on Register button
    Then Welcome new user page should be displayed

  Scenario: Error message should be displayed for missing required fields
    Given User is on homepage
    When User clicks on Register link
    And User leaves First Name field empty
    And clicks on Register button
    Then Error message should be displayed for missing required fields