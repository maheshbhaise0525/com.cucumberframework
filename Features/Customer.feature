Feature: Customer

 Background: Steps common for all scenario
 Given User Launch Chrome browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters Email as "admin@yourstore.com" and Password as "admin"
And Click on login
Then User can view Dashboard

Scenario: Add new Customer

When User click on customers Menu
And click on customers Menu Item
And click on Add new button
Then User can view Add new customer page
When User enter customer info
And click on Save button
Then User can view confirmation message "Then new customer has been added successfully."
And close browser




Scenario: Search customer by Emaail

When User click on customers Menu
And click on customers Menu Item
And Enter customer Email
When Click on search button
Then User should found Email in the Search table
And close browser


Scenario: Search customer by Emaail

When User click on customers Menu
And click on customers Menu Item
And Enter customer FirstName
And Enter customer LastName
When Click on search button
Then user should found Name in the search table
And close browser
