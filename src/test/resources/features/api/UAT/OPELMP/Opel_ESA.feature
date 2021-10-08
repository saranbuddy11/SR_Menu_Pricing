Feature: Opel ESA

  Background:
    * url OPEL_ESA_URL

  Scenario: 8.3.0 - GetPromotionalPrice
    Given request read('uat/Opel_ESA/requests/GetPromotionalPrice.xml')
    When soap action
    Then status 200
    And match response /Envelope !contains 'Fault'
#    And match response /Envelope/Body/JobDetailsOutput/JobDetailed/ICMEJobCode contains '<PromotionalPrice><Code>010300056631</Code><Description>Auspuffendtopf erneuern</Description>'
    And assert responseTime < 3000

    * string stringResponse = responseBytes
    * def schemaValidator = Java.type('utils.SchemaValidator')
    * def result = schemaValidator.validateXml(stringResponse, 'GetPromotionalPrice', 'Opel ESA')
#    * assert result == true