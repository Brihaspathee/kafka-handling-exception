package com.example.foodorderproducer.producer;

import com.example.foodorderproducer.domain.entity.FoodOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 02, December 2021
 * Time: 5:42 AM
 * Project: handling-exception
 * Package Name: com.example.foodorderproducer.producer
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class FoodOrderProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final ObjectMapper objectMapper;

    public void sendOrder(FoodOrder foodOrder) throws JsonProcessingException {
        String foodOrderAsString = objectMapper.writeValueAsString(foodOrder);
        kafkaTemplate.send("t.food.order", foodOrder.getCategory(), foodOrderAsString);
    }
}
