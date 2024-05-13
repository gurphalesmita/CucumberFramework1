Feature: login functionality

Scenario: verify_Title_TC01
Given user should be on login page
And user can verify the title
 
Scenario: verify_logo_TC02
Given user should be on login page
And user can verify the logo
 
Scenario: verify_KeyModule_text_TC03
Given user should be on login page
And user can verify the KeyModule_text


Scenario: valid login
When user enters valid credentials
And click on login button
Then user should be navigated to home page
And user can click logout link



Scenario Outline: Invalid login

When user enters userid as "<userid>" and password as "<password>" credentials
And click on login button
And  user can validate error message on login page 
Examples: 
| userid | password |
| admin1 | pwd      |
| admin2 | pwd2     |
| admin3 | pwd3     |
 







 
