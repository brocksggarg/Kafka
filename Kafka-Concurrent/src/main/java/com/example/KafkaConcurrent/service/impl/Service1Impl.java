package com.example.KafkaConcurrent.service.impl;

import com.example.KafkaConcurrent.service.Service1;
import org.springframework.stereotype.Service;

@Service
public class Service1Impl implements Service1 {

    @Override
    public void consume(String message) {
        System.out.println("Processing: " + message);
        try {
            Thread.sleep(2000);
            //new T1().start();
        } catch (Exception e) {
            // TODO: handle exception
        }
        if (message.contains("akaran")) {
            int a = 10 / 0;
        }
    }
}
