Feature: Login into Application

Scenario Outline: Positive test validating login
Given initialized browser with chrome 
And navigate to "http://www.qaclickacademy.com/" site
And click on login link in home page to land on sign in page
When user enters <username> and <password> and logs in
Then verify that user is successfully logged in
And close browsers

Examples:
|username|password|
|test99@gmail.com|123456|
|test123@gmail.com|12345|