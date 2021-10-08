@JLRRegression
Feature: JLR MenuPricing Create Quote

  @TCNo(numbers=36260)
  @Jobs
  Scenario: Administration - Generic Jobs Test
    When Open the Admin Generic Jobs tab.
    When Add a new custom job by entering the details into the fields
      | Selenium Testing Job 1 | 10.00 | 15.00 | 20% |
    When Click Save to add the job.
    Then Common job is added "Selenium Testing Job 1" to the Dealer Custom Jobs list.
    When Click on the Edit icon of Generic Job 'AdBlue Refill - AdBlue Refill'
    Then Generic job details loaded into edit fields.
    When Edit the Cost and Retail prices as '10.00' and '20.00'. Click Save.
    Then Prices as '£10.00' and '£20.00' are updated for 'AdBlue Refill - AdBlue Refill'.
    When Click on the Edit icon of Generic Job 'Selenium Testing Job 1'
    Then Generic job details loaded into edit fields.
    When Edit the description as 'Selenium Testing Job 1x' and Cost and Retail prices as '11.99' and '16.99'. Click Save.
    Then Description "Selenium Testing Job 1x" and Prices as '£11.99' and '£16.99' are updated.
    When Click on the Delete icon of Custom job Test Job $1 and when prompted to confirm "Do you really want to delete the selected item?" choose Cancel.
    Then Custom job "Selenium Testing Job 1x" is not deleted.
    When Click on the Delete icon again "Do you really want to delete the selected item?" and choose OK when prompted.
    Then Custom job "Selenium Testing Job 1x" is removed from the list.
    When Try and add a job without one of the edit boxes filled in.
    Then Message informs "All Fields need to be filled!".
    When Edit some Generic Jobs so that they have no price. Click on the Unpriced Common Custom Jobs hyperlink.
    Then A hyperlink to the Generic Jobs page is visible. User is taken to the Generic Jobs page.

  @TCNo(numbers=36260)
  @Parts
  Scenario: Administration - Generic Parts Test
    When Open the ADMINISTRATION Generic Parts tab.
    When Select part "LR SCREEN_WASH 500ML" from the 1st drop down list.
    When Add a new Local part by entering the details into the fields: Container Size, Description, Part No, Cost Excl. Tax, Retail Excl. Tax, Tax Band.
      | 1 | Test part 1 | 1234567 | £4.00 | £6.00 | 20% |
    When Click the Save button.
    Then Local part is added with correct data.
      | 1 | Test part 1 | 1234567 | £4.00 | £6.00 |
    When Click on the Edit icon of the new Local Part.
    Then Local part details populated into edit boxes.
    When Edit the description as "Test Part 11" and click Save.
    Then Part description is changed
      | 1 | Test Part 11 | 1234567 | £4.00 | £6.00 |
    When Click on the Delete icon of the Local part Test Part $11.
    Then Local part 'Test Part 11' is deleted from the list.

  @TCNo(numbers=36258)
  @OrgDetail
  Scenario: Administration -Org. Detail
    When Amend the jlr user name 'SeleniumTesting'.
    Then Name is changed 'SeleniumTesting'
    When Amend the contact name 'QA'
    Then Contact name is changed 'QA'.
    When Amend the address 'SeleniumTestingAddr'
    Then Address is changed 'SeleniumTestingAddr'
    When Amend the zip code 'A1234'.
    Then Postal code is changed 'A1234'
    When Amend the telephone number '12356789'
    Then Telephone number is changed '12356789'
    When Amend the email address 'Testingemail@oeconnection.com'
    Then E-Mail address is changed 'Testingemail@oeconnection.com'.

  @TCNo(numbers=36329)
  @StockUpload
  Scenario: Administration - Stock Upload
    When Upload a jlr 'InvalidCSV.jpg' non .CSV file
    Then Error message displayed "The uploaded file is invalid. It must exist and must be .csv file format.".
    When Download the stock upload example
    Then 'Stock-Upload-Example.csv' Downloads successfully
    When Upload the jlr stock upload example
    Then Stock Uploads successfully
    When Hit the Choose file button
    Then The stock uploaded file viewer loads
    When Hit Cancel when the window pops up.
    Then The stock upload file viewer closes.
    And close browser

  @TCNo(numbers=36265)
  @JLRSupport
  Scenario: Administration - Support Enquiry
    When The Date Before field can be amended
      | May, 2021 | May | 2021 |
    Then Field amendable '18/05/2021'
    When Hit Search
    Then Ensure results are correct.
    When Continue to Export part & labour tab.
    Then User is taken to the export part and labour tab.

  @TCNo(numbers=36259)
  @JLRTypes
  Scenario: Administration Customer Types Test
    When Navigate to Administration - JLR Customer Types tab
    Then The Administration - Customer Types tab is accessible
    When Enter a new description "SeleniumTesting" with Parts & Retail labor Rate details.
    Then Is possible to put values to fields.
    When Click on the Save button.
    Then The customer type is saved.
    When Click on the Delete icon next to one of the Types.
    Then The customer type is permanently deleted.
    When Enter "SeleniumTesting1" description only and click Save.
    Then Message appears: "When saving, a changed row must not contain any blank fields."
    When Create 'SeleniumTesting2' new customer type Based On Retail minus and enter the Adjust values as 101%.
    Then Message is shown to user stating that: "Invalid Values entered. Retail Minus must be less than 101%, cost plus must not be less than -100%, and None must be 0%."
    When Create 'SeleniumTesting3' new customer type Based On None and should be impossible to put Adjust % Parts it is set $0% as default
    Then Message is shown to user stating that: "Invalid Values entered. Retail Minus must be less than 101%, cost plus must not be less than -100%, and None must be 0%."
    When Create 'SeleniumTesting4' new customer type Based On Cost Plus and enter the Adjust values as -101%.
    Then Message is shown to user stating that: "Invalid Values entered. Retail Minus must be less than 101%, cost plus must not be less than -100%, and None must be 0%."

  @TCNo(numbers=36259)
  @Lost
  Scenario: Administration Lost Sales Test
    When Ensure Date from field can be amended "14/05/2021".
    Then Date Field amendable '14/05/2021',1
    When Ensure Date to can be amended "14/06/2021".
    Then Date Field amendable '14/06/2021',2
    When Dropdown the Reason menu
      | All | Pricing | Parts Availability | Service Availability |
    When Select Pricing, Parts Availability & Service Availability.
    Then Each reason can be selected.
    When Hit the Search button.
    Then Results depended on what has been searched will be displayed.
    When Hit the Export button.
    When Open the Stock upload tab.
    Then User is taken to the stock upload tab.

  @Export
  Scenario: Administration - Export PartAndLabour
    When Navigate to the Administration Export PartAndLabour
    When Ensure all radio buttons are clickable and once clicked upon they fill correctly.
    Then All radio buttons are clickable and fill once clicked.
    When Dropdown the BlankText menu.
    Then Items are displayed. "blankText"
      | default | -- | # |
    When Ensure your able to select an item from the dropdown."blankText"
    Then Item is selectable."blankText"
    When Dropdown the separator menu.
    Then Items are displayed. "separator"
      | default | \t | , | ; |
    When Ensure your able to select an item from the dropdown."separator"
    Then Item is selectable."separator"
    When Ensure content is transferable from the available columns to the Selected columns using the provided arrows.
    Then Once content is selected it is transferred successfully to and from using the provided arrow buttons.
    When Hit the Save Changes button
    Then Settings are saved.
    When Create a new quote, add a job. Open the job details and click on the Export button.
    Then Export file is produced with the selected options. "Service Schedules Check & Inspect Carry Out Quality Check - With Road Test (During Service)"


  @user
  Scenario: Administration - User Maintenance
    When Click through each of the tabs Cust.Types, Generic Jobs, etc to ensure each tab is accessible.
    Then All tabs are accessible.
    When Log in as an Admin user and open the Administration page. Create a new user
    When Enter new password as 'test' and save.
    Then Error message is shown: "The password must be between 8 and 20 characters long, must have at least one upper case alphabetical character, must have at least one lower case alphabetical character, must have at least one numeric character, must not match Retailer ID and/or User ID, and may not contain spaces or punctuation marks."
    When Enter new password as 'te$T1234' and save.
    Then Error message is shown: "Please enter a password without leading or trailing whitespaces or special characters."
    When Enter new password as 'TestTest#' and save.
    Then Error message is shown: "Please enter a password without leading or trailing whitespaces or special characters."
    When Enter new password as 'TEST' and save.
    Then Error message is shown: "The password must be between 8 and 20 characters long, must have at least one upper case alphabetical character, must have at least one lower case alphabetical character, must have at least one numeric character, must not match Retailer ID and/or User ID, and may not contain spaces or punctuation marks."
    When Enter new password as 'seleniumtestingMenupricing' and save.
    Then Error message is shown: "The password must be between 8 and 20 characters long, must have at least one upper case alphabetical character, must have at least one lower case alphabetical character, must have at least one numeric character, must not match Retailer ID and/or User ID, and may not contain spaces or punctuation marks."
    When Enter new password as 'tesT1234' and save.
    Then Error message is shown: "Passwords may not be reused. Please enter a password that has not been used before."
    When Update a users password "tesT1234" but enter a different password "tesT2345" in the confirmation field.
    Then Update not successful, warning message "Please supply a password where the Assign & Confirm details match."
    When Select an Enabled user and click the 'Disable' button.
    Then The users status is changed from Enabled to 'Deactivated'. Confirm this by attempting login "This MP2 account is disabled. You have to enable this account before you can login with it.".
    When Select a Disabled user and click the 'Reactivate' button.
    Then The user status is changed from Disabled to 'Enabled'. Confirm this by attempting login.
    When Click the Org. Detail tab.
    Then Taken to the org detail tab.

  @TCNo(numbers=36262)
  @SystemSettingsJLR
  Scenario: Administration - System Settings
    When Navigate to Administration - System Settings
    When Edit the Cost and Retail prices as '45.00' and '50.00' and click labourcostRetail as default checkbox . Click Save.
    When Create a new quote with Reg 'LF14VDD'. Continue to the Quote tab.
    Then New quote is created and the quote tab is opened.
    When Click on + link of the Servicing job in the Job Tree
    Then Tree is Expanded.
    When Click on - link of the Serving job in the Job Tree
    Then  Tree is minimized.
    When Click on the + link of the Servicing job in the Job Tree and click on Job Maintenance Service Schedules, Service Interval Schedules job
    Then The "Service Interval Schedules 16,000Mls/26,000KM/12 Months" job is added to the quote .
    And Click Job Details window and validate the "Job Drilldown - JLR Menu Pricing" window opened and check Labour price "£75.00".
    When click Administration tab
    Then Edit the Cost and Retail prices as '45.00' and '100.00' and click labourcostRetail as default checkbox . Click Save.
    When click on CreateQuote tab
    Then verify that warning message "Attention: The quoted price has changed!! This may be the result of changed admin settings" displayed
    When click Warning Ok button
    Then Click Job Details window and validate the "Job Drilldown - JLR Menu Pricing" window opened and check Labour price "£150.00".
    When click Administration tab
    Then Edit the Cost and Retail prices as '75.00' and '100.00' and click labourcostRetail as default checkbox . Click Save.
    When click on CreateQuote tab
    When click on Labour in Add miscellaneous Items
    Then Navigate to "Additional Misc Item" and Verify correct priceExcel.VAT "75.00" and Cost "100.00" displayed
    When click Administration tab
    Then Edit the Cost and Retail prices as '75.00' and '120.00' and click labourcostRetail as default checkbox . Click Save.
    When click on CreateQuote tab
    Then click Warning Ok button
    When click on Labour in Add miscellaneous Items
    Then Navigate to "Additional Misc Item" and Verify correct priceExcel.VAT "75.00" and Cost "120.00" displayed
    When click Administration tab
    Then set Labour Rates for Brands and Navigate to "Set Labour Rates"
    And set labour cost "40" and labour retail "50" for "Land Rover"
    And set labour cost "60" and labour retail "70" for "Jaguar"
    And click ok and Save
    When click on CreateQuote tab
    Then click Warning Ok button
    And click the Vehicle and clear existing quote
    When Create a new quote with Reg 'LF14VDD'. Continue to the Quote tab.
    Then click Warning Ok button
    When click on Labour in Add miscellaneous Items
    Then Navigate to "Additional Misc Item" and Verify correct priceExcel.VAT "40.00" and Cost "50.00" displayed
    And logout from application
    Given Login into Dealer application "Dealer"
    When Create a new quote with Reg 'EY278TZ'. Continue to the Quote tab.
    When click on Labour in Add miscellaneous Items
    Then Navigate to "Additional Misc Item" and Verify correct priceExcel.VAT "60.00" and Cost "70.00" displayed
    And logout from application
    Given Login into Dealer application "singleBranded"
    When click Administration tab
    Then set Labour Rates for Brands and Navigate to "Set Labour Rates"
    And set labour cost "50" and labour retail "60" for "Land Rover"
    And click ok and Save
    When click on CreateQuote tab
    When Create a new quote with Reg 'LF14VDD'. Continue to the Quote tab.
    When click on Labour in Add miscellaneous Items
    Then Navigate to "Additional Misc Item" and Verify correct priceExcel.VAT "50.00" and Cost "60.00" displayed
    And logout from application
    Given Login into Dealer application "Dealer"
    When click Administration tab
    Then Set number of days for Quote Expiry as "2"
    And click on create quote and click new quote button
    When Create a new quote with Reg 'LF14VDD'. Continue to the Quote tab.
    Then New quote is created and the quote tab is opened.
    When Click on + link of the Servicing job in the Job Tree
    Then Tree is Expanded.
    When Click on - link of the Serving job in the Job Tree
    Then  Tree is minimized.
    When Click on the + link of the Servicing job in the Job Tree and click on Job Maintenance Service Schedules, Service Interval Schedules job
    Then The "Service Interval Schedules 16,000Mls/26,000KM/12 Months" job is added to the quote .
    When User clicks continue button
    Then validate the quote expiry date as per number of days as "2" for Quote Expiry
    When click Administration tab
    Then set the Quote prefix as "prefix" and Quote suffix as "suffix"
    And click on create quote and click new quote button
    When Create a new quote with Reg 'LF14VDD'. Continue to the Quote tab.
    Then New quote is created and the quote tab is opened.
    When Click on + link of the Servicing job in the Job Tree
    Then Tree is Expanded.
    When Click on - link of the Serving job in the Job Tree
    Then  Tree is minimized.
    When Click on the + link of the Servicing job in the Job Tree and click on Job Maintenance Service Schedules, Service Interval Schedules job
    Then The "Service Interval Schedules 16,000Mls/26,000KM/12 Months" job is added to the quote .
    And save and print the quote and verify the quote number added with "prefix" and "suffix"
    When click Administration tab
    Then set next quote number and save the value
    And click on create quote and click new quote button
    When Create a new quote with Reg 'LF14VDD'. Continue to the Quote tab.
    Then New quote is created and the quote tab is opened.
    When Click on + link of the Servicing job in the Job Tree
    Then Tree is Expanded.
    When Click on - link of the Serving job in the Job Tree
    Then  Tree is minimized.
    When Click on the + link of the Servicing job in the Job Tree and click on Job Maintenance Service Schedules, Service Interval Schedules job
    Then The "Service Interval Schedules 16,000Mls/26,000KM/12 Months" job is added to the quote .
    And save the quote and verify the quote number correctly displayed
    When click Administration tab
    Then set Printer top margin in system settings and verify able to save the settings
    And Enter "customerNameDafault" in Default Customer Name box and save
    When Create a new quote with Reg 'ER473HK'. Continue to the Quote tab.
    Then click on continue button and verify the default customer name
    And get Address information from Org.details
    And click on create quote and click new quote button
    When Create a new quote with Reg 'LF14VDD'. Continue to the Quote tab.
    Then New quote is created and the quote tab is opened.
    When Click on + link of the Servicing job in the Job Tree
    Then Tree is Expanded.
    When Click on - link of the Serving job in the Job Tree
    Then  Tree is minimized.
    When Click on the + link of the Servicing job in the Job Tree and click on Job Maintenance Service Schedules, Service Interval Schedules job
    Then The "Service Interval Schedules 16,000Mls/26,000KM/12 Months" job is added to the quote .
    And Verify that address correctly displayed in PDF file


  @TCNo(numbers=66134)
  @SystemSettingsJLRGenericParts
  Scenario: Administration - System Settings - Prompt for Generic Parts Selection
    When Navigate to Administration - System Settings
    Then tick the prompt for Generic Parts Selection box and Save
    And click on create quote and click new quote button
    When Create a new quote with Reg 'LF14VDD'. Continue to the Quote tab.
    When Search job and select "Brake Fluid" job for new quote
    Then Navigate to "Replacement Parts" window and select fluid optional and continue
    And Navigate to "Job Drilldown - JLR Menu Pricing" verify fluid optional is displayed in job details
    When click Administration tab
    Then untick the prompt for Generic Parts Selection box and Save
    And click on create quote and click new quote button
    When Create a new quote with Reg 'LF14VDD'. Continue to the Quote tab.
    When Search job and select "Brake Fluid" job for new quote
    Then "Replacement Parts" window not displayed
    And Navigate to "Job Drilldown - JLR Menu Pricing" verify the fluid optional not added with job quote