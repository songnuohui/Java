package com.song.trip.web.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ViewShopCart implements Serializable {
    private Map<Integer,ViewItem> map= new HashMap<Integer, ViewItem>();
    public ViewShopCart(){}

    public ViewShopCart(Map<Integer, ViewItem> map) {
        this.map = map;
    }

    public Map<Integer, ViewItem> getMap() {
        return map;
    }

    public void setMap(Map<Integer, ViewItem> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "ViewShopCart{" +
                "map=" + map +
                '}';
    }
    /**
     * 所有景点的价格
     * **/
    public Double getTotlePrice(){
        Double totle=0.0;
        for (Map.Entry<Integer, ViewItem> en:map.entrySet()){
            ViewItem viewItem = en.getValue();
            totle=totle+viewItem.getSumPrice();
        }
        return totle;
    }
}
