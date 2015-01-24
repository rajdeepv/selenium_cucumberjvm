Feature:
  In Order to chat with my friends over gtalk inside Gmail
  As a user
  I should be able to send a messages successfully


  @multiuser
  Scenario: chat message sent over gtalk  inside Gmail
    Given Receiver is logged into Gmail as user "test.rajdeep1@gmail.com"
    And Sender is logged into Gmail as user "test.rajdeep2@gmail.com"
    When Sender sends a ping
    Then Receiver should recieve it