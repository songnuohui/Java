package com.song.trip.web.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class FoodShopCart implements Serializable {
    Map<Integer,FoodItem> map=new HashMap<Integer, FoodItem>();
    public FoodShopCart(){}

    public FoodShopCart(Map<Integer, FoodItem> map) {
        this.map = map;
    }

    public Map<Integer, FoodItem> getMap() {
        return map;
    }

    public void setMap(Map<Integer, FoodItem> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "FoodShopCart{" +
                "map=" + map +
                '}';
    }
    /**
     * 所有景点的价格
     * **/
    public Double getTotlePrice(){
        Double totle=0.0;
        for (Map.Entry<Integer, FoodItem> en:map.entrySet()){
            FoodItem foodItem = en.getValue();
            totle=totle+foodItem.getSumPrice();
        }
        return totle;
    }
}
