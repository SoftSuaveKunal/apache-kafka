package com.springboot.kafkaService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import com.springboot.dto.Users;
@Service
public class JsonKafkaProducer {

	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);
	
	@Autowired
	KafkaTemplate<String, Users> kafkaTemplate;
	
	public void sendMessage(Users data) {
		LOGGER.info(String.format("JSON Message sent -> %s", data.toString()));
		Message<Users> message = MessageBuilder.withPayload(data).setHeader(KafkaHeaders.TOPIC,"JsonTopic1").build();
		kafkaTemplate.send(message);
	}
}
