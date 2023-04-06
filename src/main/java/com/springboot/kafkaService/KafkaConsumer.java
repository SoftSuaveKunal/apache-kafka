package com.springboot.kafkaService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
@Service
public class KafkaConsumer {

	private static  Logger log = LoggerFactory.getLogger(KafkaConsumer.class);
	
	@KafkaListener (topics = "AK" ,groupId = "group_id")
	public void consume(String message) {
		log.info(String.format("Message received-> %s", message));
	}
}
