package com.example.KafkaConcurrent.listener;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@EnableBinding(Events.class)
public class Consumer {

    @StreamListener(Events.STATE_CHANGE_TOPIC)
    public void receive(Message<?> message) throws InterruptedException {
        System.out.println("Time: " + Instant.now() + " Message: " + message.getPayload());
        try {
            Thread.sleep(10000);
            //new T1().start();
        } catch (Exception e) {
            // TODO: handle exception
        }
        /*Acknowledgment acknowledgment = message.getHeaders().get(KafkaHeaders.ACKNOWLEDGMENT, Acknowledgment.class);
        if (acknowledgment != null) {
            System.out.println("Acknowledgment provided");
            acknowledgment.acknowledge();
        }*/
    }
}


class T1 extends Thread {
    @Override
    public void run() {
        System.out.println("start");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("end");
    }
}