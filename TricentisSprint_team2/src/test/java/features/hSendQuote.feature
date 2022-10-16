Feature: Send Quote for Camper
@sendQuoteCamper
Scenario: Sending quote for Camper after selecting a price option
Given user Enters the valid Vehicle data 
And user Enters the valid Insurant data
And user Enters the valid Product data
And user Selects the Price option
When User Enters details to send quote
Then User Receives success alert message