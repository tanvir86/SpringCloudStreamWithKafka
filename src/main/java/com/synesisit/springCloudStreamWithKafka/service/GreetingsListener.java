package com.synesisit.springCloudStreamWithKafka.service;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.synesisit.springCloudStreamWithKafka.model.Greetings;
import com.synesisit.springCloudStreamWithKafka.stream.GreetingsStreams;

@Component
public class GreetingsListener {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(GreetingsListener.class);
	
    @StreamListener(GreetingsStreams.INPUT)
    public void handleGreetings(Message<Greetings> message) {//@Payload Greetings greetings
    	
        log.info("Received greetings: {}",message.getPayload());

        Acknowledgment acknowledgment = message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
        
        if (acknowledgment != null) {
            log.info("Acknowledgment provided");
            acknowledgment.acknowledge();
        }
    }
}
