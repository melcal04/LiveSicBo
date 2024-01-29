@UserInterface
Feature: User Interface

  Background:
    Given I Go To Mobile Site
    And I Login An Account

  @UserInterfaceTest1
  Scenario: UI Test 1: Checking The Thumbnail Of Live Sic Bo Revamp
    When I Go To Live Casino
    Then I Verify The Thumbnail Of Game

  @UserInterfaceTest2
  Scenario: UI Test 2: Launching Of Live Sic Bo Revamp
    When I Go To Live Casino
    And I Join Live Sic Bo Revamp
    Then I Verify The Launching Of Game

  @UserInterfaceTest3
  Scenario: UI Test 3: Checking The UI Of Live Sic Bo Revamp Lobby
    When I Go To Live Casino
    And I Join Live Sic Bo Revamp
    Then I Verify The Game Lobby

  @UserInterfaceTest4
  Scenario: UI Test 4: Checking The UI Of Live Sic Bo Revamp During Betting Phase
    When I Go To Live Casino
    And I Join Live Sic Bo Revamp
    And I Enter The Dealer Table
    Then I Verify The UI Of Game During Betting Phase

  @UserInterfaceTest5
  Scenario: UI Test 5: Checking The UI Of Live Sic Bo Revamp During Dealing Phase
    When I Go To Live Casino
    And I Join Live Sic Bo Revamp
    And I Enter The Dealer Table
    Then I Verify The UI Of Game During Dealing Phase

  @UserInterfaceTest6
  Scenario: UI Test 6: Checking The Mapping Of Live Sic Bo Betting Options
    When I Go To Live Casino
    And I Join Live Sic Bo Revamp
    And I Enter The Dealer Table
    Then I Verify The Mapping Of Betting Options