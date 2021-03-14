Feature: Account Page Feature

  Background: 
    Given user has already logged in to application
      | username         | password |
      | kas123@gmail.com | test1234 |

  Scenario: Accounts page title
    When user gets the title of the page
    Then page title should be "My account - My Store"

  Scenario: Accounts section count
    Then user gets accounts section
      | ORDER HISTORY AND DETAILS |
      | MY CREDIT SLIPS           |
      | MY ADDRESSES              |
      | MY PERSONAL INFORMATION   |
      | MY WISHLISTS              |
    And Account section count should be 5
