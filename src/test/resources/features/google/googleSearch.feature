@googleSearch
Feature: Google Search UI Automation

  @java
  Scenario: Open Google homepage and search
    Given User is on google homepage
    When The search text box is loaded
    Then User types "Java" in the text box
    And User clicks on the search button
    Then User waits for the search Result
    And Add below details in log table
      | UserName | Indrajit Biswas      |
      | Email    | ibiswas003@gmail.com |
      | City     | Howrah               |
      | Zip      | 711114               |
      | Mobile   | 9123863363           |

  @python
  Scenario: Open Google homepage and search
    Given User is on google homepage
    When The search text box is loaded
    Then User types "python" in the text box
    And User clicks on the search button
    Then User waits for the search Result
