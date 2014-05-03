Feature:
  Scenario: to verify a message sent over gtalk
    Given Receiver is logged into Gmail as user "abc@gmail.com"
    And Sender is logged into Gmail as user "xyz@gmail.com"
    When Sender sends a ping
    Then Receiver should recieve it