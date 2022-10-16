Feature: Entering product data for Camper
@ProductDataCamper
Scenario Outline: Entering valid Product data for Camper
Given when user is in Tricentis home Page
When he enters product data for camper from "<SheetName>" and <RowNumber>
Then he can click on next To Enter insurant data

Examples:

|SheetName|RowNumber|
|CamperProductData|0|
|CamperProductData|1|
|CamperProductData|2|
|CamperProductData|3|
