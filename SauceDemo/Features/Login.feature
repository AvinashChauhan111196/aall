Feature: Login feature
 Login feature allow user to login into corresponding saucedemo account


@SmokeTest
	Scenario: User is trying access  account using invalid credentials
		Given User is on saucedemo loging page
		When  User enter wrong credentials 
		|userName | password |
		|wrongUsername| wrongPassword|
		And click on submit
		Then 'Epic sadface: Username and password do not match any user in this service' message should display
		
	Scenario: User is trying access saucedemo account using valid credentials
		Given User is on saucedemo loging page
		When User enter valid credentials 
		|userName | password |
		|problem_user|secret_sauce|
		And click on submit
		Then user able to see home page of corresponding saucedemo account