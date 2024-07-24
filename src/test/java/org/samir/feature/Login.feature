@login
  Feature: Login

    @login @positive
      Scenario Outline: As a user I should be able to login with valid credential
        Given navigate to url "https://andreascandle.github.io/samir_test/qa_test_samir.html"
        When login as "valid_credential"
        Then  user tap button login and verify allert message success "<positiveLogin>"
        * user take screenshot full page with name "login_positive_001"

      Examples:
      |positiveLogin|
      |Login successful|

      @login @negative
        Scenario Outline: As a user I should not be able to login with invalid credential
          Given navigate to url "https://andreascandle.github.io/samir_test/qa_test_samir.html"
          When login as "invvalid_credential"
          Then  user tap button login and verify allert message error "<negativeLogin>"
          * user take screenshot full page with name "login_negative_001"

        Examples:
        |negativeLogin|
        |Invalid credentials|