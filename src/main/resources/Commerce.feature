
Feature: Commerce page should have proper info


  Scenario: Correct info should be present in commerce page pertaining to the account used

    When user opens login page
    Then user signs into CPQ
    Then user asserts deal class is bronze
    Then user asserts legal complexity is standard
    Then user asserts goapproval is y
    Then user asserts opportunity name is test_nam
    Then user asserts pricing segment is whss
    Then user asserts new logo is N


  Scenario: Approval tab is showing proper data

    Then user navigates to the approval tab
    Then user asserts if submit to approval button exists