Feature: Login    
#  Scenario: should show error when user not registered
#    Given I am on login page
#    When I enter phone number "13800000000" and password "123"
#    And I click login button
#    Then I should see not registered error message

  Scenario Outline: should show error when user not registered
    Given I am on login page
    When I enter phone number "<mobile>" and password "<password>"
    And I click login button
    Then I should see error message "<errorMessage>"

    Examples:
    | mobile | password | errorMessage |
    |    13812345678 |  123 | 用户号码未注册，请先注册 |
    |    12345678900 |  123 | 此服务仅限中国移动用户 |
    |                |      | 请输入11位中国移动手机号码 |

  @ignore
  Scenario: should login successfully
    Given I am on login page
    When I enter phone number "13811250299" and password "renjing123"
#    And I enter captcha "test"
    And I click login button
    Then I should on home page
