Feature:

  Scenario Outline:
    Given I am on google home page
    When I search for "<query>"
    Then I should get each result relevant to "<result>"
  Examples:
    | query     | result    |
    | Dalhousie | Dalhousie |
    | Kerala    | Kerala    |
    | food      | food      |
    | Pepsi     | Pepsi     |
    | Chamba    | Chamba    |
    | Football  | Football  |
    | India     | India     |