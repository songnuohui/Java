package com.song.trip.web.service.impl;

import com.song.trip.web.dao.HotelDao;
import com.song.trip.web.domain.Hotel;
import com.song.trip.web.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelDao hotelDao;
    @Override
    public List<Hotel> selectByPage(Integer page, Integer size) {
        page=(page-1)*6;
        List<Hotel> hotels = hotelDao.selectByPage(page, size);
        return hotels;
    }

    @Override
    public Integer count() {
        Integer count = hotelDao.count();
        return count;
    }
}
