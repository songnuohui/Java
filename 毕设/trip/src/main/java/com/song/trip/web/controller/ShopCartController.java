package com.song.trip.web.controller;

import com.song.trip.web.dao.HotelDao;
import com.song.trip.web.domain.Food;
import com.song.trip.web.domain.Hotel;
import com.song.trip.web.domain.ViewPoint;
import com.song.trip.web.entity.*;
import com.song.trip.web.service.FoodService;
import com.song.trip.web.service.ViewPointService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping(value = "shop")
public class ShopCartController {
    @Autowired
    private ViewPointService viewPointService;
    @Autowired
    private HttpSession session;
    @Autowired
    private HotelDao hotelDao;
    @Autowired
    private FoodService foodService;
    /**
     * 跳转到购物车页面
     * **/
    @RequestMapping(value = "index",method = RequestMethod.GET)
    public String shopCartIndex(){

        return "/proscenium/shopcart/index";
    }

/************************景点购物车**************************/
    /**
     * 统计景点购物车
     * **/
    @RequestMapping(value = "viewcart",method = RequestMethod.GET)
    public String viewCart(Integer tpVid, HttpServletRequest request) {

        //System.out.println("取得id为"+tpVid);
            /**
             * 登录即创建购物车在session中
             * **/
        /**
         * 根据id获取到view对象
         * **/
            ViewPoint viewPoint = viewPointService.selectByPrimaryKey(tpVid);
            /**
             * 判断购物车中是否已经存在
             * **/
        ViewShopCart shopCart = (ViewShopCart) request.getSession().getAttribute("shopCart");
        boolean flag = shopCart.getMap().containsKey(tpVid);
            if (flag) {
                //如果存在，则对应的count++
                Map<Integer, ViewItem> map = shopCart.getMap();
                ViewItem viewItem = map.get(tpVid);
                //找到原来的对象再count+1
                viewItem.setViewCount(viewItem.getViewCount() + 1);
            } else {
                ViewItem viewItem = new ViewItem(viewPoint, 1);
                shopCart.getMap().put(tpVid, viewItem);
            }
        return "redirect:/view/point";
    }
    /**
     * 清空购物车
     * **/
    @RequestMapping(value = "deleteviewcart",method = RequestMethod.GET)
    public String deleteViewCart(HttpServletRequest request){
        ViewShopCart shopCart = (ViewShopCart) request.getSession().getAttribute("shopCart");
        if (shopCart!=null){
            shopCart.getMap().clear();
        }
        return "redirect:/shop/index";
    }

/************************酒店购物车**************************/

    @RequestMapping(value = "hotelcart",method = RequestMethod.GET)
    public String hotelCart(Integer hid,HttpServletRequest request){
        /**
         * 根据id获取到hotel对象
         * **/
        Hotel hotel = hotelDao.selectByPrimaryKey(hid);
        /**
         * 判断购物车中是否已经存在
         * **/
        HotelShopCart hotelShopCart = (HotelShopCart) request.getSession().getAttribute("hotelShopCart");
        boolean flag=hotelShopCart.getMap().containsKey(hid);
        if (flag){
            Map<Integer, HotelItem> map=hotelShopCart.getMap();
            HotelItem hotelItem = map.get(hid);
            hotelItem.setHtelCount(hotelItem.getHtelCount()+1);
        }else {
            HotelItem hotelItem=new HotelItem(hotel,1);
            hotelShopCart.getMap().put(hid,hotelItem);
        }
        return "redirect:/hotel/index";
    }
    /**
     * 清空购物车
     * **/
    @RequestMapping(value = "deletehotelcart",method = RequestMethod.GET)
    public String deleteHotelCart(HttpServletRequest request){
        HotelShopCart hotelShopCart = (HotelShopCart) request.getSession().getAttribute("hotelShopCart");
        if (hotelShopCart!=null){
            hotelShopCart.getMap().clear();
        }
        return "redirect:/shop/index";
    }


/************************美食购物车**************************/

    @RequestMapping(value = "foodcart",method = RequestMethod.GET)
    public String foodCart(Integer tpFid,HttpServletRequest request,Model model){
        /**
         * 根据id获取到food对象
         * **/
        Food food = foodService.selectByPrimaryKey(tpFid);
        /**
         * 判断购物车中是否已经存在
         * **/
        FoodShopCart foodShopCart = (FoodShopCart) request.getSession().getAttribute("foodShopCart");
        boolean flag=foodShopCart.getMap().containsKey(tpFid);
        if (flag){
            Map<Integer, FoodItem> map=foodShopCart.getMap();
            FoodItem foodItem = map.get(tpFid);
            foodItem.setFoodCount(foodItem.getFoodCount()+1);
        }else {
           FoodItem foodItem=new FoodItem(food,1);
           foodShopCart.getMap().put(tpFid,foodItem);
        }
       /* ViewShopCart shopCart = (ViewShopCart) request.getSession().getAttribute("shopCart");
        HotelShopCart hotelShopCart = (HotelShopCart) request.getSession().getAttribute("hotelShopCart");
        double totle=shopCart.getTotlePrice()+hotelShopCart.getTotlePrice()+foodShopCart.getTotlePrice();
        request.getSession().setAttribute("totle",totle);*/
        return "redirect:/food/index";
    }
    /**
     * 清空购物车
     * **/
    @RequestMapping(value = "deletefoodcart",method = RequestMethod.GET)
    public String deleteFoodCart(HttpServletRequest request){
        FoodShopCart foodShopCart = (FoodShopCart) request.getSession().getAttribute("foodShopCart");
        if (foodShopCart!=null){
            foodShopCart.getMap().clear();
        }
        return "redirect:/shop/index";
    }

    /**
     * 比较预算
     * */
    @RequestMapping(value="bijiao",method = RequestMethod.POST)
    public String bijiao(@RequestParam(defaultValue = "1") int yusuan, HttpServletRequest request){
        System.out.println("预算金额是否获取到："+yusuan);
        HttpSession session=request.getSession();
        session.setAttribute("yusuan",yusuan);
        int yusuan1 = (int) request.getSession().getAttribute("yusuan");
        System.out.println("预算金额是否获取到1："+yusuan1);
        return "redirect:/shop/index";
    }
}
