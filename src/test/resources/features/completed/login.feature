Feature: Login
#  Scenario: should login successfully with correct phone number and password
#    Given I am on login page
#    When I enter phone number "13800000000" and password "123"
#    And I click login button
#    Then I should log in successfully
    
  Scenario: should show error when user not registered
    Given I am on login page
    When I enter phone number "13800000000" and password "123"
    And I click login button
    Then I should see not registered error message
