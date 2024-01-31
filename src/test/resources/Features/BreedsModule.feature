Feature:Breeds Module

  @API @ListOfBreeds
  Scenario Outline: Get a list of breeds
    Given user logged in with "<Authorized>" credentials
    When user send "<Request Type>" request with given "<EndPoint>" and "<Payload>" to get a list of breeds
    Then user verify that status code: "<Status Code>"
    Then validate that the Response contains a list of breeds with the specified fields and valid data

    Examples:
      | Request Type | Status Code | Authorized | Payload | EndPoint |
      | GET          | 200         | true       | null    | /breeds  |

