Feature: Flight Searching in Vueling

  Narrative:
  In order to search for a flight
  As a traveler
  I want to see the result of search page.

  Scenario Outline: Search for flight in Vueling
  Given I'm in the flight search page
    When I search for the following flight:"<originLocation>","<destinationLocation>"
  Then I get the flight search result in the flight search result page


    Examples:
      | originLocation   | destinationLocation  |
      | Alicante  | Barcelona     |
      | Madrid  | Barcelona     |
