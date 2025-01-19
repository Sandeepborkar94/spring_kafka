package com.springboot.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.kafka.JsonKafkaProducer;
import com.springboot.payload.User;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController
{
	private JsonKafkaProducer kafkaProducer;

	public JsonMessageController(JsonKafkaProducer jsonKafkaProducer) 
	{
		super();
		this.kafkaProducer = jsonKafkaProducer;
	}
	
	@PostMapping("/publish")
	public ResponseEntity<String> publish(@RequestBody User user)
	{
		kafkaProducer.sendMessage(user);
		
		return ResponseEntity.ok("JSON Message sent to kafka topic");
	}
	
	
}
