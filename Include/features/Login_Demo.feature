# Author: your.email@your.domain.com
# Keywords Summary :
# Feature: List of scenarios.
# Scenario: Business rule through list of steps with arguments.
# Given: Some precondition step
# When: Some key actions
# Then: To observe outcomes or validation
# And,But: To enumerate more Given,When,Then steps
# Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
# Examples: Container for s table
# Background: List of steps run before each of the scenarios
# """ (Doc Strings)
# | (Data Tables)
# @ (Tags/Labels):To group Scenarios
# <> (placeholder)
# ""
# # (Comments)
# Sample Feature Definition Template
# Language: vi
@tag
Feature: Login

  @tag1
  Scenario: User login page success
    Given Người dùng đăng ký
    When User log with user and pass

 @tag2
  Scenario: User login page fail
    Given Người dùng đăng ký
    When User log with user and pass
    