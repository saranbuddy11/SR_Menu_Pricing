@JLRRegression
Feature: JLR MenuPricing Help & Support Test

  @TCNo(numbers=36267)
  @JLRHelpSupport
  Scenario: Help & Support Test
    Given Login into application "Dealer"
    When Check contact details for markets support centre "0333 999 7821"
    Then Check number of links as "1"
    And Check "https://jlrmenupricing.zendesk.com/" link is present
    Then Click logout button
    Given Login into application "Sales"
    When Check contact details for markets support centre "0333 999 7821"
    Then Check number of links as "1"
    And Check "https://jlrmenupricing.zendesk.com/" link is present
    Then Ensure able to navigate to the links visible on the Menu Pricing Help Centre "JLR Help Centre"
    Then Click logout button
    Given Login into application "Dealer"
    When Check contact details for markets support centre "0333 999 7821"
    Then Check "https://jlrmenupricing.zendesk.com/" link is present
    Then Click logout button
    Given Login into application "salesPerson_NonUK"
    When Check contact details for markets support centre "+44 (0)333 999 7821"
    Then Check number of links as "12"
    Then Click logout button
    Given Login into application "admin_NonUK"
    When Check contact details for markets support centre "+44 (0)333 999 7821"
    Then Check number of links as "12"
    And Download User Guide
    Then Click logout button


