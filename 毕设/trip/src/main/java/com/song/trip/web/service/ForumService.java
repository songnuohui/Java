package com.song.trip.web.service;

import com.song.trip.web.domain.Forum;

import java.util.List;

public interface ForumService {
	/**
	 * 	查询所有帖子
	 */
	List<Forum> selectByExampleWithBLOBs();
}
