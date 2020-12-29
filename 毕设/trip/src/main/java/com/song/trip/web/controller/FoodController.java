package com.song.trip.web.controller;

import com.song.trip.web.domain.*;
import com.song.trip.web.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "food")
public class FoodController {
    @Autowired
    private FoodService foodService;
    /**
     * 美食信息前台展示
     * **/
    @RequestMapping(value = "index",method= RequestMethod.GET)
    public String index(FoodExample foodExample, Model model){
        String prefixFood = "/static/upload/foodAvatar/";
        List<Food> foods = foodService.selectByExampleWithBLOBs(foodExample);
        for (Food food:foods) {
            String suffix=food.getTpFpic();
            food.setTpFpic(prefixFood+suffix);
        }
        model.addAttribute("foods",foods);
        return "proscenium/food/index";
    }
    /**
     * 美食信息前台模糊搜索
     * **/
    @RequestMapping(value = "foodPointSearch",method = RequestMethod.GET)
    public String foodPointSearch(String keyword, Model model){
        String prefix = "/static/upload/foodAvatar/";

        Food food=new Food();

        food.setTpFtitle(keyword);
        food.setTpFname(keyword);
        food.setTpAddress(keyword);

        List<Food> foods = foodService.foodPointSearch(food);

        for (Food foodForEach:foods){
            String imgUrl = foodForEach.getTpFpic();
            foodForEach.setTpFpic(prefix + imgUrl);
        }
        model.addAttribute("foods", foods);
        return "proscenium/food/index";
    }

    @RequestMapping(value = "content",method = RequestMethod.GET)
    public String content(Integer tpFid,Model model){
        //封装留言信息
        List<Words> lw_list = foodService.findByWords();
        model.addAttribute("lw_list",lw_list);

        //封装回复信息
        List<Reply> lr_list = foodService.findByReply();
        model.addAttribute("lr_list",lr_list);

        Food food = foodService.selectByPrimaryKey(tpFid);
        String prefixFood = "/static/upload/foodAvatar/";
        String suffix=food.getTpFpic();
        food.setTpFpic(prefixFood+suffix);
        model.addAttribute("food", food);
        return "proscenium/food/content";
    }
}
