Feature:

  Scenario:
    Given I am on google home page
    When I search for "Dalhousie"
    Then I should get each result relevant to "Dalhousie"

  Scenario:
    Given I am on google home page
    When I search for "Kerala"
    Then I should get each result relevant to "Kerala"