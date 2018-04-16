Feature: User can add Hub

  Scenario: An user can add a Hub product using the Add Product button

    Given they open C4C site
    Then they sign in
    Then user clicks on add product
    Then user selects Hub from the dropdown
    Then user is able to enter the address
    Then user is able to see check connectivity button
    Then user clicks check connectivity button
    Then user asserts that clicking on site details tab takes them to it
    Then user selects bandwidth of 1g from dropdown
    Then user selects resiliency as gold
    Then user asserts if base prices shown in table
    Then user goes to features tab and adds obh and fast track
    Then user asserts if both the features present in table
    Then user clicks update button
    Then user clicks save to quote
    Then user asserts CPQ page has the product added

