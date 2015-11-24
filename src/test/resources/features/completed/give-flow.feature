Feature: Give Flow
  Scenario: should be able to give flow to new added friend
    Given I logged in with a new user
    And I am on give flow page
    When I add new friend with mobile "13800000002" and name "friend 1"
    And I select flow size "200"M
    And I click give button
    And I click confirm button
    Then I should see succeed message