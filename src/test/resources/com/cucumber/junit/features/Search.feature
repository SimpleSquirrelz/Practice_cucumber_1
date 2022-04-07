Feature: As user I want to be able use search
  Scenario Outline:
    Given the user opens Cucumber website
    When the user clicks on the search button
    And the user writes "<searchText>" into search into search field
    And the user clicks on the "<filterName>" filter for the search results
    And the user clicks on the first item with "<tag>" tag
    Then blog page with "<title>" is displayed
      Examples:
    |searchText|filterName|tag          |title                         |
    |Announces |Blog      |Cucumber Blog|Announcing Cucumber-JVM v4.0.0|
