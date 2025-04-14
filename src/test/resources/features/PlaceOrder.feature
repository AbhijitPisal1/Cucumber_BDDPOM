Feature: Place order

Background: User Login
Given User in on login page
When User enters "standard_user" and "secret_sauce"
Then User should be on Home page

@SmokeTest @RegressionTest
Scenario: Add Item to Cart
Given User should be on Home page
When User add item to cart
Then Item must be added

@RegressionTest
Scenario: Checkout order
Given User is on cart page
When User do checkout
Then Should navigate to Checkout page
@SmokeTest
Scenario: Delete an Item
Given Cart must have items
When user delete an item
Then Should delete item from cart