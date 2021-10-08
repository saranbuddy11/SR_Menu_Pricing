@Regression
Feature: GM MenuPricing Help & Support Test

  @Bug
  @TCNo(numbers=36334)
  @Support
  Scenario: Help & Support Test
    When H&S page should load in the a separate tab.
    Then The OEC H&S page loads in a separate tab, full screen with back buttons enabled.