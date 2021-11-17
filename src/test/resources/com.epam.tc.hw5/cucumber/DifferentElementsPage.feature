Feature: Different Elements

  Scenario: Different elements page test
    Given I open JDI GitHub site
    Then Test site is opened
    When I login as user "Roman Iovlev"
    Then "Roman Iovlev" is logged
    When I click on "Service" button in Header
    And I click on "Different elements" button in Service Dropdown
    Then "Different elements" page should be opened
    When I select "Water" in checkbox
    And I select "Wind" in checkbox
    Then "Water" checkbox is selected
    And "Wind" checkbox is selected
    When I click on "Selen" radio
    Then "Selen" radio is checked
    When I select "Yellow" color in dropdown
    Then "Yellow" color is selected
    Then Log rows are displayed



