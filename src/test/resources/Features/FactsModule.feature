Feature:Facts Module

  @API @RandomFact
  Scenario Outline: Get random fact
    Given user logged in with "<Authorized>" credentials
    When user send "<Request Type>" request with given "<EndPoint>" and "<Payload>" to get random fact
    Then user verify that status code: "<Status Code>"
    Then validate that the Response contains expected fields(Fact,Length) and valid data type

    Examples:
      | Request Type | Status Code | Authorized | Payload | EndPoint |
      | GET          | 200         | true       | null    | /fact    |

  @API @ListOfFacts
  Scenario Outline: Get a list of facts
    Given user logged in with "<Authorized>" credentials
    When user send "<Request Type>" request with given "<EndPoint>" and "<Payload>" to get a list of facts
    Then user verify that status code: "<Status Code>"
    Then validate that the Response contains a list of facts with the specified fields and valid data

    Examples:
      | Request Type | Status Code | Authorized | Payload | EndPoint |
      | GET          | 200         | true       | null    | /facts   |