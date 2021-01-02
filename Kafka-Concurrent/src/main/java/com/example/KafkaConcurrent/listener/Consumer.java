package com.example.KafkaConcurrent.listener;


import com.example.KafkaConcurrent.service.Service1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@EnableBinding(Events.class)
public class Consumer {

    @Autowired
    private Service1 service1;

    @StreamListener(Events.STATE_CHANGE_TOPIC)
    public void receive(Message<?> message) {
        System.out.println("Time: " + Instant.now() + " Message: " + message.getPayload());
        service1.consume(message.getPayload().toString());

        /*Acknowledgment acknowledgment = message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
        if (acknowledgment != null) {
            System.out.println("Acknowledgment provided");
            acknowledgment.acknowledge();
        }*/
    }

}

