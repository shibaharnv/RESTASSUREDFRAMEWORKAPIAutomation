Feature: Validating place APIs

@Addplace @Regression
Scenario Outline: Verify place is successfully added using AddplaceAPI

Given Add place payload with "<language>" "<name>" "<phonenumber>"
When User calls "addplaceApi" with "POST" http request
Then The Api call got sucess with 200 response code.
And The "status" code should be "OK"
And The "scope" code should be "APP"
And Do the get call using "getplaceApi" with place id and verify the "<name>" in the response 

Examples:

|language | name | phonenumber |
|Tamil  | mano| 78954234564|
# |Telugu |xxxx |11111111111|

@DeletePlace @Regression
Scenario: Delete the added place using Deleteplaceapi

Given Delete the place by adding the payload with placeid  
When User calls "deleteplaceApi" with "POST" http request
Then The Api call got sucess with 200 response code.
And The "status" code should be "OK"
