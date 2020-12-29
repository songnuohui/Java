package com.song.trip.web.entity;

import com.song.trip.web.domain.Hotel;

import java.io.Serializable;

public class HotelItem implements Serializable {
    private Hotel hotel;
    private Integer htelCount;
    public HotelItem(){}

    public HotelItem(Hotel hotel, Integer htelCount) {
        this.hotel = hotel;
        this.htelCount = htelCount;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Integer getHtelCount() {
        return htelCount;
    }

    public void setHtelCount(Integer htelCount) {
        this.htelCount = htelCount;
    }

    @Override
    public String toString() {
        return "HotelItem{" +
                "hotel=" + hotel +
                ", htelCount=" + htelCount +
                '}';
    }
    /**
     * 获得当前项的总价
     * **/
    public Double getSumPrice(){
        double sum=htelCount*hotel.getPrice();
        return sum;
    }
}
