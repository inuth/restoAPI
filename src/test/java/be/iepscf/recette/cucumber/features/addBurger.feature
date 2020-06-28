Feature: add burger
  I want to add a burger

  Background: delete burger
    Given the burger called "gigaburger" doesn't exist

  Scenario: suppress MAJ in the name
    Given a burger named "GIGABURGER"
    And that cost 2.5
    When I post it
    Then the name is "gigaburger"