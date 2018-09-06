package com.synesisit.springCloudStreamWithKafka;

import org.springframework.cloud.stream.annotation.EnableBinding;

import com.synesisit.springCloudStreamWithKafka.stream.GreetingsStreams;

@EnableBinding(GreetingsStreams.class)
public class StreamsConfig {

}
