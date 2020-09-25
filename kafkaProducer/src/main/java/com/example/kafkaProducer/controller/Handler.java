package com.example.kafkaProducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.kafkaProducer.publisher.Producer;

import com.example.kafkaProducer.publisher.Producer;


@RestController
public class Handler {

    @Autowired
    Producer producer;
    
    @GetMapping("/publish")
    public void publish() {
        producer.publishMessages();
    }
}
