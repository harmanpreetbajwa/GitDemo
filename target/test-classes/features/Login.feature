Feature: Login
Scenario: Data Entry on Login Page

Given User has userName and PassWord
And User navigate to landing page
And clicks login button 
When User entered "userName" and "password"
Then Page should display invalidusername and password
