package com.shubham.garg.KafkaConcepts.listener;


import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Events.class)
public class Consumer {

    @StreamListener(Events.STATE_CHANGE_TOPIC)
    public void receive(Message<?> message) throws InterruptedException {
        System.out.println(message.getPayload());
        try {
            //Thread.sleep(2000);
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
