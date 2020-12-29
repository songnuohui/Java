package com.song.trip.web.service;

import com.song.trip.web.domain.Admin;

import java.util.List;

public interface AdminService {
	Admin login(String eamil, String pwd);

	List<Admin> selectAll();
}
