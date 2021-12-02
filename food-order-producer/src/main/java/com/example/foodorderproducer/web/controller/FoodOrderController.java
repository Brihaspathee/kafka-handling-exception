package com.example.foodorderproducer.web.controller;

import com.example.foodorderproducer.domain.entity.FoodOrder;
import com.example.foodorderproducer.producer.FoodOrderProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 02, December 2021
 * Time: 5:48 AM
 * Project: handling-exception
 * Package Name: com.example.foodorderproducer.web.controller
 * To change this template use File | Settings | File and Code Template
 */
@RestController
@RequestMapping("/api/v1/foodorder")
@RequiredArgsConstructor
public class FoodOrderController {

    private final FoodOrderProducer foodOrderProducer;

    @PostMapping
    public ResponseEntity createFoodOrder(@RequestBody FoodOrder foodOrder) throws JsonProcessingException {

        /**
         * chicken = 3
         * fish = 10
         * pizza = 5
         */
        foodOrderProducer.sendOrder(foodOrder);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
