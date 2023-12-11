package com.dailycodebuffer.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

@Controller
public class GreetingController {
	  private final SimpMessagingTemplate messagingTemplate;

	    public GreetingController(SimpMessagingTemplate messagingTemplate) {
	        this.messagingTemplate = messagingTemplate;
	    }

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greet(HelloMessage message) throws InterruptedException {
        Thread.sleep(1000);
        // Send the initial greeting
        Greeting initialGreeting = new Greeting("Hello, " + "I am Bot. How can I help you? " +
                HtmlUtils.htmlEscape(message.getName()));
        messagingTemplate.convertAndSendToUser(message.getName(), "/topic/greetings", initialGreeting);
        return initialGreeting;
    }
    public void broadcastMessage(String message) {
        // Logic to broadcast the message to WebSocket clients
        // You can use SimpMessagingTemplate for this purpose
        messagingTemplate.convertAndSend("/topic/greetings", new Greeting(message));
    }
    
}
