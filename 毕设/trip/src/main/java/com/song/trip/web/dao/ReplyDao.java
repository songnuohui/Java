package com.song.trip.web.dao;

import org.springframework.stereotype.Repository;

@Repository
public interface ReplyDao {
	void deleteByPrimaryKey(Integer lr_id);
}
