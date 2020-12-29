package com.song.trip.web.controller;

import com.song.trip.web.commons.Msg;
import com.song.trip.web.dao.HotelDao;
import com.song.trip.web.domain.*;
import com.song.trip.web.domain.Hotel;
import com.song.trip.web.domain.HotelExample;
import com.song.trip.web.service.HotelService;
import com.song.trip.web.service.ViewPointService;
import com.song.trip.web.domain.Reply;
import com.song.trip.web.domain.Words;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "hotel")
public class HotelController {
	@Autowired
	private HotelDao hotelDao;
	@Autowired
	private ViewPointService viewPointService;
	@Autowired
	private HotelService hotelService;
	/**
	 * 跳转首页
	 */
	@RequestMapping(value = "index", method = RequestMethod.GET)
	public String index(@RequestParam(defaultValue = "1") Integer page, Model model) {
		//实例化hotel examle
		if (page<=0){
			page=1;
		}
		List<Hotel> hotels = hotelService.selectByPage(page, 6);
		Integer count = hotelService.count();
		model.addAttribute("page",page);
		model.addAttribute("total",(count/6)+1);
		String prefix = "/static/upload/hotelAvatar/";
		for (Hotel hotel : hotels) {
			//图片名
			String suffix = hotel.getImgUrl();
			//全路径
			hotel.setImgUrl(prefix + suffix);
		}
		//传送景点
		model.addAttribute("hotels", hotels);
		return "proscenium/hotel/index";
	}

	/**
	 * 跳转内容
	 */
	@RequestMapping(value = "content", method = RequestMethod.GET)
	public String content(Integer hid, Model model) {

		//封装留言信息
		List<Words> lw_list = viewPointService.findByWords();
		model.addAttribute("lw_list",lw_list);

		//封装回复信息
		List<Reply> lr_list = viewPointService.findByReply();
		model.addAttribute("lr_list",lr_list);

		Hotel hotel = hotelDao.selectByPrimaryKey(hid);
		String prefix = "/static/upload/hotelAvatar/";
		String suffix=hotel.getImgUrl();
		hotel.setImgUrl(prefix+suffix);
		model.addAttribute("hotel", hotel);

		return "proscenium/hotel/content";
	}

	/**
	 * 前台酒店模糊搜索
	 */
	@RequestMapping(value = "hotelPointSearch", method = RequestMethod.GET)
	public String hotelPointSearch(String keyword, Model model) {
		String prefix = "/static/upload/hotelAvatar/";

		Hotel hotel = new Hotel();
		hotel.setZip(keyword);
		hotel.setLocal(keyword);
		hotel.setHouseType(keyword);
		hotel.setBedType(keyword);

		List<Hotel> hotels = hotelDao.hotelPointSearch(hotel);

		for (Hotel hotelForEach : hotels){
			String imgUrl = hotelForEach.getImgUrl();
			hotelForEach.setImgUrl(prefix + imgUrl);
		}

		model.addAttribute("hotels", hotels);
		model.addAttribute("msg", Msg.success("酒店查询成功!"));

		return "proscenium/hotel/index";
	}


}
