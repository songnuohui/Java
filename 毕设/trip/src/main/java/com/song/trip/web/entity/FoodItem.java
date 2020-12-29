package com.song.trip.web.entity;

import com.song.trip.web.domain.Food;

import java.io.Serializable;

public class FoodItem implements Serializable {
    private Food food;
    private Integer foodCount;
    public FoodItem(){}

    public FoodItem(Food food, Integer foodCount) {
        this.food = food;
        this.foodCount = foodCount;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Integer getFoodCount() {
        return foodCount;
    }

    public void setFoodCount(Integer foodCount) {
        this.foodCount = foodCount;
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "food=" + food +
                ", foodCount=" + foodCount +
                '}';
    }
    /**
     * 获得当前项的总价
     * **/
    public Double getSumPrice(){
        double sum=foodCount*food.getTpFprice();
        return sum;
    }
}
