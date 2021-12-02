package com.example.foodorderconsumer.error.handler;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.ConsumerAwareErrorHandler;
import org.springframework.stereotype.Service;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 02, December 2021
 * Time: 6:46 AM
 * Project: handling-exception
 * Package Name: com.example.foodorderconsumer.error.handler
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
public class GlobalErrorHandler implements ConsumerAwareErrorHandler {
    @Override
    public void handle(Exception exception, ConsumerRecord<?, ?> consumerRecord, Consumer<?, ?> consumer) {
        log.info("Error from Global error handler:{}", consumerRecord.value().toString());

    }
}
