@Smoke
Feature: OPEL MenuPricing Smoke Test

  Background:
    Given Go to the url & verify that the login screen is displayed with all required fields .

  Scenario: Login Test
    When Enter a valid userId and correct password .
    And Click login then verify that the home screen is opened .
    Then Click Logout to confirm the Welcome screen is displayed .

  @OpelQuote
  Scenario: Create Quote Test
    When Enter a valid userId and correct password .
    And Click login and click Create Quote Tab .
    And Enter Reg No and click search. "DK14NSO".
    Then Verify Vehicle found and landed at Quote Tab .
    When Click expand Servicing category
    And Expand Mileage Servicing category and click on twenty thousand Mls
    And Pop up window appears Select menu to be added to the quote with list of available jobs.
    Then Verify Mileage Servicing added to the quote
    When Click on Job Check-sheet icon
    Then Verify User is given the option to open or save the Check-sheet
#    And Click open to view the Job Check-sheet
#    Then Verify Check-sheet pdf opens and contains multiple Operations
    When Close the PDF file and click continue to Notes Tab
    And Enter the Distance details, Service Card Number and Notes. "25000", "245", "MILEAGE_SERVICING"
    And Click continue .
    Then Verify Quote tab page arrived and verify the Customer details are present with Save Button enabled. "ABCDE ", "XYZ ", "1234 " .
    When Click Save Button .
    Then Verify Quote is now in Status "Saved " and has been assigned a quote numbers