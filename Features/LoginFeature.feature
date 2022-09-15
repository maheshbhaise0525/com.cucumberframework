Feature: Login

Scenario: Successful Login with Valid Credentials
Given User Launch Chrome browser
When User opens URL "https://admin-demo.nopcommerce.com/login"
And User enters Email as "admin@yourstore.com" and Password as "admin"
And Click on login
Then Page Title should be "Dashboard / nopCommerce administration"
When User click on logout link
Then Page Title should be "Your store. Login"
And close browser