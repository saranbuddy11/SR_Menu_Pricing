@Smoke
Feature: Hyundai MenuPricing Smoke Test

#  @HydLoginN
#  Scenario: Hyundai Login Negative Test
#    Given Go to the URL
#    When Enter hyundai invalid credentials and Click Login.
#    Then Warning message displays "Please supply a valid combination of dealer code, user name, password and market to proceed."

  @HydLogin
  Scenario: Login Test
    Given Go to the URL
    When Login as a valid Admin user.
    Then User is successfully logged in.

  @HydQuoteTest
  Scenario: Create Quote Test
    When Open Create Quote tab. Enter Reg 'FY64YBZ' and Click Search.
    And Move to the Quote tab and add Job $20000 Mile Service $2 Yearly Kit $20000 Miles_$2 Year Service $03_$2013.
    And Click on the Jobs Check_sheet icon.
    And Open the Check_sheet.
    And Click the Continue button to move to the Customer tab. Enter Customer details (if needed) and Click Continue until back on the Quote tab. "25000","testing"
    And Click Save button.
    Then Quote is now in Status 'Saved ' and has been assigned a quote number.