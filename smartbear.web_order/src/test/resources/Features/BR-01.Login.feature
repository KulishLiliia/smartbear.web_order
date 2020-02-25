@wip @br01 @regression @smoke @integration 
Feature: Login 


@login @regression @smoke
  Scenario: User login validation
    When User enters Username and Password
    And User clicks on Login button
    Then User is on Web Orders page
@login 
  Scenario Outline: User login validation with invalid credentials
    When User enters "<username>" user name and "<password>" password
    And User clicks on Login button
    Then User should see error message "<error message>"

    Examples: invalid credentials
      | username | password | error message              |
      | invalid  | test     | Invalid Login or Password. |
      | Tester   | invalid  | Invalid Login or Password. |
      | invalid  | invalid  | Invalid Login or Password. |
      |          |test      | Invalid Login or Password. |
      |Tester    |          | Invalid Login or Password. |
      |          |          | Invalid Login or Password. |
