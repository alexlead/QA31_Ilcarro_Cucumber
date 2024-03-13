Feature: Add Car

  @addCarTestForm
  Scenario: Add Car to the Website
    Given User launches Chrome Browser
    When User opens ilcarro Main Page
    And User clicks on login link
    And User enter valid data
    And User clicks on Yalla button
    And Close Success message display
    And Open let the car work page
    And Fill form with correct data
    And Submit the filled data form
    Then Verify Car added Message
    And User quites browser