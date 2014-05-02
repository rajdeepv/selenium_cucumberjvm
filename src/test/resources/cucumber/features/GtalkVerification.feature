Feature:
  Scenario: to verify a message sent over gtalk
    And Receiver is logged into Gmail as user "receiver@gmail.com"
    Given Sender is logged into Gmail as user "sender@gmail.com"
    When Sender sends a ping
    Then Receiver should recieve it