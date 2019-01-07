Feature: Application Login
Scenario: Home page default login
Given User is on landing page
When User login into application with "jose" and "1234"
Then Home page is populated
And Cards displayed are "true"

Scenario: Home page default login failed
Given User is on landing page
When User login into application with "john" and "4321"
Then Home page is populated
And Cards displayed are "false"