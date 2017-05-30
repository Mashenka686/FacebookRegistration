@sup
Feature: Facebook sign up

Scenario: Facebook sign up 
 Given User has a valid email
 Given User is on homepage
 When User sings up for an account
 Then User should receive email containing security code
 And After User enters security code
 Then User should be logged into account and welcome message should be displayed 
 

 Scenario: Facebook sign up 
 Given User has a valid email
 Given User is on homepage
 When User sings up for an account
 Then User uploads profile picture and welcome message should be displayed