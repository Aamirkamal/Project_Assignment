Feature: Validate the all internal links present on the here documentation page feature.

@Tag1
Scenario: Verifying Here Documentation Page loaded Test Scenario

Given Launch the browser
When Navigate to here documentation Page
Then verify page loaded sucessfully

@Tag1
Scenario: Here Documentation Page all internal links validation and verify AngularJS initialisation Test Scenario

Given Launch the browser
When Navigate to here documentation Page
Then Count and validate the number of links present with Angular on Developer Page