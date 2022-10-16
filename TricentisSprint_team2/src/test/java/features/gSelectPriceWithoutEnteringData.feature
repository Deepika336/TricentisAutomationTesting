Feature: Selecting price option for Camper 
@PriceCamper
Scenario: Selecting a price option for Camper without entering valid details
Given when user is in HOME PAGE
And user clicks on Camper
When User selects Price option for Camper
Then User cannot view Price Table