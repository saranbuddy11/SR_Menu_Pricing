@Smoke
Feature: GM MenuPricing Smoke Test

  Background:
    Given Go to the qc url & verify that the all required fields are displayed in login screen

  Scenario: Login Test
    When Enter a valid userId and valid password
    And  Select a  market value and Click login button
    And  verify that successfully logged in and the home screen is opened
    Then Click Logout button

  @Create
  Scenario: Create Estimate Test
    When Enter a valid userId and valid password
    And  Select a  market value and Click login button
    And  Click Create Estimate tab
    And  Enter VIN and click search. "1G1ZA5ST1HF190045"
    Then Verify Vehicle is found
    When Add Job Service Add-On Cabin Filter Remove & Replace
    Then Verify Job is added to the Estimate
    And  Click the Continue button
    And  Enter the Notes. "25000","Estimate details added"
    And  Click the Continue button
    Then Verify Estimate tab page selected and verify the Customer details are added to the estimate and Save Button enabled.
    When Click Save button
    Then Verify Estimate is now in Status "Saved " and has been assigned a estimate number
