package com.synesisit.springCloudStreamWithKafka.service;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.synesisit.springCloudStreamWithKafka.model.Greetings;
import com.synesisit.springCloudStreamWithKafka.stream.GreetingsStreams;

@Component
public class GreetingsListener {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(GreetingsListener.class);
	
    @StreamListener(GreetingsStreams.INPUT)
    public void handleGreetings(@Payload Greetings greetings) {

        log.info("Received greetings: {}", greetings);

    }
}
