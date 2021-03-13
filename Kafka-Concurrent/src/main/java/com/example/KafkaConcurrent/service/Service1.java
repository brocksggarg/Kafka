package com.example.KafkaConcurrent.service;

import org.springframework.retry.annotation.Retryable;

public interface Service1 {

    @Retryable(value = Exception.class, maxAttempts = 1)
    public void consume(String message);
}
