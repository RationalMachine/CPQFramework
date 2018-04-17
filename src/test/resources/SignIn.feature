Feature: C4C Login

  Scenario: Sign In
    When login to C4C
    Then I sign in
    Then I assert if I am inside CPQ

