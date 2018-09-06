package com.synesisit.springCloudStreamWithKafka.service;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import com.synesisit.springCloudStreamWithKafka.model.Greetings;
import com.synesisit.springCloudStreamWithKafka.stream.GreetingsStreams;

@Service
public class GreetingsService {

	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(GreetingsService.class);
    private final GreetingsStreams greetingsStreams;

    public GreetingsService(GreetingsStreams greetingsStreams) {

        this.greetingsStreams = greetingsStreams;

    }

    public void sendGreeting(final Greetings greetings) {

        log.info("Sending greetings {}", greetings);

        MessageChannel messageChannel = greetingsStreams.outboundGreetings();

        messageChannel.send(MessageBuilder

                .withPayload(greetings)

                .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON)

                .build());

    }
}
