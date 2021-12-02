package com.example.foodorderconsumer.consumer;

import com.example.foodorderconsumer.domain.entity.FoodPayment;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 02, December 2021
 * Time: 6:51 AM
 * Project: handling-exception
 * Package Name: com.example.foodorderconsumer.consumer
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class FoodPaymentConsumer {

    private final ObjectMapper objectMapper;

    private static final int MIN_PAYMENT_AMOUNT = 5;

    @KafkaListener(topics = "t.food.payment")
    public void consumeFoodPayment(String foodPayment) throws JsonProcessingException {

        FoodPayment payment = objectMapper.readValue(foodPayment, FoodPayment.class);

        if(payment.getPaymentAmount() < MIN_PAYMENT_AMOUNT){
            throw new IllegalArgumentException("Payment amount is less than 5 dollars");
        }
        log.info("Food Payment is {}", payment);

    }
}
