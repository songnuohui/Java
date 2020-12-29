package com.song.trip.web.service;

import com.song.trip.web.domain.*;

import java.util.List;

public interface FoodService {
    /**
     * 查询所有美食信息
     * */
    List<Food> selectByExampleWithBLOBs(FoodExample example);
    /**
     * 查询单个美食列表信息
     * **/
    Food selectByPrimaryKey(Integer tpFid);
    /**
     * 添加美食信息
     * **/
    void insert(Food food);
    /**
     * 更新美食信息
     * **/
    void updateByPrimaryKeySelective(Food food);
    /**
     * 单个删除美食信息
     */
    void deleteByPrimaryKey(Integer tpFid);
    /**
     * 美食模糊查询
     * **/
    List<Food> foodPointSearch(Food food);
    /**
     * 查询四个美食信息
     * */
    List<Food> foodFourPoints(FoodExample foodExample);
    /**
     * 保存留言
     * @param words
     * @return
     */
    void saveWords(Words words);

    /**
     * 保存回复信息
     * @param reply
     */
    void saveReply(Reply reply);

    /**
     * 查询所有留言信息
     * @return
     */
    List<Words> findByWords();

    /**
     * 	查询所有回复信息
     */
    List<Reply> findByReply();
}
