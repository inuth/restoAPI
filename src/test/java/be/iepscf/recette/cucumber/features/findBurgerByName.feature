Feature: find burger by name
  I want to find a burger by his name



  Scenario: find burger by his entire name
    Given the burger called "gigaburgera" exists
    When I search it with "gigaburgera"
    Then I get the burger called "gigaburgera"

  Scenario: find burger with a part of his name
    Given the burger called "gigaburgere" exists
    When I search it with "giga"
    Then I don't get the burger