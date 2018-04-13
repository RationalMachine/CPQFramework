Feature: Spoke cannot be added without a Hub

  Scenario: A Spoke product cannot be added if you do not enter the details for an existing hub

    When User opens the C4C login page
    Given He signs in
    Then I click on Add Product
    Then I hover and click on spoke
    Then I enter the address details for the spoke
    Given I assert if constraint message for hub exists
    Then I click on start over button
    And I assert if I am in product page

