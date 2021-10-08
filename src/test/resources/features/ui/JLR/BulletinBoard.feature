@JLRRegression
Feature: BulletinBoard

  @TCNo(numbers=36315)
  @NewsLetter
  Scenario: BulletinBoard - News Letter
    Given Login Dealer application "Dealer"
    When clicks on Historical Newsletter and "JLR Menu Pricing - Dialog" window loaded with Archive letter
    Then clicks on Cancel button and Archive letter window getting closed
    When clicks on Historical Newsletter and "JLR Menu Pricing - Dialog" window loaded with Archive letter
    Then clicks on any Archived letter and verify page updated with the news letter selected
    When clicks on Latest newsletter and the latest news letter will be displayed
    Then logout the application
    Given Login Dealer application "Dealer"
    Then Navigate to other tabs from BulletinBoard Tab
    And Check "https://jlrmenupricing.zendesk.com/" link present
    And Navigate to BulletinBoard and click on Continue button
    And Verify Create Quote page got displayed



