Feature: User can change currency using the Change Currency Button

  Scenario: Whenever the user is inside CPQ and in the commerce page they can utilize the change
    currency button to change the quote currency.

    When I open the login page
    Then I login
    Then User changes the currency to GBP from drop down and clicks on change currency button
    Then User checks if the quote currency has changed to GBP