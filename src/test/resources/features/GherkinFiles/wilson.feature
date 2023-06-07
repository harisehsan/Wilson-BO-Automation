@wilsonAutomation
Feature: Test Automation

  @wilson_return_order_de
  Scenario: Wilson Return Order German
    Given I navigate to the wilson site
    And I let select the language german
    And I login to the wilson site
    Then I verify that all items are correctly displayed
    And I select the Retouren verwalten
    When I search the order number "0400438986"
    And I select edit button
    And I provide the details for the return "defect"
    Then I should see the return success message

  @wilson_return_order_eng
  Scenario: Wilson Return Order English
    Given I navigate to the wilson site
    And I let select the language English
    And I login to the wilson site
    And I select the Manage return
    When I search the order number "0400438986"
    And I select edit button non DE
    And I provide the details for the return for english
    Then I should see the return success message
