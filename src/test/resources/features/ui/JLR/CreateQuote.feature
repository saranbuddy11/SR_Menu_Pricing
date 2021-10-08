@JLRRegression
Feature: JLR MenuPricing Create Quote

  @TCNo(numbers=36250)
  @JLRVehicle
  Scenario: Create Quote Vehicle Test
    When Enter a VIN "SALVA2AE2EH894156" into the VIN field and click Search.
    Then The vehicle is found: "Land Rover, L538 RR Evoque , 2014 ".The user is taken to the quote page.
    When Enter something into the VIN box that is not a valid VIN "VIN45678901234567" and Search.
    Then Warning message is displayed: "Your search did not return any results. Please review and adjust your search or use the model selector to manually select your vehicle."
    When Enter REG 'LF14VDD' into the REG field and click Search.
    Then The vehicle is found: "Land Rover, L538 RR Evoque , 2014 ".The user is taken to the quote page.
    When Enter something into the REG box that is not a valid REG 'REG1234' and click Search.
    Then Warning message is displayed: "Your search did not return any results. Please review and adjust your search or use the model selector to manually select your vehicle."
    When Enter the Name of an existing customer who has just one vehicle associated to them and click Search.
    Then The vehicle is found: "Land Rover, L538 RR Evoque".The user is taken to the quote page.
    When Vehicle: Enter something into the Customer Name box that is not valid and click Search.
    Then Warning message is displayed: "Your search did not return any results. Please review and adjust your search or use the model selector to manually select your vehicle."
    When Vehicle: Enter the Name of an existing customer who has more than one vehicle associated to them and click Search.
    Then The customer 'Joe Doe' is found and is displayed with each of their associated vehicles but the Continue button is disabled at this time.1 click on one of the vehicles activates the Continue button; double clicking one of the vehicles selects and continues the quote to the next page.
    When Customer: Enter the Address of one of the existing customers into the Address box and click Search.
    Then The customer with the entered address are displayed with any associated vehicles.
    When Customer: Enter something into the Address box that is not stored as an Address and click Search.
    Then Warning message is displayed: "Your search did not return any results. Please review and adjust your search or use the model selector to manually select your vehicle."
    When Customer: Enter the Post Code of one of the existing customers into the Post Code box and click Search.
    Then The customer with the entered post code is displayed with any associated vehicles.
    When Customer: Enter something into the Post Code box that is not stored as a Post Code and click Search.
    Then Warning message is displayed: "Your search did not return any results. Please review and adjust your search or use the model selector to manually select your vehicle."
    When Type text into all the search boxes and then click the 'Clear' button.
    Then The search boxes, manual match drop down lists, customer details and vehicle details are cleared.
    When Vehicle: Type a partial amount of text into the VIN box and click the 'Search' button.
    Then Vehicles with a partial match to the VIN are displayed with index of 2. The search results will max out at 200 and a message is shown to the user: "Search result exceeds 200. Only first 200 displayed! Please refine your search" 1 , 1
    When Vehicle: Type a partial amount of text into the Reg box and click the 'Search' button.
    Then Vehicles with a partial match to the VIN are displayed with index of 3. The search results will max out at 200 and a message is shown to the user: "Search result exceeds 200. Only first 200 displayed! Please refine your search" 2 , 1
    When Vehicle: Type a partial amount of text into the Customer Name box and click the 'Search' button.
    Then Customers and any associated vehicles with a partial match to the Address are displayed with index of 1 , 3 , 1
    When Vehicle: Type a partial amount of text into the Address box and click the 'Search' button.
    Then Customers and any associated vehicles with a partial match to the Address are displayed with index of 2 , 4 , 1
    When Vehicle: Type a partial amount of text into the Post Code box and click the 'Search' button.
    Then Customers and any associated vehicles with a partial match to the Address are displayed with index of 3 , 5 , 1
    When Vehicle: Click the 'New Quote' button after each of the following has been done: Vehicle identified with details loaded. Customer found and displayed
    Then Message is shown to user: "If you open a new quote at this stage you will lose all data of the present quote". OK clears the screen Cancel leaves the page as is.
    When Navigate to manual match by selecting a brand icon
    When Select desired manufacturer - Jaguar
    When Click Continue.
    Then The vehicle is found: "Jaguar, X760 XE , 2019 ".The user is taken to the quote page.
    When Navigate to manual match of landrover by selecting a brand icon
    When Select desired manufacturer - Land Rover
    When Click Continue.
    Then The vehicle is found: "Land Rover, L538 RR Evoque , 2018 ".The user is taken to the quote page.
    When Click Unpriced generic jobs, click to complete ensure the link works correctly. Located at the bottom of the page.
    Then User is taken to Administration> Generic Jobs. Navigate back to customer tab
    When Click Generic parts priced below retail, click to complete ensure the link works correctly Located at the bottom of the page.
    Then User is taken to Administration> Generic Parts. Navigate back to customer tab
    When Hit the Log Out button, press OK when the warning message prompts.
    Then The user is logged out of the current session and taken back to the login screen. Log back in and navigate to screen before logging out

  @TCNo(numbers=36251)
  @Quote
  Scenario: Create Quote QuoteTest
    When Start a new quote with Reg 'LF14VDD'. Continue to the Quote tab.
    Then New quote is created and the quote tab is opened.
    When Click on + link of the Servicing job in the Job Tree
    Then Tree is Expanded.
    When Click on - link of the Serving job in the Job Tree
    Then  Tree is minimized.
    When Click on the + link of the Servicing job in the Job Tree and click on Job Maintenance Service Schedules, Service Interval Schedules job
    Then The "Service Interval Schedules 16,000Mls/26,000KM/12 Months" job is added to the quote .
    When Click on the job tree "Service Interval Schedules $16,$000Mls and $26,$000KM and $12 Months job again.
    Then A message informs that 'Job "16,000Mls/26,000KM/12 Months" cannot be added twice to the same quote.'.
    When Click the Add Miscellaneous Job button.
    Then The Miscellaneous Jobs window opens. Tax rate is the Markets default
    When Click on the Add button within the Misc Job window without entering any details.
    Then A message is shown: "All Fields need to be filled!"
    When Ensure the Ad Hoc job is selected and type text into the Description box "Test job", enter cost price '$50.00' and Price Excl. Tax '$60.00', select tax rate as '20%'. Click Add.
    Then The Test Job is added to the quote and the price Incl. Tax.
      | 1 | Test job | £60.00 | £72.00 |
    When Open the Add Misc Job window and click on the Cancel button.
    Then The job window is closed and nothing is added to the quote.
    When Open the Job window and select a job from the drop down list . Click the Add button.
    Then The selected job is added to the quote.
      | 1 | Automation Job | £12.00 | £14.40 |
    When Click on the Labour button.
    Then The Miscellaneous Labour window opens.
    When Click on the Add button within the Labour window without entering any details.
    Then A message is shown: "All Fields need to be filled!"
    When Enter a DTU value '1' and a description 'SeleniumTesting1'. Click the Add button.
    Then The Misc Labour item is added to the Estimate.
      | 1 | SeleniumTesting1 | £75.00 | £90.00 |
    When Open the Add Labour window and click on the Cancel button.
    Then The job window is closed and nothing is added to the quote.
    When Click on the Part button.
    Then The Miscellaneous Parts window opens.
    When Click on the Add button within the Misc Part window without entering any details.
    Then A message is shown: 'All Fields need to be filled!'
    When Enter a DTU value and a description. Click the Add button
      | 1 | 1234 | Automation Part | 12 | 14 |
    Then The Misc Part is added to the quote.
      | 1 | 1234 Automation Part | £14.00 | £16.80 |
    When Open the Part window and select Manufacturer Parts from the drop down list.
    Then The window changes to the Manufacturer Parts search.
    When Click on the Back button.
    Then The window changes back to the Parts screen
    When Open the Part window and select Manufacturer Parts from the drop down list.
    Then The window changes to the Manufacturer Parts search.
    When Search for a Part ID '1005519'.
    Then The part is found and displayed in the list.
    When Click on the Add icon.
    Then The window changes back to the Misc part screen with the selected parts details populated.
    When Click Add button.
    Then Part is added to the jlr quote
      | 1 | STUD | £0.77 | £99.99 |
    When Open the window again, this time search for a Part description
    Then Window opens, a part description is successfully searched for.
    When Click on the Add icon of a part, ensure you select the QTY desired.
    Then The user is able select the QTY then allowed to add to the quote. Part is added to the quote
      | 1 | CLIP | £1.69 | £2.03 | £99.99 | £119.99 |
    When Add some jobs to a quote and change the customer type by selecting a new customer from the Customer Type drop down list
    Then The quotes price is changed in accordance to the customer types settings.
    When Add a job with parts and labour to a quote. Click on the Job Detail icon to open the Parts and Labour details
    Then Parts and Labour items are shown along with their prices EX VAT
#      | £10.73 | £1.91 | £18.53 | £18.17 | £6.34 | £59.00 | £112.50 | £17.70 | FILTER - OIL - ELEMENT AND SEAL | GASKET - DRAIN PLUG - OIL | FILTER - AIR | FILTER - POLLEN | New Market Oil | SCREEN WASH | Engine Oil | £129.16 | £125.40 | 16,000 miles/ 26,000 km or 12 months service |
      | £11.25 | £1.98 | £19.28 | £19.05| £6.51 | £59.00 | £112.50 | £17.70 | FILTER - OIL - ELEMENT AND SEAL | GASKET - DRAIN PLUG - OIL | FILTER - AIR | FILTER - POLLEN | New Market Oil | SCREEN WASH | Engine Oil | £129.16 | £125.40 | 16,000 miles/ 26,000 km or 12 months service |
    When Click on the ADD LABOUR button, search for a new labour code and add it to the job.
    Then The new jlr labour code is added to the job, showing the price EX VAT
      | 1 | Service Interval Schedules 16,000Mls/26,000KM/12 Months | £239.93 | £287.92 | £201.02 | £241.22 |
    When Add some jobs to a quote and click on the Deal Price icon.
    Then Set Deal Price window opens.
    When Click on the Cancel button
    Then Deal price window closes with no change to the jlr quote price.
    When Add some jobs to a quote and click on the Deal Price icon.
    Then Set Deal Price window opens.
    When Change the description
    Then Description can be changed.
    When Enter a discount percentage
    Then Field accepts numbers.
    When Click OK.
    Then The price is accepted and reflected on the jlr quote "£125.40","£173.84"
    When Add some jobs to a quote and click on the Deal Price icon.
    Then Set Deal Price window opens.
    When Change the description
    Then Description can be changed.
    When Enter a discount percentage to Deal Price Discount '1'
    Then Field accepts numbers.
    When Click OK.
    Then The price is accepted and reflected on the jlr quote "£125.40","£173.84"
    When Add some jobs to a quote and click on the Deal Price icon.
    Then Set Deal Price window opens.
    When Change the description
    Then Description can be changed.
    When Enter a discount percentage to Deal Price Discount '1'
    Then Field accepts numbers.
    When Click OK.
    Then The price is accepted and reflected on the jlr quote "£125.40","£129.16"
    Then The "Service Interval Schedules 16,000Mls/26,000KM/12 Months" job is added to the quote .
    When Open the Deal Price window and click OK without entering any prices.
    Then jlr User is warned that a 'Deal Price must be lower than Quote Price'.
    When Open the Job Detail window
    Then The job detail window loads.
    When Hit the Support button.
    Then The support window loads
    When Select a part and labour item, and insert some data in the text field.
    Then Tick appears in box once selected, and the text field allows text entry.
    When Hit Ok to close the window.
    Then Window is dismissed.
    When Open the Job Detail window
    Then The job detail window loads.
    When Hit the Support button.
    Then The support window loads
    When Hit the Send button
    Then Error message displayed: "Please select at least one Part or Labour to send enquiry.".
    When Hit Ok to close the window.
    Then The "Service Interval Schedules 16,000Mls/26,000KM/12 Months" job is added to the quote .
    When Click the continue button.
    When Click the continue button.
    When On HISTORIC QUOTES Quote tab, a Checksheet icon should be visible
    Then Checksheet icon is visible
    Then The "Service Interval Schedules 16,000Mls/26,000KM/12 Months" job is added to the quote .
    When Delete all jobs from the quote
    When Hit Lost Sale and then hit OK.
    Then Warning box occurs "Can not proceed. The current quote is empty."
    Then The "Service Interval Schedules 16,000Mls/26,000KM/12 Months" job is added to the quote .
    When Hit Lost Sale
    Then Lost sale window is opened.
    When Fill out the lost sales record and ensure that expected values are available in drop down box
      | Pricing | AutoTest | 44 |
    Then Drop down Reason should contain
      | Pricing | Parts Availability | Service Availability |
    When hit Add.
    Then pop up form is closed
    Then The "Service Interval Schedules 16,000Mls/26,000KM/12 Months" job is added to the quote .
    When Select the Deferred button.
    Then Deferred window is opened.
    When Using the calender icon, select a date for the deferred quote.
    When Hit Save.
    Then The deferred date is saved and the window is closed.
    Then The "Service Interval Schedules 16,000Mls/26,000KM/12 Months" job is added to the quote .
    When Delete all jobs from the quote
    When Select the Deferred button.
    Then Warning box occurs "Can not proceed. The current quote is empty."
    When Click Unpriced generic jobs, click to complete ensure the link works correctly
    Then User is taken to Administration > Generic Jobs.
    When Click Generic parts priced below retail, click to complete ensure the link works correctly
    Then User is taken to Administation > Generic parts.
    When Add some jobs to a quote and click on the New Quote button.
    Then Message is shown to user: "If you open a new quote at this stage you will lose all data of the present quote" .OK returns the screen to the first stage of jlr Create Quote and Cancel leaves the page as is.
    When Hit the Log Out button, press OK when the warning message prompts
    Then The user is logged out of the current session and taken back to the login screen
    When Click the continue button.

  @TCNo(numbers=36251)
  @JLRNotes
  Scenario: Create Quote Notes Test
    When Create a quote for a vehicle with a VIN & Reg. Move to the Notes page.
    Then User is taken to the notes tab.
    Then The vehicles VIN 'SALVA2AE2EH894156' are shown in the corresponding boxes.
    When Edit the Quote valid until date.
    Then Date changed.
    When Attempt to type 'SeleniumTesting@#' into the Distance box.
    Then Text input should be disabled.
    When Attempt to type more than six digits into the Distance box.
    Then six digits is the limit for this field.
    When Enter a reasonable figure into the Distance box.
    Then The field accepts the reasonable figure.
    When Enter 'SeleniumTesting' into the Notes box and click Continue.
    Then Notes created with 'SeleniumTesting' text. Quote continued to Quote tab.
    When Navigate to manual match by selecting a brand icon.
    When Select desired manufacturer - Jaguar.
    When Click Continue jaguar
    When Edit the Quote valid until date.
    Then Date changed.
    When Enter 'SeleniumTesting' into the Notes box and click Continue.
    Then Notes created with 'SeleniumTesting' text. Quote continued to Quote tab.
    When Navigate to manual match of landrover by selecting a brand icon.
    When Select desired manufacturer - Land Rover.
    When Click Continue land rover
    Then The vehicle is found: "Land Rover, L538 RR Evoque , 2018 ".The user is taken to the quote page
    Then User is taken to the notes tab.
    When Edit the Quote valid until date.
    Then Date changed.
    When Enter 'SeleniumTesting' into the Notes box and click Continue.
    Then Notes created with 'SeleniumTesting' text. Quote continued to Quote tab.
    When Click Unpriced generic jobs, click to complete ensure the link works correctly. Located at the bottom of the page
    Then User is taken to Administration> Generic Jobs. Navigate back to customer tab.
    When Click Generic parts priced below retail, click to complete ensure the link works correctly Located at the bottom of the page
    Then User is taken to Administration> Generic Parts. Navigate back to customer tab.

  @TCNo(numbers=36252)
  @JLRCustomer
  Scenario: Create Quote - Customer Test
    When Create a Quote using 'SALVA2AE2EH894156' vehicle that has no associated customers. Move to the customer tab.
    Then Customer page opened.
    When Enter the name of "Joe Doe" known customer and click on the Search button.
    Then Known jlr customer is found and displayed.If there is more than one customer found, the list of customers is populated.
    When If only one customer is found just click Continue button.
      | Joe Doe | Krakow | 12345 |
    Then The customer name is added to the quote. User is navigated to the Notes tab.
    When Go back to the Customer tab - Search for the customer using a partial name 'Joe' search.
    Then Customer and any others matching the partial search are found.
    When Search for the jlr customer using a partial address search.
    Then Customer and any others matching the partial search are found.
    When Search for the jlr customer using a partial postcode search.
    Then Customer and any others matching the partial search are found.
    When Click on the customer Create button.
    Then The Customer Details form is shown.
    When Hit the Log Out button.
    Then The user is logged out from the current session and redirected to the SSO login page.
    When Click jlr Unpriced generic jobs, click to complete ensure the link works correctly. Located at the bottom of the page
    Then jlr User is taken to Administration> Generic Jobs. Navigate back to customer tab.
    When Click jlr Generic parts priced below retail, click to complete ensure the link works correctly Located at the bottom of the page
    Then jlr User is taken to Administration> Generic Parts. Navigate back to customer tab.

  @TCNo(numbers=36254)
  @QuoteExport
  Scenario:Section 3.0 - Quote continued
    When Navigate to the Administration and Ex.PartAndLabour
    Then Validate "CSV" got selected in FileFormat
    Then Create a quote for Registration Number "LF14VDD"
    When User clicks on continue button
    When User clicks on Export All button
    Then Verify file is getting downloaded in "CSV" format
    When User clicks on Save button
    Then User clicks on Print button
    Then User clicks on Detailed button
    Then Verify file is getting downloaded
    When User clicks on Summary button
    Then Verify file is getting downloaded
    And User clicks on Back button and verify navigated to previous page
    When User clicks on Email button and navigated to "JLR Menu Pricing - Dialog"
    Then Verify "Summary" Quote type got displayed
    And Verify "Detailed" Quote type got displayed
    And Verify "Detailed #2" Quote type got displayed
    And Verify send and cancel button got displayed
    And Verify warning message after a copy of quote sent to customer