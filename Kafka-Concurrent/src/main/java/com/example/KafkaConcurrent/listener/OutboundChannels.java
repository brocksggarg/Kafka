package com.example.KafkaConcurrent.listener;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.MessageChannel;

@Configuration
public class OutboundChannels {

  public static final String eventOut = "event_out";

  //@Output("shubhamout")
  //public MessageChannel publishMessageChannel() {

    //return new DirectChannel();
  //}
}
