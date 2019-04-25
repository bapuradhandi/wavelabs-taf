@api @apitc
Feature: Login:- A user should be logged in only if he/she provides correct credentials and valid error messages should be displayed wherever required

  Scenario Outline: Check if a user with correct credentials is able to log in

    Given user launches api portal
      