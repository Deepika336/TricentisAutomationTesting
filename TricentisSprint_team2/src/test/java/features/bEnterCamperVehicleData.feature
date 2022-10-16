Feature: Entering vehicle data for Camper
@VehicleDataCamper
Scenario Outline: Entering valid vehicle data for Camper
Given when user is in Tricentis Home page
When he enters vehicle data for camper from "<SheetName>" and <RowNumber>
Then he can click on next to enter insurant data

Examples:

|SheetName|RowNumber|
|CamperVehicleData|0|
|CamperVehicleData|1|
|CamperVehicleData|2|
|CamperVehicleData|3|