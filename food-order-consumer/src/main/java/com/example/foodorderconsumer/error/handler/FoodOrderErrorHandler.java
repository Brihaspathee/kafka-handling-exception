package com.example.foodorderconsumer.error.handler;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.Consumer;
import org.springframework.kafka.listener.ConsumerAwareListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 02, December 2021
 * Time: 6:14 AM
 * Project: handling-exception
 * Package Name: com.example.foodorderconsumer.error.handler
 * To change this template use File | Settings | File and Code Template
 */
@Service(value = "myFoodOrderErrorHandler")
@Slf4j
public class FoodOrderErrorHandler implements ConsumerAwareListenerErrorHandler {
    @Override
    public Object handleError(Message<?> message, ListenerExecutionFailedException exception, Consumer<?, ?> consumer) {
        log.info("Food order error. pretending to send to elasticsearch:{}, because :{}",
                message.getPayload(), exception.getMessage());
        if(exception.getCause() instanceof RuntimeException){
            throw exception;
        }
        return null;
    }
}
