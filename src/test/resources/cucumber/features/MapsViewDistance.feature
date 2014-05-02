Feature:

  Scenario: See distance between two cities using google maps
    Given I am on google maps home page
    When I search for "Pune, Maharashtra, India" on map
    And I locate Bhosari and get direction
    Then I should see that Bhosari is "18.3 km" from Pune