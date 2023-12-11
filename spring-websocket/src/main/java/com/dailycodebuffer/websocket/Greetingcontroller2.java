package com.dailycodebuffer.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Greetingcontroller2 {

	@Autowired
	GreetingController controller;
	
	 @PostMapping("/send-message")
	    public void sendMessage(@RequestBody String message) {
	        // Handle the REST API logic to process the message
	        // You can use this logic to send a message to WebSocket clients
	        // For simplicity, you can directly broadcast the message to the WebSocket topic
	        // (This might not be suitable for a production scenario)
		 controller.broadcastMessage(message);
	    }
}
