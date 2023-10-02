Feature: Management of petstore APIs

  Scenario Outline: Verify creation of new user
    Given User add header information for create user
    When User add payload for user creation "<Id>","<username>", "<firstname>","<lastName>","<email>","<password>","<phone>","<userstatus>"
    And User send "POST" request to creatuser endpoint
    And User verify the status code is 200
    Then User verify created user

    Examples: 
      | Id | username     | firstname   | lastName  | email                    | password     | phone       | userstatus |
      | 29 | Prithivi_123 | Prithiviraj | Elangovan | prithiviraj209@gmail.com | prithivi1994 | 78748387473 |          1 |

  Scenario Outline: Verify Create Addrress
    Given User add header information for update user
    When User add payload for user updation "<Id>","<username>", "<firstname>","<lastName>","<email>","<password>","<phone>","<userstatus>"
    And User send "Put" request to update user endpoint
    And User verify the status code of 200
    Then User verify updation of user

    Examples: 
      | Id | username   | firstname | lastName | email                    | password     | phone       | userstatus |
      | 29 | Elango_123 | Elangovan | shanthi  | eprithiviraj16@gmail.com | prithivi1994 | 86468488499 |          3 |

  Scenario: Verify Delete Address
    Given User add headers to delete user
    And User send "DELETE" request and deleteuser endpoint
    And User verify the status code is 200 status code
    Then User should verify "Address deleted successfully" message
