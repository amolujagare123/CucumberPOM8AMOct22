Feature: All bookings.com scenarios

# 1
  @starverify
  Scenario Outline: Verify user can only view the result by selected property class
    Given I am on default locations search result screen
    When I select option for stars as <stars>
    Then I verify system displays only <stars> hotels on search result
    Examples:
      | stars   |
      | 5 stars |
    #  | 4 stars |
    #  | 3 stars |


#2

  @DistList
  Scenario: List of all of hotel within 15 km radius from the center
     Given I am on default locations search result screen
    Then I verify system displays all hotels within "2" Km radius from beach


#3
  @hotelsSearch
  Scenario: verify given hotel is present in the list
    Given I am on default locations search result screen
    Then I verify "Vista Suites" is within the search result