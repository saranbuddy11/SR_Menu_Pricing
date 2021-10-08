@Regression
Feature: Login

  @TCNo(numbers=36315)
  @login
  Scenario: Login Test
    When Check the header & tab text.
    Then 'Service workbench pricing' as the header and the tab should read 'Service workbench PRO pricing'
      | Home | Create Estimate | Maintain Estimates | Administration | Help & Support |
    When Attempt to login to MP using a Dealer and User ID that doesn’t exist.
    Then User is shown message: "Please supply a valid combination of dealer code, user name, password and market to proceed.","NO ENTRY"
    When Attempt to login to MP using a valid Dealer ID with a User that doesn’t exist.
    Then User is shown message: "Please supply a valid combination of dealer code, user name, password and market to proceed.","NO ENTRY"
    When Attempt to login to MP using a valid Dealer & User ID but use an incorrect password.
    Then User is shown message: "Please supply a valid combination of dealer code, user name, password and market to proceed. You have 4 more attempts before your account is locked.","NO ENTRY"
    When Try and login using the same incorrect password again until there are not more attempts allowed.
    Then User is shown message: "Please supply a valid combination of dealer code, user name, password and market to proceed. You have 3 more attempts before your account is locked.","NO ENTRY"
    When Attempt to login by typing the password in a different case from what it was created in.
    Then User is shown message: "Please supply a valid combination of dealer code, user name, password and market to proceed. You have 2 more attempts before your account is locked.","NO ENTRY"
    When Login as an Admin user.
    Then Users who have logged in before are taken to the Create Estimate and Vehicle page. Admin users have full access to the admin tab functionality.
    When Login as an Salesperson user.
    Then Users who have logged in before are taken to the Create Estimate and Vehicle page. Salesperson user does not have "Administration" TAB


