package com.song.trip.web.service.impl;

import com.song.trip.web.dao.FoodDao;
import com.song.trip.web.domain.*;
import com.song.trip.web.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodDao foodDao;
    /**
     * 查询所有景点
     * **/
    @Override
    public List<Food> selectByExampleWithBLOBs(FoodExample example) {
        List<Food> foods = foodDao.selectByExampleWithBLOBs(example);
        return foods;
    }
    /**
     * 查询单个美食列表信息
     * **/
    @Override
    public Food selectByPrimaryKey(Integer tpFid) {
        Food food = foodDao.selectByPrimaryKey(tpFid);
        return food;
    }
    /**
     * 添加美食信息
     * **/
    @Override
    public void insert(Food food) {
        foodDao.insertSelective(food);
    }
    /**
     * 更新美食信息
     * **/
    @Override
    public void updateByPrimaryKeySelective(Food food) {
         foodDao.updateByPrimaryKeySelective(food);
    }
    /**
     * 单个删除美食信息
     */
    @Override
    public void deleteByPrimaryKey(Integer tpFid) {
        foodDao.deleteByPrimaryKey(tpFid);
    }
    /**
     * 美食模糊查询
     * **/
    @Override
    public List<Food> foodPointSearch(Food food) {
        List<Food> foods = foodDao.foodPointSearch(food);
        return foods;
    }
    /**
     * 查询四个美食信息
     * */
    @Override
    public List<Food> foodFourPoints(FoodExample foodExample) {
        List<Food> foodExamples = foodDao.foodFourPoints(foodExample);
        return foodExamples;
    }

    /**
     * 保存留言信息功能
     * @param words
     * @return
     */
    @Override
    public void saveWords(Words words) {
        foodDao.saveWords(words);
    }
    /**
     * 保存回复信息
     * @param reply
     */
    @Override
    public void saveReply(Reply reply) {
        foodDao.saveReply(reply);
    }
    /**
     * 查询所有留言信息
     * @return
     */
    @Override
    public List<Words> findByWords() {
        return foodDao.findByWords();
    }
    /**
     * 	查询所有回复信息
     */
    @Override
    public List<Reply> findByReply() {
        return foodDao.findByReply();
    }

}
