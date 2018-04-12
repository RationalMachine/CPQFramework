Feature: C4C Login

  Scenario: Sign In
    When I open the C4C login page
    Then I sign in
    Then I assert if I am inside CPQ

