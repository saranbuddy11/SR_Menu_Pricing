@MenuManager
@Regression
Feature: Menu Manager

  @TCNo(numbers=36332)
  @Basics
  Scenario: Rule Basics Test
    When Hit Create Rule
    Then The results pulled back depend on the range entered
    When Enter a name to identify the rule, insert a description and disclaimer along with a valid date range, hit 'cancelButton'
      | SeleniumTesting | SeleniumTesting1 | ruleName | ruleDescription | ruleContentDescription | validFromString | validToString |
    Then Any input is lost, and the user is taken back to the List Rules screen
    When Enter a name to identify the rule, insert a description and disclaimer along with a valid date range, hit 'deleteButton'
      | SeleniumTesting | SeleniumTesting1 | ruleName | ruleDescription | ruleContentDescription | validFromString | validToString |
    Then Any input is lost, and the rule is deleted. User taken back to the list rules screen
    When Enter a name to identify the rule, insert a description and disclaimer along with a valid date range, hit 'copyButton'
      | SeleniumTesting | SeleniumTesting1 | ruleName | ruleDescription | ruleContentDescription | validFromString | validToString |
    Then The input is kept, and the rule is copied (rule name would have COPY OF). The user stays on the rule basics screen
    When Enter a name to identify the rule, insert a description and disclaimer along with a valid date range, hit 'saveButton'
      | SeleniumTesting | SeleniumTesting1 | ruleName | ruleDescription | ruleContentDescription | validFromString | validToString |
    Then Any input is saved, the user can then proceed to rule structure.

  @TCNo(numbers=36331)
  @ListRule
  Scenario: Menu Manager - List Rules Test
    When Enter a date range, hit find report
    Then The results pulled back depend on the range enter "02/18/2021"
    When Hit Download all rules button.
    Then All current rules are downloaded in a XML format as "rules.xml".
    When Upload a set of valid rules, append to current
    Then Upload successful. Rules appended to current
    When Upload a set of valid rules, overwrite current
    Then Upload successful. Rules overwrite current
      | SeleniumTesting | SeleniumTesting1 | ruleName | ruleDescription | ruleContentDescription | validFromString | validToString |
    When Delete a pre existing rule by clicking Edit icon and then DELETE
    Then The rule is "SeleniumTesting" removed from the table.
    When Hit Deploy rules
    Then All rules currently created will be deployed to the environment.

  @TCNo(numbers=36333)
  @RuleStructure
  Scenario: Menu Manager - Rule Structure Test
    When Hit Create Rule
    When Enter a name to identify the rule, insert a description and disclaimer along with a valid date range, hit 'saveButton'
      | SeleniumTesting | SeleniumTesting1 | ruleName | ruleDescription | ruleContentDescription | validFromString | validToString |
    When Select the vehicle make (Chev), and set a job type, a unique campaign code and effect as "SeleniumTesting", then save the rule.
    Then Dropdown menus contain relevant data
      | Service Add-On - Cabin Filter - Remove & Replace | SeleniumTesting | 130 |
    When Hit Deploy rules
    Then All rules currently created will be deployed to the environment.
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP '1G1ZA5ST1HF190045' job ID '080300055001'
    Then In response total price should be also 'SeleniumTesting','130'
    When Verify the rule has worked by navigating to the job by vin '1G1ZA5ST1HF190045' selected in part one.
    Then The rule is visible upon calling to the relevant job ID
      | 1 | Cabin Filter Remove & Replace | $130.00 | 01/21/2020 |

  @TCNo(numbers=48380)
  @Effect110
  Scenario: Menu Manager - Effect 110
    Given Login the application with "MenuManager"
    When Enter VIN '1G1ZA5ST3JF207370' into VIN field and click Search
    Then The vehicle is found with 'Chevrolet, Malibu, 2018 ' characteristics displayed
    When Click on Continue
    Then Search job and select "Engine Cooling" job and select "401502055068"
    And verify "Vehicle Cleaning Exterior Car Wash" job is displayed
    When Click on Continue
    Then Enter "selenium Testing" in Notes box and click Continue
    And click save button
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP with VIN '1G1ZA5ST3JF207370' job ID '401502055068'
    Then In response verify "linkedJobs" with description "Exterior Car Wash"

  @TCNo(numbers=48381)
  @SetLabourRate
  Scenario: Menu Manager - Effect 148 -  Set labor rate excl. tax
    Given Login the application with "MenuManager"
    When click on Menu manager tab
    Then Search rule 'TC48381' and edit the rule
    And Verify Effect entry as "TC48381_E148" and "1" in rule structure
    When click on Create Estimate Tab
    When Enter VIN '1G1ZA5ST3JF207370' into VIN field and click Search
    Then The vehicle is found with 'Chevrolet, Malibu, 2018 ' characteristics displayed
    When Click on Continue
    Then Search job and expand "Spark Plugs" job and select "081800055001"
    And Verify Correct part price with Labour charge is displayed
    When Click on Continue
    Then Enter "selenium Testing" in Notes box and click Continue
    And click save button
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP with VIN '1G1ZA5ST3JF207370' job ID '081800055001'
    Then In response verify "promotion" with code "TC48381_E148" and price "EXCLTAX"
    And In response verify "labours" with attributes "fixedLaboursPriceExclTax", "fixedLaboursPriceInclTax", "priceFixedAt", "type"
        | 0.40000 | 0.40000 | EXCLTAX | MAN |
    And In response verify "labour" with attributes "id", "labourAlgoCode", "description", "labourSystemText", "asDTUs", "labourRateExcl", "ctAdLabourRateExcl", "labourValueExcl"
      | 0665060 | A | Replace Spark Plugs| null |0.4 | 1.00 | 1.00 | 0.40 |


  @TCNo(numbers=54207)
  @AppendTextToGeneratedMenu
  Scenario: Menu Manager - Effect 231 -  Append Text To The Generated Menu
    Given Login the application with "MenuManager"
    When click on Menu manager tab
    Then Search rule 'Effect 231' and edit the rule
    And Verify Effect entry as "TC54207_E231" and "TestPack#1" in rule structure
    When click on Create Estimate Tab
    When Enter VIN '1G1ZA5ST3JF207370' into VIN field and click Search
    Then The vehicle is found with 'Chevrolet, Malibu, 2018 ' characteristics displayed
    When Click on Continue
    Then Search job and expand "Disc Brake Pads" job and select "240501055101"
    And verify the description appended with "TestPack#1"
    When Click on Continue
    Then Enter "selenium Testing" in Notes box and click Continue
    And click save button
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP with VIN '1G1ZA5ST3JF207370' job ID '240501055101'
    Then In response verify job "job" with description "description" contains "TestPack#1"

  @TCNo(numbers=54209)
  @SetTotalPartPriceExclTax
  Scenario: Menu Manager - Effect 200 -   Set total part price excl tax
    Given Login the application with "MenuManager"
    When click on Menu manager tab
    Then Search rule 'Effect 200' and edit the rule
    And Verify Effect entry as "TC54209_E200" and "100" in rule structure
    When click on Create Estimate Tab
    When Enter VIN '1G1ZA5ST3JF207370' into VIN field and click Search
    Then The vehicle is found with 'Chevrolet, Malibu, 2018 ' characteristics displayed
    When Click on Continue
    Then Search job and expand "Heated" job and select "401005055076"
    And Verify Correct part price with tax "100" is displayed for "Heated Oxygen Sensor"
    When Click on Continue
    Then Enter "selenium Testing" in Notes box and click Continue
    And click save button
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP with VIN '1G1ZA5ST3JF207370' job ID '401005055076'
    Then In response verify "partsList" with "fixedPartsPriceExclTax" contains "100.0000"
    And In response verify "partsList" with "fixedPartsPriceInclTax" contains "100.0000"
    And In response verify the value in "priceExcl" tag in "part"

  @TCNo(numbers=54210)
  @SetTotalPriceExclTax @new
  Scenario: Menu Manager - Effect 240 -   Set total price excl tax
    Given Login the application with "MenuManager"
    When click on Menu manager tab
    Then Search rule 'Effect 240' and edit the rule
    And Verify Effect entry as "TC54210_E240" and "100" in rule structure
    When click on Create Estimate Tab
    When Enter VIN '1G1ZA5ST3JF207370' into VIN field and click Search
    Then The vehicle is found with 'Chevrolet, Malibu, 2018 ' characteristics displayed
    When Click on Continue
    Then Search job and expand "Heated" job and select "401005155510"
    And Verify Correct part price "100" is displayed for "Heated Oxygen Sensor"
    When Click on Continue
    Then Enter "selenium Testing" in Notes box and click Continue
    And click save button
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP with VIN '1G1ZA5ST3JF207370' job ID '401005155510'
    Then In response verify "promotion" with "code" contains "TC54210_E240"
    And In response verify "promotion" with "priceExcl" contains "100.0000"
    And In response verify "promotion" with "priceFixedAt" contains "EXCLTAX"
    And In response verify "promotion" with "priceIncl" contains "100.0000"
    And In response verify the value "100.0000" for the child "priceIncl"
    And In response verify the value "100.0000" for the child "priceExcl"

  @TCNo(numbers=54211)
  @SetTotalLabourPriceExclTax @new
  Scenario: Menu Manager - Effect 240 -   Set total price excl tax
    Given Login the application with "MenuManager"
    When click on Menu manager tab
    Then Search rule 'Effect 170' and edit the rule
    And Verify Effect entry as "TC54212_E170" and "100" in rule structure
    When click on Create Estimate Tab
    When Enter VIN '1G1ZA5ST3JF207370' into VIN field and click Search
    Then The vehicle is found with 'Chevrolet, Malibu, 2018 ' characteristics displayed
    When Click on Continue
    Then Search job and expand "Radiator" job and select "401005155510"
    And Verify Correct part price "100" is displayed for "Heated Oxygen Sensor"
    When Click on Continue
    Then Enter "selenium Testing" in Notes box and click Continue
    And click save button
    When Run 'GMMP/GetJobDetailsGMMP' request in SOAP with VIN '1G1ZA5ST3JF207370' job ID '401005155510'
    Then In response verify "promotion" with "code" contains "TC54210_E240"
    And In response verify "promotion" with "priceExcl" contains "100.0000"
    And In response verify "promotion" with "priceFixedAt" contains "EXCLTAX"
    And In response verify "promotion" with "priceIncl" contains "100.0000"
    And In response verify the value "100.0000" for the child "priceIncl"
    And In response verify the value "100.0000" for the child "priceExcl"