package com.song.trip.web.controller;

import com.song.trip.web.dao.HotelDao;
import com.song.trip.web.domain.*;
import com.song.trip.web.service.FoodService;
import com.song.trip.web.service.ViewPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "")
public class IndexController {
	@Autowired
	private ViewPointService viewPointService;
	@Autowired
	private HotelDao hotelDao;
	@Autowired
	private FoodService foodService;
	/**
	 * 跳转首页
	 */
	@RequestMapping(value = {"", "index"}, method = RequestMethod.GET)
	public String index(ViewPoint viewPoint, FoodExample foodExample, Model model) {
		HotelExample hotelExample = new HotelExample();
		//显示首页的景点
		String prefix = "/static/upload/viewavatar/";

		//景点显示前四条信息
		String prefixHotel = "/static/upload/hotelAvatar/";
		String prefixFood = "/static/upload/foodAvatar/";
		/*example.setOrderByClause("tp_vid desc");*/
		List<ViewPoint> viewPoints = viewPointService.selectFourViews(viewPoint);
		for (ViewPoint viewFourPoint : viewPoints) {
			String suffix = viewFourPoint.getTpVpic();
			viewFourPoint.setTpVpic(prefix + suffix);
		}

		//酒店显示前三条
		/*hotelExample.setOrderByClause("hid desc");*/
		List<Hotel> hotels = hotelDao.selectTwoHotels(hotelExample);
		for (Hotel hotel : hotels) {
			String suffix = hotel.getImgUrl();
			hotel.setImgUrl(prefixHotel + suffix);
		}
		//美食显示四条信息
		List<Food> foods = foodService.foodFourPoints(foodExample);
		for (Food food:foods) {
			String suffix=food.getTpFpic();
			food.setTpFpic(prefixFood+suffix);
		}
		//传送景点
		model.addAttribute("viewPoints", viewPoints);
		model.addAttribute("hotels", hotels);
		model.addAttribute("foods",foods);
		return "index";
	}

}
