Feature: Entering insurant data for Camper
@InsurantDataCamper
Scenario Outline: Entering valid Insurant data for Camper
Given when user is in Tricentis home page
When he enters insurant data for camper from "<SheetName>" and <RowNumber>
Then he can click on next To enter insurant data

Examples:

|SheetName|RowNumber|
|CamperInsurantData|0|
|CamperInsurantData|1|
|CamperInsurantData|2|
|CamperInsurantData|3|