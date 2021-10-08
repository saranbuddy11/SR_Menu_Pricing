@Regression
@Administration
Feature: GM MenuPricing Administration Test

  @TCNo(numbers=36325)
  @Common
  Scenario: Administration Common Jobs Test
    When Open the Administration_Common Jobs tab.Add a new custom job by entering the details into the fields e.g.Description: 'Selenium Testing Job 1', Cost Excl. VAT '10.00', Retail Excl. VAT '15.00', Tax Rate '0%'
    When Click Save to add the job.
    Then Common job is added "Selenium Testing Job 1" to the Dealer Custom Jobs list.
    When Click on the Edit icon of Generic Job Vehicle Cleaning - Engine Wash.
    Then Generic job details loaded into edit fields.
    When Edit the Cost and Retail prices as '10.00' and '20.00'. Click Save.
    Then Prices as '$10.00' and '$20.00' are updated for 'Vehicle Cleaning - Engine Wash'.
    When Click on the Delete icon of Custom job Test Job $1 and when prompted to confirm choose Cancel.
    Then Custom job "Selenium Testing Job 1" is not deleted.
    When Click on the Delete icon again and choose OK when prompted.
    Then Custom job "Selenium Testing Job 1" is removed from the list.
    When Try and add a job without one of the edit boxes filled in.
    Then Message informs "All Fields need to be filled!".
    When Edit some Common Jobs so that they have no price. Click on the Unpriced Common Custom Jobs hyperlink.
    Then A hyperlink to the Common Jobs page is visible. User is taken to the Generic Jobs page.

  @TCNo(numbers=36324)
  @Types
  Scenario: Administration Customer Types Test
    When Navigate to Administration - Customer Types tab
    Then The Administration - Customer Types tab is accessible
    When Enter a new description "SeleniumTesting" with Parts & Retail labor Rate details.
    Then Is possible to put values to fields.
    When Click on the Save button.
    Then The customer type is saved.
    When Click on the Delete icon next to one of the Types.
    Then The customer type is permanently deleted.
    When Enter "SeleniumTesting1" description only and click Save.
    Then Message appears: "When saving, a changed row cannot contain any blank fields"
    When Create 'SeleniumTesting2' new customer type Based On Retail minus and enter the Adjust values as 101%.
    Then Message is shown to user stating that: "Invalid Value(s). Retail minus can not be >100%, Cost Plus can not be <0% and None must be set to 0%"
    When Create 'SeleniumTesting3' new customer type Based On None and should be impossible to put Adjust % Parts it is set $0% as default
    Then Adjust % Parts is inactive for Based On = None
    When Create 'SeleniumTesting4' new customer type Based On Cost Plus and enter the Adjust values as -101%.
    Then Message is shown to user stating that: "Invalid Value(s). Retail minus can not be >100%, Cost Plus can not be <0% and None must be set to 0%"

  @TCNo(numbers=38450)
  @System
  Scenario: Administration System Settings Test
    When Open System Settings. Change the Labor Pricing Type to Single Labor Rate.
    Then Labor Pricing Type is selected as 'Single Labor Rate'
    When Select the Labor Pricing tab and set the Labor Retail per hour value to '50.00'. Click Save.
    Then New labour value '50.00' is saved.
    When Start a new Estimate with VIN '1G1ZA5ST1HF190045' and add Job Service Add-On Cabin Filter Remove and Replace. Open the Job Details window of the job.
    Then Estimate is started and Job is added 'Replace Cabin Filter ' to quote. Labour Price of job is '50.00'.
    When Return to the Labor Pricing tab. Change Labour Retail per hour value to '100'. Click Save. Return to Estimate tab.
    Then New labour value '100.00' is saved. Upon returning to the Quote tab a pop up message appears "Attention: The estimated price has changed!! This may be the result of changed admin settings."
    When Click OK on the pop up message.
    Then The estimate is loaded again.
    When Open the Job Details window again.
    Then Labour Price is job has changed to '100.00'. Enter labor retail Hour has '45.00'
    When Change the number of '20' days in the Estimate expiration days field. Create a new estimate and move to the Notes tab.
    Then Estimate valid until date is the number of days set in system settings.
    When Enter some text into the Estimate Prefix 'Selenium' and Estimate Suffix 'Testing' boxes and save. Create and print a new quote.
    Then The quote number is prefixed and suffixed by the text entered in system settings.
    When Tick the Prompt For Generic Parts Selection box and save. Add a new Local Generic Part for Brake Fluid. Create a new quote. Add Brake Fluid change job
      | 1 | Test part 1 | 1234567 | 4.00 | 6.00 | 0 |
    Then Setting saved. New part added. When job is added to quote the Parts & Labour window opens automatically giving user option to 'Replace' Generic parts.

  @TCNo(numbers=36326)
  @Bulk
  Scenario:  Administration Bulk Fluids Test
    When For Administration and BulkFluids tab Only 'Please select a LocalPart' drop down box values displayed. There is no Manufacturer Parts for Market and Local fluid types are displayed.
    And Select part SCREENWASH_$1 from the drop down list.
    And Add a new Local part by entering the details into the fields: Container Size, Description, Part No, Cost Excl. Tax, Retail Excl. Tax, Tax Band.
      | 1 | Test part 1 | 1234567 | 4.00 | 6.00 | 0 |
    When Click the Save button.
    Then Local part Test part $1 is added with correct data.
      | 1 | Test part 1 | 1234567 | $4.00 | $6.00 |
    When Click on the Edit icon of the new Local Part Test Part $1.
    Then Local part details populated into edit boxes.
    When Edit the description as 'Test Part 11' and click Save.
    Then Part description is changed to Test Part $11
      | 1 | Test Part 11 | 1234567 | $4.00 | $6.00 |
    When Click on the Delete icon of the Local part Test Part $11.
    Then Local part 'Test Part 11' is deleted from the list.

  @TCNo(numbers=36372)
  @LocalOperation
  Scenario: Administration Bulk Fluids Adding Local Operation to Bulk Fluids Test
    When For Administration and BulkFluids tab Only 'Please select a LocalPart' drop down box values displayed. There is no Manufacturer Parts for Market and Local fluid types are displayed.
    And Select part SCREENWASH_$1 from the drop down list.
    And Add a new Local part by entering the details into the fields: Container Size, Description, Part No, Cost Excl. Tax, Retail Excl. Tax, Tax Band.
      | 1 | Test part 1 | 1234567 | 4.00 | 6.00 | 0 |
    And Click the Save button.
    Then Local part Test part $1 is added with correct data.
      | 1 | Test part 1 | 1234567 | $4.00 | $6.00 |
    And Local part can be created without entering an Ops code.
    When Edit a Market part. Setting a ‘Local Operation Code’ value is optional.
      | 4.00 | 6.00 |
    Then Market part can be edited and saved without entering an Ops code.
    When Edit a Local part. Setting a ‘Local Operation Code’ value is optional.
      | 2 | SeleniumTest 1 | 12345679 | $2.00 | $4.00 |
    Then Local part can be edited and saved without entering an Ops code.
    When Edit a Market part. The Local Operation Code text entered 'Text box maximum limit' by the user must not exceed $20 characters.
    Then A maximum of 20 characters can be entered into the Ops field 3.
    When Edit a Local part. The Local Operation Code text entered 'Text box maximum limit' by the user must not exceed $20 characters.
    Then A maximum of 20 characters can be entered into the Ops field 4.
    And remove added local part from the bulk fluids

  @TCNo(numbers=36372)
  @FixedPrice
  @Part
  Scenario: Part Pricing Except by Category Fixed Price Test
    When Go to the Administration Part Pricing Except. by Category tab
    Then Except. by Category tab is accessible
    When To add new part category exception click button ADD
    Then A window pop ups with the list of all part categories available.
    When Search part category 'Horn'
    Then 'Horn' category should be visible on the list
    When Select Fixed Price type from the drop down box and set value to 1.99
    Then Record for 'Horn' is created or updated.
    When Create estimate with VIN '1GCVKREC0JZ221473' and add Job Body Systems Horn Remove & Replace Dual
    Then Estimate is created with job added
      | 1 | Horn Remove & Replace | $64.99 |
    When Open Job details and check part price for Horn
    Then Price should be visible
      | HORN | $1.99 | GM Genuine Parts 84566359 Horn |
    Then close browser
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP '1GCVKREC0JZ221473' job ID '201000555038'
    Then In response price should be also '1.99'


  @TCNo(numbers=36372)
  @CostPlus
  @Part
  Scenario: Part Pricing Except by Category Cost Price Plus and Minus Test
    When Go to the Administration Part Pricing Except. by Category tab
    Then Except. by Category tab is accessible
    When To add new part category exception click button ADD
    Then A window pop ups with the list of all part categories available.
    When Search part category 'Horn'
    Then 'Horn' category should be visible on the list
    When Select Cost Plus Price type from the drop down box and set value to 10.00
    Then Record for 'Horn' is created or updated.
    When Create estimate with VIN '1GCVKREC0JZ221473' and add Job Body Systems Horn Remove & Replace Dual
    Then Estimate is created with job added
      | 1 | Horn Remove & Replace | $83.75 |
    When Open Job details and check part price for Horn
    Then Price should be visible
      | HORN | $20.75 | GM Genuine Parts 84566359 Horn |
    When Check Cost and Price of the tested PN '84566359'
    Then Part Number, Description, Cost, Price Exl tax is now visible
    When Open Job details and check part price for Horn
    Then Cost Price from 18.86 plus 10% should be visible
    Then close browser
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP '1GCVKREC0JZ221473' job ID '201000555038'
    Then In response price should be also '20.75'
    When Go to the Administration Part Pricing Except. by Category tab
    Then Except. by Category tab is accessible
    When To add new part category exception click button ADD
    Then A window pop ups with the list of all part categories available.
    When Search part category 'Horn'
    Then 'Horn' category should be visible on the list
    When Select Cost Minus Price type from the drop down box and set value to 10.00
    Then Record for 'Horn' is created or updated.
    When Create estimate with VIN '1GCVKREC0JZ221473' and add Job Body Systems Horn Remove & Replace Dual
    Then Estimate is created with job added
      | 1 | Horn Remove & Replace | $79.97 |
    When Open Job details and check part price for Horn
    Then Price should be visible
      | HORN | $16.97 | GM Genuine Parts 84566359 Horn |
    When Check Cost and Price of the tested PN '84566359'
    Then Part Number, Description, Cost, Price Exl tax is now visible
    When Open Job details and check part price for Horn
    Then Cost Price from 18.86 minus 10% should be visible
    Then close browser
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP '1GCVKREC0JZ221473' job ID '201000555038'
    Then In response price should be also '16.97'

  @TCNo(numbers=38598)
  @ListPrice
  @Part
  Scenario: Part Pricing Except by Category List Price Test
    When Go to the Administration Part Pricing Except. by Category tab
    Then Except. by Category tab is accessible
    When To add new part category exception click button ADD
    Then A window pop ups with the list of all part categories available.
    When Search part category 'Horn'
    Then 'Horn' category should be visible on the list
    When Select list price type from the drop down box and set value to 10.00
    Then Record for 'Horn' is created or updated.
    When Create estimate with VIN '1GCVKREC0JZ221473' and add Job Body Systems Horn Remove & Replace Dual
    Then Estimate is created with job added
      | 1 | Horn Remove & Replace | $99.40 |
    When Open Job details and check part price for Horn
    Then Price should be visible
      | HORN | $36.40 | GM Genuine Parts 84566359 Horn |
    When Check Cost and Price of the tested PN '84566359'
    Then Part Number, Description, Cost, Price Exl tax is now visible
    When Open Job details and check part price for Horn
    Then Cost Price from 33.09 plus 10% should be visible
    Then close browser
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP '1GCVKREC0JZ221473' job ID '201000555038'
    Then In response price should be also '36.40'
    When Go to the Administration Part Pricing Except. by Category tab
    Then Except. by Category tab is accessible
    When To add new part category exception click button ADD
    Then A window pop ups with the list of all part categories available.
    When Search part category 'Horn'
    Then 'Horn' category should be visible on the list
    When Select List Minus Price type from the drop down box and set value to 10.00
    Then Record for 'Horn' is created or updated.
    When Create estimate with VIN '1GCVKREC0JZ221473' and add Job Body Systems Horn Remove & Replace Dual
    Then Estimate is created with job added
      | 1 | Horn Remove & Replace | $92.78 |
    When Open Job details and check part price for Horn
    Then Price should be visible
      | HORN | $29.78 | GM Genuine Parts 84566359 Horn |
    When Check Cost and Price of the tested PN '84566359'
    Then Part Number, Description, Cost, Price Exl tax is now visible
    When Open Job details and check part price for Horn
    Then Cost Price from 33.09 minus 10% should be visible
    Then close browser
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP '1GCVKREC0JZ221473' job ID '201000555038'
    Then In response price should be also '29.78'

  @TCNo(numbers=38598)
  @partNumber
  @Part
  Scenario: Part Pricing Except by Part Number
    When When Create estimate with VIN '1GCVKREC0JZ221473' and add Job Body Systems Horn Remove & Replace Dual
    Then Estimate is created with added job.
      | 1 | Rear Axle Fluid Change | $73.58 |
    When Open Job details for the added job in the created estimate and check part price 22.25 for $19300457
    Then Quantity '2.7' and Price (Ex tax) '$60.08' should be visible
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP '1GCVKREC0JZ221473' job ID '083300015126'
    Then In response price should be also '22.25'
    When Go to the Administration Part Pricing Except. by Part Number
    Then Except. by Part Number tab is accessible
    When To add new part number exception click button ADD
    Then A window pop ups with the Manufacturer Parts search option.
    When Search part by Part ID  '19300457'
    Then Rear Axle  should be visible on the list
    When Click Add icon
    Then Record with part is added to the list where is possible to update Cost, Selling Price
    When Update the Selling Price '25.25' to your desired values and click Save
    Then Exception is created Record with values '25.25' is stored on Except. by Part Number list
    When Open Job details for the added job in the created estimate and check part price for '19300457'
    Then Pop up window appears "Attention: The estimated price has changed!! This may be the result of changed admin settings."
    Then Price Ex Tax 25.25 and Quantity should be equal to defined exception
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP '1GCVKREC0JZ221473' job ID '083300015126'
    Then In response price should be also '25.25'
    Then application clean up
    Then close browser

  @TCNo(numbers=36329)
  @Upload
  Scenario:  Administration - Part Pricing - Part Pricing Upload
    When Upload a 'InvalidCSV.jpg' non .CSV file
    Then Error message displayed "The uploaded file is invalid. It must exist and must be .csv file format.".
    When Download the stock upload example
    Then 'Stock-Upload-Example-B.csv' Downloads successfully
    When Upload the stock upload example
    Then Uploads successfully
    When Hit the Choose file button
    Then The file viewer loads
    When Hit Cancel when the window pops up.
    Then The file viewer closes.
    And close browser

  @TCNo(numbers=36374)
  @Rounding
  @MarketPart
  Scenario: Administration - Bulk Fluids - Generic Parts Rounding - Application Market Part
    When Administration Panel>Bulk Fluids for fluid ENGINE_OIL_$5 you have created Market Local Part as below: Cointainer Size: '1.1' Description: 'New Market Oil' Part No: '78932151' Cost Excl. Tax: '$5.00' Retail Excl. Tax: '$10.00' Tax brand: $0 Round Up Quantity: ENABLED. index 7 and 3
    Then Local Market Part is defined index 3
    When Create estimate to VIN: '1G1ZA5ST1HF190045'
    Then VIN is recognized '1G1ZA5ST1HF190045'
    When Add Job from the tree: Scheduled Maintenance > Oil Change > Engine Oil and Filter Replacement > Up To Model Year $2017
    Then Job is added to the Estimate
      | 1 | Oil Change Engine Oil and Oil Filter Replacement | $61.90 |
    When In Create Estimate tab open Job details of added Job and check Generic part quantity
    Then Expected calculated qty in application = $4.$2 quarts container size of used part [rounded up] For this example will be $4.$2 or'1.1'=$3.$82 containers and retailerPrice '10.00' with round up to $4containers and Price Ex.tax = '44.00' or '44.00'
    When Administration Panel>Bulk Fluids for fluid ENGINE_OIL_$5 you have created Market Local Part as below: Cointainer Size: '1.1' Description: 'New Market Oil' Part No: '78932151' Cost Excl. Tax: '$5.00' Retail Excl. Tax: '$10.00' Tax brand: $0 Round Up Quantity: DISABLED index 7 and 3
    Then Job is added to the Estimate
      | 1 | Oil Change Engine Oil and Oil Filter Replacement | $59.90 |
    Then In Create Estimate tab open Job details of added Job and check Generic part quantity
    Then Expected calculated qty in application = $4.$2 quarts container size of used part [rounded up] For this example will be $4.$2 or'1.1'=$3.$82 containers and retailerPrice '10.00' with round up to $4containers and Price Ex.tax = '42.00' or '42.00'

  @TCNo(numbers=39517)
  @Rounding
  @LocalPart
  Scenario: Administration - Bulk Fluids - Generic Parts Rounding - Application Local Part
    When Administration Panel>Bulk Fluids for fluid ENGINE_OIL_$5 you have created Market Local Part as below: Cointainer Size: '200' Description: 'Oil From Barrel' Part No: '777777' Cost Excl. Tax: '$1.00' Retail Excl. Tax: '$2.00' Tax brand: $0 Round Up Quantity: ENABLED. index 8 and 4
    Then Local Market Part is defined index 4
    When Create estimate to VIN: '1G1ZA5ST1HF190045'
    Then VIN is recognized '1G1ZA5ST1HF190045'
    When Add Job from the tree: Scheduled Maintenance > Oil Change > Engine Oil and Filter Replacement > Up To Model Year $2017
    Then Job is added to the Estimate
      | 1 | Oil Change Engine Oil and Oil Filter Replacement | $417.90 |
    When In Create Estimate tab open Job details of added Job and check Generic part quantity
    Then Expected calculated qty in application = $4.$2 quarts container size of used part [rounded up] For this example will be $4.$2 or'200.00'=$3.$82 containers and retailerPrice '2.00' with round up to $4containers and Price Ex.tax = '400.00' or '400.00'
    When Administration Panel>Bulk Fluids for fluid ENGINE_OIL_$5 you have created Market Local Part as below: Cointainer Size: '200' Description: 'Oil From Barrel' Part No: '777777' Cost Excl. Tax: '$1.00' Retail Excl. Tax: '$2.00' Tax brand: $0 Round Up Quantity: DISABLED index 8 and 4
    Then Job is added to the Estimate
      | 1 | Oil Change Engine Oil and Oil Filter Replacement | $26.30 |
    Then In Create Estimate tab open Job details of added Job and check Generic part quantity
    Then Expected calculated qty in application = $4.$2 quarts container size of used part [rounded up] For this example will be $4.$2 or'200.00'=$3.$82 containers and retailerPrice '2.00' with round up to $4containers and Price Ex.tax = '8.4' or '8'

  @TCNo(numbers=39527)
  @Rounding
  @DMSMarketPart
  Scenario: Administration - Bulk Fluids - Generic Parts Rounding - DMS Market Part
    When Administration Panel>Bulk Fluids for fluid ENGINE_OIL_$5 you have created Market Local Part as below: Cointainer Size: '1.1' Description: 'New Market Oil' Part No: '78932151' Cost Excl. Tax: '$5.00' Retail Excl. Tax: '$10.00' Tax brand: $0 Round Up Quantity: ENABLED. index 7 and 3
    Then Local Market Part is defined index 3
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP '1G1ZA5ST1HF190045' job ID '066900505009'
    Then In response price should be '789321514.00New Market Oil11.0011.00falseTotal0.00'
    When Administration Panel>Bulk Fluids for fluid ENGINE_OIL_$5 you have created DMS Market Local Part as below: Cointainer Size: '1.1' Description: 'New Market Oil' Part No: '78932151' Cost Excl. Tax: '$5.00' Retail Excl. Tax: '$10.00' Tax brand: $0 Round Up Quantity: DISABLED index 7 and 3
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP '1G1ZA5ST1HF190045' job ID '066900505009'
    Then In response price should be '789321513.82New Market Oil11.0011.00falseTotal0.00'

  @TCNo(numbers=39527)
  @Rounding
  @DMSLocalPart
  Scenario: Administration - Bulk Fluids - Generic Parts Rounding - DMS Local Part
    When Administration Panel>Bulk Fluids for fluid ENGINE_OIL_$5 you have created Market Local Part as below: Cointainer Size: '200' Description: 'Oil From Barrel' Part No: '777777' Cost Excl. Tax: '$1.00' Retail Excl. Tax: '$2.00' Tax brand: $0 Round Up Quantity: ENABLED. index 8 and 4
    Then Local Market Part is defined index 3
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP '1G1ZA5ST1HF190045' job ID '066900505009'
    Then In response price should be '7777771.00Oil From Barrel400.00400.00falseTotal0.00'
    When Administration Panel>Bulk Fluids for fluid ENGINE_OIL_$5 you have created DMS Market Local Part as below: Cointainer Size: '200' Description: 'Oil From Barrel' Part No: '777777' Cost Excl. Tax: '$1.00' Retail Excl. Tax: '$2.00' Tax brand: $0 Round Up Quantity: DISABLED index 8 and 4
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP '1G1ZA5ST1HF190045' job ID '066900505009'
    Then In response price should be '7777770.02Oil From Barrel400.00400.00falseTotal0.00'

  @TCNo(numbers=36323)
  @Org
  Scenario: Administration - Org. Detail
    When Amend the name 'SeleniumTesting'.
    Then Name is changed 'SeleniumTesting'
    When Amend the contact name 'QA'
    Then Contact name is changed 'QA'.
    When Amend the address 'SeleniumTestingAddr'
    Then Address is changed 'SeleniumTestingAddr'
    When Amend the zip code 'A1234'.
    Then Postal code is changed 'A1234'
    When Amend the telephone number '12356789'
    Then Telephone number is changed '12356789'
    When Amend the fax number '1234'
    Then Fax number is changed '1234'
    When Amend the email address 'Testingemail@oeconnection.com'
    Then E-Mail address is changed 'Testingemail@oeconnection.com'.
    When Select the tick box to confirm the changes on this page.
    Then The box is tickable and the warning appears By "By accepting this setting, you are confirming that you have set up Service Workbench PRO Pricing and the system is ready to use at your dealership."
    When Click cancel.
    Then Tickbox is tickable Warning is now closed.

  @TCNo(numbers=36328)
  @GLC
  Scenario: Administration - GLC/LLC
    When Ensure the list of GLCs & LLC's are populated
    Then The table is populated with information
    When Assign a '1111111' LLC against a GLC and hit Save.
    Then The LLC '1111111' is set against the relevant GLC and the information is saved
    When Hit the 'unmapped' button
    Then All unmapped GLC's are displayed
    When Hit the 'new' button
    When Search for a description 'Steering Column Seal Replacement'
    Then 'Steering Column Seal Replacement' Results pulled back are based on the 'searchDescription' term
    When Search for a GLC '7441980'
    Then '7441980' Results pulled back are based on the 'searchGLC' term
    When Search for a LLC '1111111'
    Then '1111111' Results pulled back are based on the 'searchLLC' term

  @TCNo(numbers=40116)
  @SLR
  @LaborPrice
  Scenario: Administration - Labor Pricing - Single Labor Rate
    When Select 'Single Labor Rate' from the System Settings Labor Pricing Type and Save. Open the Labor Pricing tab
    Then Single Labor Rate is the default option
    When Make sure in system Settings > Labor Pricing Type: Single Labor Rate is selected. In Labor Pricing  > Single Labor Rate set Labor Retail per hour as '50.00' . Add a job to Estimate for vin '1G1ZA5ST1HF190045'
    Then Correct labor price is calculated in job "Replace Cabin Filter ", "50.00"
    When Set Labor Retail per hour as '25.00'
    Then Labour price correctly adjusted '25.00'
    When Add a job to quote, check labor price. Change Single Labor Rate value. Return to quote
    Then Labor price has changed to reflect new Single Labor Rate. "Replace Cabin Filter ", "25.00"
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP '1G1ZA5ST1HF190045' job ID '080300055001'
    Then In response single labour price should be '25.00'
    Then Set Labor Retail per hour as '45.00'

  @TCNo(numbers=40117)
  @JD
  @LaborPrice
  Scenario: Administration - Labor Pricing - Job Difficulty
    When Select "Job Difficulty" from the System Settings > Labor Pricing Type and Save
    Then Job Difficulty is the default option,
    When Open the Job Difficulty tab. Click the Save button without entering any rates.
    Then User is advised they need to "All Default Vehicle Difficulty levels are mandatory".
    When Open the Job Difficulty tab. Enter values in each Default box (Simple, Normal, Complex – Car, Truck, Van). Click Save.
      | 10.00 | 50.00 | 100.00 |
    Then Rates are saved.
      | 10.00 | 50.00 | 100.00 |
    When Remove one of the default rate values and click Save
    Then User is advised they need to "All Default Vehicle Difficulty levels are mandatory".
    When Select "Job Difficulty" from the System Settings DD and Save. Open the Labor Pricing tab
    Then Job Difficulty is the default tab.
    When Set default car '1G1ZA5ST1HF190045' rates as: Simple: 10, Normal: 50, Complex: 100.Start quote with a Car and add one job from each Difficulty group.
    Then Simple job uses rate 10, Normal job uses rate 50, Complex job uses rate 100
      | 0669040 | 8033790 | 4413660 |
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP '1G1ZA5ST1HF190045' job ID '066900505009'
    Then In response single labour price should be '10.00'
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP '1G1ZA5ST1HF190045' job ID '801006555116'
    Then In response single labour price should be '50.00'
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP '1G1ZA5ST1HF190045' job ID '440505055090'
    Then In response single labour price should be '100.00'
    When Set default truck '2CNALBEC0B6217743' rates as: Simple: 10, Normal: 50, Complex: 100.Start quote with a Car and add one job from each Difficulty group.
    Then Simple job uses rate 10, Normal job uses rate 50, Complex job uses rate 100
      | 0669040 | 8033790 | 4413660 |
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP '2CNALBEC0B6217743' job ID '066900505009'
    Then In response single labour price should be '10.00'
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP '2CNALBEC0B6217743' job ID '801006555116'
    Then In response single labour price should be '50.00'
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP '2CNALBEC0B6217743' job ID '440505055090'
    Then In response single labour price should be '100.00'
    When Set default van '1GCWGFFA7B1142237' rates as: Simple: 10, Normal: 50, Complex: 100.Start quote with a Car and add one job from each Difficulty group.
    Then Simple job uses rate 10, Normal job uses rate 50, Complex job uses rates 100
      | 0669040 | 8031850 | 4413660 | 8031851 |
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP '1GCWGFFA7B1142237' job ID '066900505009'
    Then In response single labour price should be '10.00'
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP '1GCWGFFA7B1142237' job ID '801006555116'
    Then In response single labour price should be '50.00'
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP '1GCWGFFA7B1142237' job ID '440505055090'
    Then In response single labour price should be '100.00'
    When Expand the Car, Truck, Van lists on the Job Difficulty tab.
    Then Models are sorted in alphabetical order by Brand and by Model under each vehicle type
    When Set rates for a specific Car model: i.e. "Chevrolet Malibu" as Simple: 25, Normal: 60, Complex: 80.
    When Set default car '1G1ZA5ST1HF190045' rates as: Simple: 10, Normal: 50, Complex: 100.Start quote with a Car and add one job from each Difficulty group.
    Then Simple job uses rate 25, Normal job uses rate 60, Complex job uses rate 80
      | 0669040 | 8033790 | 4413660 |
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP '1G1ZA5ST1HF190045' job ID '066900505009'
    Then In response single labour price should be '25.00'
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP '1G1ZA5ST1HF190045' job ID '801006555116'
    Then In response single labour price should be '60.00'
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP '1G1ZA5ST1HF190045' job ID '440505055090'
    Then In response single labour price should be '80.00'
    When Expand the Car, Truck, Van lists on the Job Difficulty tab.
    When Set rates for a specific truck model: i.e. "Chevrolet Equinox" as Simple: 25, Normal: 60, Complex: 80.
    When Set default truck '2CNALBEC0B6217743' rates as: Simple: 25, Normal: 60, Complex: 80.Start quote with a Car and add one job from each Difficulty group.
    Then Simple job uses rate 25, Normal job uses rate 60, Complex job uses rate 80
      | 0669040 | 8033790 | 4413660 |
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP '2CNALBEC0B6217743' job ID '066900505009'
    Then In response single labour price should be '25.00'
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP '2CNALBEC0B6217743' job ID '801006555116'
    Then In response single labour price should be '60.00'
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP '2CNALBEC0B6217743' job ID '440505055090'
    Then In response single labour price should be '80.00'
    When Expand the Car, Truck, Van lists on the Job Difficulty tab.
    When Set rates for a specific van model: i.e. "Chevrolet Express 2500" as Simple: 25, Normal: 60, Complex: 80.
    When Set default van '1GCWGFFA7B1142237' rates as: Simple: 25, Normal: 60, Complex: 80.Start quote with a Car and add one job from each Difficulty group.
    Then Simple job uses rate 25, Normal job uses rate 60, Complex job uses rates 80
      | 0669040 | 8031850 | 4413660 | 8031851 |
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP '1GCWGFFA7B1142237' job ID '066900505009'
    Then In response single labour price should be '25.00'
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP '1GCWGFFA7B1142237' job ID '801006555116'
    Then In response single labour price should be '60.00'
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP '1GCWGFFA7B1142237' job ID '440505055090'
    Then In response single labour price should be '80.00'
    Then Clear the vehicle rental prices.
      | Chevrolet Malibu | Chevrolet Equinox | Chevrolet Express 2500 |

  @TCNo(numbers=40118)
  @LM
  @LaborPrice
  Scenario: Administration - Labor Pricing - Labor Matrix
    When Select Labor Matrix from the System Settings > Labor Pricing Type and Save. Open the Labor Pricing tab
    Then Labor matrix is the default option
    When Enter a value '10' in the Populate empty cells field and click Add.
    Then All empty cells are populated with the value.
    When Create a Estimate for vin "1G1ZA5ST1HF190045", add job, check labour time.
    Then The Labor Matrix rate for the labor time is used in the job
      | 10 | 0665010 | 1 |
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP '1G1ZA5ST1HF190045' job ID '080300055001'
    Then In response single labour price should be '10.00'
    When Click on the Calculated Price view option.
    Then All rates are converted into a Price and prices are calculated correctly.
    When Click on the Exception matrix option.
    Then Cells are changed to Exception view and the job Content Search is populated with the job hierarchy.
    Then Oil change --> Engine Oil and Oil Filter Replacement is selected as an Exception and is highlighted Red
      | Engine Oil and Oil Filter Replacement | red |
    When Enter a rate for 0.3 and Save. Drill down the Scheduled Maintenance hierarchy.
    Then The 2 levels above job are Yellow and the job is Green after refresh
      | Scheduled Maintenance | Engine Oil and Oil Filter Replacement | yellow | green |
    When Start quote for VIN "1G1105S30HU129006" and add job Scheduled Maintenance --> Oil change --> Engine Oil and Oil Filter Replacement
    Then The Exception rate is used for this job
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP '1G1105S30HU129006' job ID '066900505003'
    Then In response single labour price should be '100.00'
    When Open the Exception in the matrix and click the ‘Calculated Price’ view option.
    Then The rate is converted into a Price and is calculated correctly. Tick boxes are disabled.
    When Click the ‘Labour Rate’ view option. ‘Tick’ the box where the Exception rate is and click Delete
    Then Exception rate is deleted and the hierarchy colours are removed
      | Scheduled Maintenance | Engine Oil and Oil Filter Replacement |
    When Create an Exception rate for the top level of a hierarchy group
    Then Only the top level i.e. Body Systems is coloured Green
      | Body Systems | green |
    When Start quote, add job, change Labor Pricing Type in System Settings. "1G1105S30HU129006"
    Then Labor price has changed to reflect new Labor Pricing Type

  @TCNo(numbers=40119)
  @LMMenuManager
  @LaborPrice
  Scenario: Administration - Labor Pricing - Menu manager rules take precedence over the Labor Pricing rates
    When Select Single Labor Rate from the System Settings Labor Pricing Type and Save. Open the Labor Pricing tab
    Then Single Labor Rate is the default option
    When Set up menu manager rule against a job with Labor Pricing using effects: Adjust total labor price exc. Tax Set labor rate excl tax Set any labor time to
      | SeleniumTesting | SeleniumTesting1 | ruleName | ruleDescription | ruleContentDescription | validFromString | validToString |
    Then Menu manager rules take precedence over the Labor Pricing Single Labor Rate "1G1105S30HU129006","100.00f"
    Then Select Single Labor Rate from the System Settings > Labor Pricing Type and Save
    When Select "Job Difficulty" from the System Settings > Labor Pricing Type and Save
    Then Job Difficulty is the default option,
    When Set up menu manager rule against a job with Labor Pricing using effects: Adjust total labor price exc. Tax Set labor rate excl tax Set any labor time to
      | SeleniumTesting | SeleniumTesting1 | ruleName | ruleDescription | ruleContentDescription | validFromString | validToString |
    Then Menu manager rules take precedence over the Labor Pricing Single Labor Rate "1G1105S30HU129006","100.00f"
    Then Select Single Labor Rate from the System Settings > Labor Pricing Type and Save
    When Select Labor Matrix from the System Settings > Labor Pricing Type and Save. Open the Labor Pricing tab
    Then Labor matrix is the default option
    When Set up menu manager rule against a job with Labor Pricing using effects: Adjust total labor price exc. Tax Set labor rate excl tax Set any labor time to
      | SeleniumTesting | SeleniumTesting1 | ruleName | ruleDescription | ruleContentDescription | validFromString | validToString |
    Then Menu manager rules take precedence over the Labor Pricing Single Labor Rate "1G1105S30HU129006","100.00f"
    Then Select Single Labor Rate from the System Settings > Labor Pricing Type and Save

  @AddingBrand
  Scenario: Administration - Bulk Fluids - Adding Brand/Quality to Bulk Fluids
    When Edit a Market part. Setting a ‘Brand and Quality’ value '6.00' is optional.
    Then Market part can be edited and saved without entering the Brand and Quality.
    When Add a new Local part by entering the details into the fields: Container Size, Description, Part No, Cost Excl. Tax, Retail Excl. Tax, Tax Band.
      | 1 | Test part 1 | 1234567 | 4.00 | 6.00 | 0 |
    And Click the Save button.
    Then Local part can be created without entering the Brand and Quality.
    When Edit a Local part. Setting a ‘Brand and Quality’ value is optional.
    Then Local part can be edited and saved without entering the Brand and Quality 'SNPlus'.
    When Edit a Market part. A ‘Brand and Quality’ value can only be used once per Generic Part Place Holder 'SNPlus'.
    Then A Brand and Quality value can only be used for 3 part under the same Place Holder.
    When Edit a Local part. A ‘Brand and Quality’ value can only be used once per Generic Part Place Holder 'SNPlus'.
    Then A Brand and Quality value can only be used for 7 part under the same Place Holder.
    And remove added local part from the bulk fluids brand quality
