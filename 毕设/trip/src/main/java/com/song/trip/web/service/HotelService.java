package com.song.trip.web.service;

import com.song.trip.web.domain.Hotel;

import java.util.List;

public interface HotelService {
    /**
     * 分页查询
     * */
    List<Hotel> selectByPage(Integer page,Integer size);
    Integer count();
}
