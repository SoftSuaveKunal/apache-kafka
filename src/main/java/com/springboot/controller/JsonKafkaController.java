package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.dto.Users;
import com.springboot.kafkaService.JsonKafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka/json")
public class JsonKafkaController {
	@Autowired
	JsonKafkaProducer jsonKafkaProducer;

	@PostMapping(value = "/publish")
	public ResponseEntity<String> publish(@RequestBody Users user) {
		jsonKafkaProducer.sendMessage(user);
		return ResponseEntity.ok("Json message sent to kafka topic.");

	}
}