Feature: Entering vehicle data for Camper
@InvalidVehicleDataCamper
Scenario Outline: Entering invalid vehicle data for Camper
Given when user is in tricentis Home page
When he enters invalid vehicle data for camper from "<SheetName>" and <RowNumber>
Then he can click on Next to enter insurant data

Examples:

|SheetName|RowNumber|
|CamperInvalidVehicleData|0|
|CamperInvalidVehicleData|1|
|CamperInvalidVehicleData|2|
|CamperInvalidVehicleData|3|
