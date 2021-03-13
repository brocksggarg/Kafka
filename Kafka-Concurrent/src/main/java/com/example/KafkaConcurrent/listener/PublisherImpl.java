package com.example.KafkaConcurrent.listener;

import com.example.KafkaConcurrent.domain.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@EnableBinding({OutboundChannels.class, Events.class})
public class PublisherImpl {

  @Autowired
  @Qualifier(Events.SHUBHAM_OUT)
  private MessageChannel messageChannel;

  // @Autowired
  // @Qualifier(Events.SHUBHAM_OUT2)
  // private MessageChannel messageChannel2;

  public Mono<Boolean> publishMessage(Event event) throws InterruptedException {
    Message<Event> message = MessageBuilder.withPayload(event).build();
    return Mono.just(event)
        .flatMap(
            event1 -> {
              System.out.println("Publishing");
              return Mono.just(messageChannel.send(message));
            })
        .doOnSuccess(
            response -> {
              System.out.println("Published sucessfully");
            })
        .onErrorResume(
            error -> {
              System.out.println("received error while publishing: " + error);
              return Mono.just(Boolean.FALSE);
            });
  }
}
