@tag3
Feature: Belly
  @tag1 
  Scenario: a few cukes
    Given I have 42 cukes in my belly
    When I wait 1 hour
    Then my belly should growl
  @tag2
  Scenario: a few cukes 2
    Given step1
