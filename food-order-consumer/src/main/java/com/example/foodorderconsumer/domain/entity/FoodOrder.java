package com.example.foodorderconsumer.domain.entity;

import lombok.*;

import java.util.Objects;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 02, December 2021
 * Time: 5:56 AM
 * Project: handling-exception
 * Package Name: com.example.foodorderconsumer.domain.entity
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FoodOrder {

    private String foodName;

    private String category;

    private int quantity;

    @Override
    public String toString() {
        return "FoodOrder{" +
                "foodName='" + foodName + '\'' +
                ", category='" + category + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FoodOrder foodOrder = (FoodOrder) o;
        return quantity == foodOrder.quantity && foodName.equals(foodOrder.foodName) && category.equals(foodOrder.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(foodName, category, quantity);
    }
}
