package com.song.trip.web.service.impl;

import com.song.trip.web.dao.ForumDao;
import com.song.trip.web.domain.Forum;
import com.song.trip.web.domain.ForumExample;
import com.song.trip.web.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForumServiceImpl implements ForumService {
	@Autowired
	ForumDao forumDao;

	@Override
	public List<Forum> selectByExampleWithBLOBs() {
		ForumExample example = new ForumExample();
		example.setOrderByClause("tp_fid desc");
		List<Forum> forums = forumDao.selectByExample(example);
		return forums;
	}
}
