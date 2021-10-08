@Smoke
Feature: JLR MenuPricing Smoke Test

  Background:
    Given Go to the url & verify that the login screen is displayed with all required fields.

  Scenario: Login Test
    When Enter a valid userId and correct password.
    And click login then verify that the home screen is opened
    Then Click Logout to confirm the Welcome screen is displayed on the screen.

  Scenario: Create Quote Test
    When Enter a valid userId and correct password.
    And Click login and click Create Quote Tab.
    And Enter Reg No and click search. "LF14VDD" .
    Then Verify Vehicle found and landed at Quote Tab.
    When Click expand Air Conditioning category
    And Expand Compressor & Drive category and click on Remove & Replace Compressor
    Then Verify Remove & Replace Compressor added to the quote
    When Click continue to Notes Tab.
    And Enter the Distance details "25000", "Remove & Replace Compressor".
    And Click continue.
    Then Verify Quote tab page arrived and verify the Customer details are present with Save Button enabled.
    When Click Save Button.
    Then Verify Quote is now in Status "Saved " and has been assigned a quote number.


