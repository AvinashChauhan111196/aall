Feature: AddCart feature
  AddCart feature will add product in cart
 
  @SmokeTest
  Scenario: Add product in cart
  	Given User has already login
  	When User add product in cart
  	| product1 | product2 | product3 |
  	|Sauce Labs Backpack|Sauce Labs Bike Light|Sauce Labs Bolt T-Shirt|
  	And User click on cart icon
  	And User click on checkout
  	And User fill details
  	| FirstName | LastName | PostalCode |
  	| Avinash | Chauhan| 411014 |
  	And User click on continue
  	And User able to finish
  	Then 'Thank you for your order!' should display message
  	
  	