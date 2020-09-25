package com.example.kafkaProducer.publisher;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@EnableBinding(Events.class)
public class Producer {

    @Autowired
    Events events;

    /*@SendTo(Events.STATE_CHANGE_TOPIC)
    public Message<?> reRoute(int i) {
        Map<String, Object> props = new HashMap<String, Object>();
        // props.put(KafkaHeaders.MESSAGE_KEY, "shubham");
        MessageHeaders messageHeaders = new MessageHeaders(props);
        return MessageBuilder.createMessage("Message" + i, messageHeaders);
    }*/

    public void publishMessages() {
        for (int i = 0; i < 100; i++) {
            Map<String, Object> props = new HashMap<String, Object>();
            props.put(KafkaHeaders.MESSAGE_KEY, "shubham");
            MessageHeaders messageHeaders = new MessageHeaders(props);
            events.outputChannel().send(
                    MessageBuilder.fromMessage(MessageBuilder.createMessage("Message" + i, messageHeaders)).build());
        }
    }
}
