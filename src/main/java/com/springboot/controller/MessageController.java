package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.kafkaService.KafkaProducer;

@RestController
@RequestMapping(value = "/api/v1/kafka")
public class MessageController {
//http:localhost:8080/api/v1/kafka/publish?msg=hello
	@Autowired
	private KafkaProducer kafkaProducer;
	
//	public MessageController(KafkaProducer kafkaProducer) {
//		this.kafkaProducer = kafkaProducer;
//	}

	@GetMapping(value = "/publish")
	public ResponseEntity<String> publish(@RequestParam String msg){
		kafkaProducer.sendMessage(msg);
		return ResponseEntity.ok("Message sent to the topic.");
	}
}
