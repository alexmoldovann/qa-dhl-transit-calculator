Feature: Transit Time calculator

   @RegressionTest
   Scenario: Check Romania and Sweden availability
     Given page has loaded
     When I fill the calculator info with Romania and 400000 and Sweden and 11151
     Then I check the if result page is displayed
     Then I check that Europid Online tracking has value Available
     Then I check that Europid eProof of delivery within 24 hours has value Available
     Then I check that Europid Climate Neutral has value Available
     Then I check that Europid Pre-10 delivery option has value Available
     Then I check that Europid Pre-12 delivery option has value Available
     Then I check that Europid Same day pickup for booking made before 12:00 * has value Not available
     Then I check that EuroConnect Online tracking has value Available
     Then I check that EuroConnect eProof of delivery within 24 hours has value (selected post codes only)*
     Then I check that EuroConnect Climate Neutral has value Not available
     Then I check that EuroConnect Pre-10 delivery option has value Not available
     Then I check that EuroConnect Pre-12 delivery option has value Not available
     Then I check that EuroConnect Same day pickup for booking made before 12:00 * has value Not available

     When I set delivery date to today plus 7 working days
     Then I check that Eurapid delivery is over 12 working days
     Then I check that EuroConnect delivery is over 12 working days

   @RegressionTest
   Scenario: Check Romania and Germany availability
      Given page has loaded
      When I fill the calculator info with Romania and 400000 and Germany and 10115
      Then I check the if result page is displayed
      Then I check that Europid Online tracking has value Available
      Then I check that Europid eProof of delivery within 24 hours has value Available
      Then I check that Europid Climate Neutral has value Available
      Then I check that Europid Pre-10 delivery option has value Available
      Then I check that Europid Pre-12 delivery option has value Available
      Then I check that Europid Same day pickup for booking made before 12:00 * has value Not available
      Then I check that EuroConnect Online tracking has value Available
      Then I check that EuroConnect eProof of delivery within 24 hours has value (selected post codes only)*
      Then I check that EuroConnect Climate Neutral has value Not available
      Then I check that EuroConnect Pre-10 delivery option has value Not available
      Then I check that EuroConnect Pre-12 delivery option has value Not available
      Then I check that EuroConnect Same day pickup for booking made before 12:00 * has value Not available

      When I set delivery date to today plus 7 working days
      Then I check that Eurapid delivery is over 11 working days
      Then I check that EuroConnect delivery is over 11 working days

   @RegressionTest
   Scenario Outline: Check source and destination postcode negative cases
      Given page has loaded
      When I fill the calculator info with Romania and <invalidSourceCode> and Sweden and <invalidDestinationCode>

      Then Error message is displayed in both source and destination

     Examples:
      | invalidSourceCode | invalidDestinationCode |
      | 5555555555        | 5555555555                       |
      | string            | string                           |
      | 123               | 123                              |
      | whitespace        | whitespace                       |
    #and any other field validations that are needed to be tested


     ##################################################################
  ##  So, basicly all the tests need a lot time to implement, wanted to make a complete flow here to highlight how it can be done
  ##  I'm going to write what else i would test in the following part

           ##each of following can be individual tests, and need to be prioritized and see if it is in scope for automation
  ## test that the all pages are loaded properly with all isDisplayed implemented in all
  ## check titles, texts, url
  ## implement also dropdown picker for the country
  ## implement aditional validations for the input fields
  ## implement some tests for source and destination different than location, for me works only to/from romania
  ## check when calculate button has is-loading displayed
  ## click calculate and check titles, texts
  ## click calculate and go back to search
  ## click calculate and go back to search - change search and see results
  ## click calculate and see check default pickup
  ## click calculate and set date to weekend - see unavailable (can be set manualy)
  ## click calculate and check text under the result
  ## click calculate and check contact support links
  ## check changing language, location
  ## check changing dropdown header banner that menus are displayed
  ## check if the arrow buttom right works
  ## check that color of footer banner is changed when scrolling down
  ## possible checking xss injections if in scope






