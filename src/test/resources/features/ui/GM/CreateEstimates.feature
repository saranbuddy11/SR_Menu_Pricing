@Regression
Feature: GM MenuPricing Create Estimate Test

  @Bug
  @TCNo(numbers=36316)
  @Vehicle
  Scenario: Create Estimates - Vehicle Test
    When Enter VIN '1G1ZA5ST1HF190045' into the VIN field and click Search.
    Then The vehicle is found with 'Chevrolet, Malibu, 2017 ' characteristics displayed.
#    When Enter VIN '1G1ZA5ST1HF190045' into the VIN field and press the enter key
#    Then The vehicle is found with its characteristics displayed. 'Chevrolet, Malibu, 2017 '
    When Enter something into the VIN box that is not a valid VIN an click Search 'VIN45678901234567'
    Then User is shown message: "No vehicles found. Please verify VIN or manually select the vehicle below." The manual match drop down lists are now available.
    When Enter something into the Lic No '#!@#' box  [i.e. non alphanumeric characters] that is not a valid  License Number.
    Then Does not accept the invalid License Number. It is impossible to put to the LIC no box.
    When Enter something into the Engine No.box '#!@#'
    Then Does not accept an invalid engine number. It is impossible to put to the Engine No. box
    When Enter something into the Customer Name box that is not valid 'SeleniumTesting' and click Search.
    Then User is shown message: "No vehicles found. Please verify VIN or manually select the vehicle below." The manual match drop down lists are now available.
    When Enter the Name of an existing customer 'Joe Doe' and click Search.
    Then The customer is found and is displayed with each of their associated vehicles but the Continue button is disabled at this time.
    Then One click on one of the vehicles activates the Continue button. double clicking one of the vehicles selects and continues the quote to the next page.
    Then For only one vehicle associated, The customer 'Joe Doe' and their vehicle is found and the Create Estimate page is automatically loaded.
#    When Enter the Address of one of the existing customers into the Address box and click Search. [UAT address: ADD]
#    Then The customer(s) with the entered address are displayed with any associated vehicles.
    When Enter 'testing' into the Address box that is not stored as an Address and click Search.
    Then User is shown message: "No vehicles found. Please verify VIN or manually select the vehicle below." The manual match drop down lists are now available.
#    When Enter the zip Code of one of the existing customers into the zip Code box and click Search.
#    Then The customer(s) with the entered post code is displayed with any associated vehicles.
    When Enter 'testing1' into the zip Code box that is not stored as a zip Code and click Search.
    Then User is shown message: "No vehicles found. Please verify VIN or manually select the vehicle below." The manual match drop down lists are now available.
    When Type text into all the search boxes and then click the Clear button.
      | 1234567890 | 12345 | 1122 | Joe Doe | krakow | 1234 |
    Then The search boxes manual match drop down lists customer details vehicle details are cleared.
    When Type a partial amount of text into the VIN box '1G1Z' and click the Search button.
    Then Vehicles with a partial match to the VIN are displayed. The search results will max out at $200 and a message is shown to the user: "Search result exceeds 200. Only first 200 displayed! Please refine your search".
    When Type a partial amount of text into the Name box 'Joe' and click the Search button.
    Then Customers (and any associated vehicles) with a partial match to the Name 'Joe Doe' are displayed.
#    When Type a partial amount of text into the Address box ''and click the Search' button.
#    Then Customers (and any associated vehicles) with a partial match to the Address are displayed.
#    When Type a partial amount of text into the Post Code box and click the Search button.
#    Then Customers (and any associated vehicles) with a partial match to the Post Code are displayed.
    When Click the New Estimate button after each of the following has been done Vehicle identified with details loaded Customer found and displayed.
    Then Message is shown to user: 'If you open a new estimate, you will lose all data of the present estimate!' OK clears the screen Cancel leaves the page as is.
    When Navigate to manual match by clicking SEARCH without any fields filled.
    Then Manual Match is displayed.
    When Select desired manufacturer - field Sales Make.
    Then Manufacturer selected.
    When Select attributes from the drop down lists until a complete set  of details is ready.
    Then Dropdown populates with correct detail.
    When Click on Continue.
    Then Upon hitting continue user is taken to Create Quote screen.
    When Start NEW ESTIMATE - Click the Search button with no details entered.
    Then Manual match drop down lists appear
    When Select desired manufacturer - field Sales Make.
    When Select half of the attributes from the drop down lists.
    Then Warning shown: 'Warning : Incomplete vehicle details may result in duplicate menus in the job selection screen.  Please complete as many details as possible to improve the accuracy of the menu selection process.'
    When Click Unpriced Common Custom Jobs, click to complete ensure the link works correctly (Located at the bottom of the page, may need to be setup).
    Then User is taken to Administration > Common Jobs.
#    When Hit the 'Log Out' button, press 'Yes' when the warning message prompts.

  @TCNo(numbers=36317)
  @Estimate
  Scenario: Create Estimates - Estimate Test
    When Start a new quote with VIN '1G1ZA5ST1HF190045'. SEARCH button continue to the Estimate tab.
    When Click on the + link of the Servicing job in the Job Tree.
    Then The Tree is Expanded.
    When Click on the - link of the Serving job in the Job Tree.
    Then The tree is minimized.
    When Click on the plus link of the Scheduled Maintenance job in the Job Tree and click on Job Mileage Normal and Labor Only $15000 miles and $24000km
    Then The 'Mileage Normal Labor Only 15,000 miles / 24 000km' job is added to the Estimate.
    When Click on the job tree Mileage Normal Labor Only $15000 miles and $24000km job again.
    Then Message is shown to user:'Job "Labor Only 15,000 miles / 24 000km" cannot be added twice to the same estimate.'
    When Click the Add Miscellaneous Job button.
    Then The Miscellaneous Jobs window opens.Tax rate is the Markets default '0%' for US
    When Click on the Add button within the Misc Job window without entering any details.
    Then A message is shown: "All Fields need to be filled!"
    When Ensure the Ad Hoc job is selected and type text into the Description box "Test job", enter cost price "$50.00" and Price Excl. Tax "$60.00", select tax rate as '0%'. Click Add.
    Then The 'Test job' is added to the quote and the price Incl. Tax is '$60.00'. Quantity is '1'
    When Open the Add Misc Job window and click on the Cancel button.
    Then The window is closed and nothing is added to the quote.
    When Open the Job window and select a job from the drop down list (there must be custom jobs set up in Admin). Click the Add button.
    Then The selected job is added to the Estimate.
      | 1 | data | $20.00 |
    When Click on the Labor button.
    Then The Miscellaneous Labour window opens.
    When Click on the Add button within the Labour window without entering any details.
    Then A message is shown: "All Fields need to be filled!"
    When Enter a DTU value '1' and a description 'SeleniumTesting1'. Click the Add button.
    Then The Misc Labour item is added to the Estimate.
      | 1 | SeleniumTesting1 | $45.00 |
    When Open the Add Labour window and click on the Cancel button.
    Then The window is closed and nothing is added to the quote.
    When Click on the Part button.
    Then The Miscellaneous Parts window opens.
    When Click on the Add button within the Misc Part window without entering any details.
    Then A message is shown: "All Fields need to be filled!"
    When Ensure the Ad Hoc part is selected, enter the desired Quantity, type a Part number, Description, cost and enter the Price Excl. Tax, Click the Add button.
      | 2 | 13579 | AdhocPartTest1 | 4 | 6 |
    Then The Misc Part is added to the quote.
      | 2 | 13579 AdhocPartTest1 | $12.00 |
    When Open the Part window and select Manufacturer Parts from the drop down list.
    Then The window changes to the Manufacturer Parts search.
    When Click on the Back button.
    Then The window changes back to the Parts screen
    When Open the Part window and select Manufacturer Parts from the drop down list.
    Then The window changes to the Manufacturer Parts search.
    When Search for a Part ID '10390370'.
    Then The part is found and displayed in the list.
    When Click on the Add icon.
    Then The window changes back to the Misc part screen with the selected parts details populated.
    When Click Add button.
    Then Part is added to the quote.
      | 1 | DISC-NAVN DATA | $419.30 |
    When Open the window again, this time search for a Part description."DISC-NAVN DATA"
    Then Window opens, a part description is successfully searched for.
    When Click on the Add icon of a part. Update quantity to '2' and click Add button
    Then The user is able select and update the QTY then allowed to add to the estimate. Part is added to the estimate. Quantity = $2 is visible for this part.
      | 2 | DISC-NAVN DATA | $1,568.28 |
    When Create Estimate and Add some jobs to a Estimate
    Then Estimate is created with jobs.
      | 1 | Cabin Filter Remove & Replace | $42.54 |
    When Change the customer type by selecting a new customer from the Customer Type drop down list
    Then The quotes price is changed in accordance to the customer types settings."$2,187.30"
    When Add a job with parts and labour to a estimate. Click on the Magnifying Glass icon to open the Parts and Labour details.
    Then Parts and Labour items are shown along with their price EX VAT.
      | GM Genuine Parts 23334607 Rear Coil Spring | GM Genuine Parts 11546407 Bolt | GM Genuine Parts 11610887 Multi-Purpose Bolt               |
      | $143.04                                    | $7.96                          | $10.50                                                     |
      | Rear Coil Spring Replacement - Both Sides  | $63.00                         | ACDelco 560-1064 GM Original Equipment Rear Shock Absorber |
      | SPRING                                     | BOLT                           |                                                            |
    When Click on the ADD LABOR button, search for a new labour code '1414390' Specify labor Time to '22' mins and add it to the job by clicking Add icon.
    Then The new labour code is added to the job, showing the price EX VAT.
      | 1414390 | 0.4 | Rear Compartment Lid Strut Replacement | $18.00 |
    When Click the CONTINUE button.
    Then The jobs total price is re-calculated with the new labour time
    When Click on the Delete icon next to a job in a estimate.
    Then The job is removed from the estimate and the estimate price is adjusted correctly.
    When Add some jobs to a estimate and click on the Deal Price icon.
      | 1 | Cabin Filter Remove & Replace | $42.54 |
    Then Set Deal Price window opens.
    When Click on the Cancel button
    Then Deal price window closes with no change to the quote price.
    When Add some jobs to a estimate and click on the Deal Price icon.
      | 1 | Cabin Filter Remove & Replace | $42.54 |
    Then Set Deal Price window opens.
    When Change the description 'SeleniumTesting1'
    Then Description can be changed.
    When Enter a discount percentage to Deal Price Discount '1'
    Then Field accepts numbers.
    When Click OK.
    Then The price is accepted and reflected on the quote
      | 1 | SeleniumTesting1 | ($67.54) |
    When Add some jobs to a estimate and click on the Deal Price icon.
      | 1 | Cabin Filter Remove & Replace | $42.54 |
    Then Set Deal Price window opens.
    When Change the description 'SeleniumTesting2'
    Then Description can be changed.
    When Enter a Deal Price for the discount.
    Then Field accepts numbers.
    When Click OK.
    Then The price is accepted and reflected on the quote
      | 1 | SeleniumTesting2 | ($6.85) |
    When Open the Deal Price window and click OK without entering any prices.
    Then User is warned that a 'Deal Price is required.'.
    When Add some jobs to a quote and click on the New Estimate button.
      | 1 | Cabin Filter Remove & Replace | $42.54 |
    Then Message is shown to user: 'If you open a new estimate, you will lose all data of the present estimate!'. OK returns the screen to the first stage of Create Quote and Cancel leaves the page as is.
    When Click the continue button.
    Then User is taken to the Notes tab.Exception: If there is no Customer assigned to the VIN then user is taken to the Customer tab.

  @Bug
  @TCNo(numbers=36324)
  @Customer
  Scenario: Create Estimates - Customer Test
    When Create a estimate using '1G1105S30HU111864' vehicle that has no associated customers. Move to the customer tab.
    Then Customer page opened.
    When Enter the name of "Joe Doe" known customer and click on the Search button.
    Then Known customer is found and displayed.If there is more than one customer found, the list of customers is populated.
    When If only one customer is found just click Continue button.
      | Joe Doe | Krakow | 12345 |
    Then The customer name is added to the quote. User is navigated to the Notes tab.
    When Go back to the Customer tab - Search for the customer using a partial name 'Joe' search.
    Then Customer and any others matching the partial search are found.
    When Search for the customer using a partial address search.
    Then Customer and any others matching the partial search are found.
    When Search for the customer using a partial postcode search.
    When Click on the Create button.
    Then The Customer Details form is shown.
#    When Hit the Log Out button. // @Bug(ticket = "AD 34863", environment = Environment.QC)
#    Then The user is logged out from the current session and redirected to the SSO login page. //@Bug(ticket = "AD 35055", environment = Environment.QC)

  @TCNo(numbers=36319)
  @Notes
  Scenario: Create Estimates - Notes Test
    When Create Estimate for using '1G1105S30HU111864' vehicle with a VIN. Move to the Notes page.
    Then The vehicles VIN '1G1105S30HU111864' are shown in the corresponding boxes.
    When Edit the Estimate valid until date.
    Then Date changed.
    When Enter 'SeleniumTesting' into the Notes box and click Continue.
    Then Notes created with 'SeleniumTesting' text. Estimate continued to Estimate tab.
    When Create Estimate for a manually matched vehicle. Move to the Notes page.
    Then LIC, VIN and Distance boxes are empty.
    When Enter a LIC 'KGR8E08', VIN '12345678901234567' and distance '11000'.
    Then LIC 'KGR8E08' and VIN '12345678901234567' can be manually entered.
    When Click on the Continue button.
    Then LIC 'KGR8E08 ', VIN '12345678901234567 ' are now displayed in Your Selection at top of page. Estimate continued to Estimate tab.
    When Attempt to type 'SeleniumTesting' into the Distance box.
    Then Text input should be disabled.
    When Once all fields are completed click the continue button.
    Then The user is taken back to the Estimate tab.



