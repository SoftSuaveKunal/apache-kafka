package com.springboot.kafkaService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.springboot.dto.Users;

@Service
public class JsonKafkaConsumer {
	
	private static  Logger log = LoggerFactory.getLogger(JsonKafkaConsumer.class);
	
	@KafkaListener(topics = "JsonTopic1",groupId = "Kafka_group")
	public void consume(Users user) {
		log.info(String.format("Payload received-> %s", user.toString()));
	}
}
