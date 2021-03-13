package com.example.KafkaConcurrent.resource;

import com.example.KafkaConcurrent.domain.Event;
import com.example.KafkaConcurrent.listener.PublisherImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class EventResource {

  @Autowired PublisherImpl publisher;

  @PostMapping("/publish")
  public Mono<Boolean> publishMessage(@RequestBody Event event) throws InterruptedException {
    return publisher.publishMessage(event);
  }
}
