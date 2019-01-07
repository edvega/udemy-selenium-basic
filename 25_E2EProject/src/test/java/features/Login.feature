Feature: Login into Application

Scenario: Positive test validating login
Given initialized browser with chrome 
And navigate to "http://www.qaclickacademy.com/" site
And click on login link in home page to land on sign in page
When user enters "test99@gmail.com" and "123456" and logs in
Then verify that user is successfully logged in