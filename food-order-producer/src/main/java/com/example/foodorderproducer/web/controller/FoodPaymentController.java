package com.example.foodorderproducer.web.controller;

import com.example.foodorderproducer.domain.entity.FoodPayment;
import com.example.foodorderproducer.producer.FoodPaymentProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 02, December 2021
 * Time: 7:26 AM
 * Project: handling-exception
 * Package Name: com.example.foodorderproducer.web.controller
 * To change this template use File | Settings | File and Code Template
 */
@RestController
@RequestMapping("api/v1/foodpayment")
@RequiredArgsConstructor
public class FoodPaymentController {

    private final FoodPaymentProducer foodPaymentProducer;

    @PostMapping
    public ResponseEntity postFoodPayment(@RequestBody FoodPayment foodPayment) throws JsonProcessingException {
        foodPaymentProducer.sendFoodPayment(foodPayment);
        return new ResponseEntity(HttpStatus.CREATED);
    }
}
