Feature: Check the all links in page

  Scenario: Validate growth engineering Functinality
    Given User open growth engineering url
    Then user is on home page
    Then validate url of this page
    And click on the Get In Touch
    Then user is on contact page and Test Contact page
    When we can create new user
    Then validate newly created user
