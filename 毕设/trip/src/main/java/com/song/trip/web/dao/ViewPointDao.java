package com.song.trip.web.dao;

import com.song.trip.web.domain.Reply;
import com.song.trip.web.domain.ViewPoint;
import com.song.trip.web.domain.ViewPointExample;
import com.song.trip.web.domain.Words;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ViewPointDao {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_viewpoint
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer tpVid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_viewpoint
     *
     * @mbg.generated
     */
    int insert(ViewPoint record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_viewpoint
     *
     * @mbg.generated
     */
    int insertSelective(ViewPoint record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_viewpoint
     *
     * @mbg.generated
     */

    List<ViewPoint> selectByExampleWithBLOBs(ViewPointExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_viewpoint
     *
     * @mbg.generated
     */
    List<ViewPoint> selectByExample(ViewPointExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_viewpoint
     *
     * @mbg.generated
     */
    ViewPoint selectByPrimaryKey(Integer tpVid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_viewpoint
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(ViewPoint record);

    /**
     * 模糊搜索
     */
    List<ViewPoint> viewPointSearch(ViewPoint viewPoint);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_viewpoint
     *
     * @mbg.generated
     */
    int updateByPrimaryKeyWithBLOBs(ViewPoint record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tp_viewpoint
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ViewPoint record);

    /**
     * 显示前四条信息
     * **/
    List<ViewPoint> selectFourViews(ViewPoint example);
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


    List<ViewPoint> selectByPage(@Param("page") Integer page,@Param("size") Integer size);


    Integer count();

}