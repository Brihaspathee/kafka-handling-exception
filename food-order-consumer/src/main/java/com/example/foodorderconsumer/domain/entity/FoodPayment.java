package com.example.foodorderconsumer.domain.entity;

import lombok.*;

import java.util.Objects;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 02, December 2021
 * Time: 6:49 AM
 * Project: handling-exception
 * Package Name: com.example.foodorderconsumer.domain.entity
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodPayment {

    private String foodName;

    private double paymentAmount;

    @Override
    public String toString() {
        return "FoodPayment{" +
                "foodName='" + foodName + '\'' +
                ", paymentAmount=" + paymentAmount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodPayment that = (FoodPayment) o;
        return Double.compare(that.paymentAmount, paymentAmount) == 0 && foodName.equals(that.foodName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foodName, paymentAmount);
    }
}
