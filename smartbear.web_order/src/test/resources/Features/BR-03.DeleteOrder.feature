@wip @br01 @regression @smoke @integration 
Feature: Delete Order 

  Background: User Log in
    Given User navigates to home page
    When User enters Username, Password, clicks Login button and should be on Web Orders page
@delete
  Scenario: A user should be able to delete an order
    And User is able to view List of All Orders table
    And User selects order to be deleted and clicks on Delete Selected button
    Then User should verify that order is deleted
