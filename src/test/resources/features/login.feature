Feature: Login Page

  @validData
  Scenario: Check User Can login with valid data
    Given User launches Chrome Browser
    When User opens ilcarro Main Page
    And User clicks on login link
    And User enter valid data
    And User clicks on Yalla button
    Then User verifies Success message display
    And User quites browser


  @wrongPassword
  Scenario: Check User Can't login with invalid password
    Given User launches Chrome Browser
    When User opens ilcarro Main Page
    And User clicks on login link
    And User enter valid email and invalid password
      | email | password |
      | <email> | <password>  |
    And User clicks on Yalla button
    Then User verifies Error message display
    And User quites browser
    Examples:
      | email | password |
      | testnue@gm.com | testNue@ |
      | testnue@gm.com | testNue1 |
      | testnue@gm.com | testnue@1 |
      | testnue@gm.com | @@@@@@@@1 |
      | testnue@gm.com | 123456781 |