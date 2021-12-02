package com.example.foodorderconsumer.consumer;

import com.example.foodorderconsumer.domain.entity.FoodOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.query.criteria.internal.expression.function.AggregationFunction;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 02, December 2021
 * Time: 5:58 AM
 * Project: handling-exception
 * Package Name: com.example.foodorderconsumer.consumer
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class FoodOrderConsumer {

    private final ObjectMapper objectMapper;

    private static final int MAX_AMOUNT_ORDER = 7;

    @KafkaListener(topics = "t.food.order", errorHandler = "myFoodOrderErrorHandler")
    public void consumeFoodOrder(String foodOrder) throws JsonProcessingException {
        FoodOrder food = objectMapper.readValue(foodOrder, FoodOrder.class);
        if(food.getQuantity() > MAX_AMOUNT_ORDER){
            throw new IllegalArgumentException("Food Order amount is too many");
        }
        log.info("Food Order is valid: {}", foodOrder);
    }
}
