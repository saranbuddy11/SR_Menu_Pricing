@JLRRegression
Feature: Login

  @TCNo(numbers=36315)
  @JLRlogin
  Scenario: Login Test
    When Check the jlr header & tab text.
    When Attempt to login to MP using a Dealer and User ID that doesn’t exist.
    Then User is shown message: "Please supply a valid combination of retailer code, user name, password and market to proceed.","jlr.support@oeconnection.com    0333 999 7821"
    When Attempt to login to MP using a valid Dealer ID with a User that doesn’t exist.
    Then User is shown message: "Please supply a valid combination of retailer code, user name, password and market to proceed.","jlr.support@oeconnection.com    0333 999 7821"
    When Attempt to login to MP using a valid Dealer & User ID but use an incorrect password.
    Then User is shown message: "Please supply a valid combination of retailer code, user name, password and market to proceed. You have 4 more attempts before your account is locked.","jlr.support@oeconnection.com    0333 999 7821"
    When Try and login using the same incorrect password again until there are not more attempts allowed.
    Then User is shown message: "Please supply a valid combination of retailer code, user name, password and market to proceed. You have 3 more attempts before your account is locked.","jlr.support@oeconnection.com    0333 999 7821"
    When Attempt to login by typing the password in a different case from what it was created in.
    Then User is shown message: "Please supply a valid combination of retailer code, user name, password and market to proceed. You have 2 more attempts before your account is locked.","jlr.support@oeconnection.com    0333 999 7821"
    When Login as an Admin user.
    Then Users who have logged in before are taken to the Create Quote and Vehicle page. Admin users have full access to the admin tab functionality.
    When Login as an Salesperson jlr user.
    Then Users who have logged in before are taken to the Create Estimate and Vehicle page. Salesperson user does not have "Administration" TAB
    When Select the market dropdown, and select Spain.
    Then The dropdown presents a list of country, once selected the market will change to that country.
    When Attempt to login using a default account.
    Then User is shown message: "Please supply a valid combination of retailer code, user name, password and market to proceed.","accjlres@jaguarlandrover.com    _"
    When Login using dealer setup for that country
    Then The user is able to successfully login using a spanish dealer "CREAR PRESUPUESTO".