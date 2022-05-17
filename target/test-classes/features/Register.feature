@Register
Feature: Registration Features

  @SCE-01
  Scenario: PARA Bank Registration
    Given I navigate to para bank app homepage
    Then I fill the registration form

  @SCE-02
  Scenario Outline: PARA Bank Registration using Excel FILLO
    Given I navigate to para bank app homepage
    Then I fill the registration form using "<TestCaseNO>"

    Examples: 
      | TestCaseNO |
      | TC001      |

  @SCE-03
  Scenario Outline: PARA Bank Registration using Excel Apache POI
    Given I navigate to para bank app homepage
    Then I fill the registration form using excel poi "<RegistrationData>"

    Examples: 
      | RegistrationData |
      | UserData_TC001   |
