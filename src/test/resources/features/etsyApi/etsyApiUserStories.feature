@api
Feature: user checks critical api related to etsy website

  Scenario: Verify etsy website is always up
    Given User visits etsy
    Then Response should be 200

  Scenario: Verify etsy website reponse time
    Given User visits etsy
    Then Response time should be less than 2 sec

  Scenario Outline: Verify Shop By Category Icon Search Results
    Given User visits etsy
    When  User clicks on "<link>" icon
    Then Response should be 200
    And  Response time should be less than 2 sec

    Examples:
      | link |
      | https://www.etsy.com/c/home-and-living?anchor_listing_id=493936536&ref=hp |
      | https://www.etsy.com/c/jewelry?anchor_listing_id=163869681&ref=hp |
      | https://www.etsy.com/c/clothing?anchor_listing_id=250703251&ref=hp |

  Scenario Outline:  Verify high in demand item search is working
    Given  User visits etsy
    When   User searches by "<highDemandItemName>"
    Then Response should be 200
    And  Response time should be less than 2 sec

    Examples:
      | highDemandItemName |
      | https://www.etsy.com/search?q=dog&ref=auto3&as_prefix=dog |
      | https://www.etsy.com/search?q=dolls&ref=auto1&as_prefix=doll |
      | https://www.etsy.com/search?q=baby                           |

