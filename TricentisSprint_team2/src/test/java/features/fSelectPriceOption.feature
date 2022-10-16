Feature: Selecting price option for Camper
@PriceOptionCamper
Scenario Outline: Selecting a price option for Camper
Given when user enters valid vehicle data 
And user enters valid insurant data
And user enters valid product data
When User selects price option for camper
Then User navigates To Send Quote window of Camper