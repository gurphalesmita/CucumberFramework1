Feature: lead function
@test3
Scenario: create lead with mandatory fields TC01
Given user should be on login page
When user enters valid credentials
And click on login button
When user click on new lead link 
And fill all mandatory fields and click on save button
Then lead should be created successfully

@test3
Scenario: create lead with mandatory fields TC02
Given user should be on login page
When user enters valid credentials
And click on login button
When user click on new lead link 
And fill all mandatory fields and click on save button
Then lead should be created successfully

@test4
Scenario: create lead with mandatory foelds with step paramterization
Given user should be on login page
When user enters valid credentials
And click on login button
When user creats multiple leads with "<lastname>" and "<company>" verified
|lastname|company|
|Patil|BJP|
|ggg|Nice|
|sss|NCS|

And click on logout button