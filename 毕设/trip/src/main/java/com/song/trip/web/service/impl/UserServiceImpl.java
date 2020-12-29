package com.song.trip.web.service.impl;

import com.song.trip.web.dao.UserDao;
import com.song.trip.web.domain.User;
import com.song.trip.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public void insertUser(String uname, String uemail, String upwd) {
		userDao.insertUser(new User(uname, uemail, upwd));
	}

	@Override
	public List<User> selectAll() {
		return userDao.selectAll();
	}

	@Override
	public List<User> search(String keyword) {
		User user = new User();
		user.setUid(keyword);
		user.setUname(keyword);
		user.setUemail(keyword);
		return userDao.search(user);
	}

	@Override
	public void userDelete(String uid) {
		userDao.userDelete(uid);
	}

	@Override
	public User userLogin(User user) {
		User loginUser = userDao.userLogin(user);
		return loginUser;
	}

	@Override
	public User userGet(String uid) {
		User user = userDao.userGet(uid);
		return user;
	}

	@Override
	public void updataUserInfo(User user) {
		userDao.updataUserInfo(user);
	}
}
