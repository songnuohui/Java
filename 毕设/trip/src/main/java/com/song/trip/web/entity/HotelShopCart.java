package com.song.trip.web.entity;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class HotelShopCart implements Serializable {
    Map<Integer, HotelItem> map=new HashMap<Integer, HotelItem>();
    public HotelShopCart(){}

    public HotelShopCart(Map<Integer, HotelItem> map) {
        this.map = map;
    }

    public Map<Integer, HotelItem> getMap() {
        return map;
    }

    public void setMap(Map<Integer, HotelItem> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "HotelShopCart{" +
                "map=" + map +
                '}';
    }
    /**
     * 所有景点的价格
     * **/
    public Double getTotlePrice(){
        Double totle=0.0;
        for (Map.Entry<Integer, HotelItem> en:map.entrySet()){
            HotelItem hotelItem = en.getValue();
            totle=totle+hotelItem.getSumPrice();
        }
        return totle;
    }
}
