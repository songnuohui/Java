package com.song.trip.web.controller;

import com.song.trip.web.service.UserService;
import com.song.trip.web.service.ViewPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 文件上传控制器
 */
@RequestMapping(value = "upload")
@Controller
public class UploadController {
	@Autowired
	private UserService userService;
	@Autowired
	private ViewPointService viewPointService;

	/**
	 * 文件上传
	 * @param dropFile
	 * @param request
	 * @return
	 */
	@ResponseBody//异步上传，返回json格式
	@RequestMapping(value = "viewAvatar", method = RequestMethod.POST)
	public Map<String, Object> viewAvatar(MultipartFile dropFile, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();
		//文件存放路径
		//String filePath = "/static/upload/viewavatar";
		//获取文件后缀
		String fileName = dropFile.getOriginalFilename();
		String fileSuffix = fileName.substring(fileName.lastIndexOf("."));
		//文件存放路径
		String filePath = request.getSession().getServletContext().getRealPath("/static/upload/viewavatar");
		File file = new File(filePath);
		//判断文件是否存在
		if (!file.exists()){
			file.mkdir();
		}
		//将文件写入目标
		file = new File(filePath,UUID.randomUUID() + fileSuffix);
		try {
			dropFile.transferTo(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		result.put("fileName",file.getName());
		return result;
	}

	@ResponseBody
	@RequestMapping(value = "useravatar", method = RequestMethod.POST)
	public Map<String, Object> userAvatar(MultipartFile dropFile, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();
		//文件存放路径
		String filePath = "/static/upload/useravatar/";
		//获取文件后缀
		String fileName = dropFile.getOriginalFilename();
		String fileSuffix = fileName.substring(fileName.lastIndexOf('.'));
		//文件存放路径
		String realPath = request.getSession().getServletContext().getRealPath(filePath);
		File file = new File(realPath);
		//判断文件是否存在
		if (!file.exists()){
			file.mkdir();
		}
		file = new File(realPath,UUID.randomUUID() + fileSuffix);
		try {
			dropFile.transferTo(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		result.put("fileName",file.getName());
		return result;
	}

	/**
	 * 后台内容图片上传
	 * @param dropFile
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "viewContentUpload", method = RequestMethod.POST)
	public Map<String, Object> viewContentUpload(MultipartFile dropFile, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();
		//前缀路径 Scheme服务端提供的协议 getServerName服务器名称 port 端口
		//String server = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();

		//图片显示路径
		String prefix = "/static/upload/contentFile/";

		//获取文件后缀
		String fileName = dropFile.getOriginalFilename();
		String fileSuffix = fileName.substring(fileName.lastIndexOf('.'));

		//文件存放路径
		String realPath = request.getSession().getServletContext().getRealPath(prefix);

		File file = new File(realPath);
		//判断文件是否存在
		if (!file.exists()){
			file.mkdir();
		}
		file = new File(realPath, UUID.randomUUID() + fileSuffix);
		try {
			dropFile.transferTo(file);

		} catch (IOException e) {
			e.printStackTrace();
		}
		//传到前端
		result.put("errno",0);
		result.put("data",new String[] {prefix + file.getName()});
		return result;
	}

	/**
	 * 文件上传
	 * @param dropFile
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "hotelAvatar", method = RequestMethod.POST)
	public Map<String, Object> hotelAvatar(MultipartFile dropFile, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();
		//文件存放路径
		String filePath = "/static/upload/hotelAvatar/";
		//获取文件后缀
		String fileName = dropFile.getOriginalFilename();
		String fileSuffix = fileName.substring(fileName.lastIndexOf('.'));
		//文件存放路径
		String realPath = request.getSession().getServletContext().getRealPath(filePath);
		File file = new File(realPath);
		//判断文件是否存在
		if (!file.exists()){
			file.mkdir();
		}
		file = new File(realPath,UUID.randomUUID() + fileSuffix);
		try {
			dropFile.transferTo(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		result.put("fileName",file.getName());
		return result;
	}

	/**
	 * 后台内容图片上传
	 * @param dropFile
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "hotelContentUpload", method = RequestMethod.POST)
	public Map<String, Object> hotelContentUpload(MultipartFile dropFile, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();
		//前缀路径 Scheme服务端提供的协议 getServerName服务器名称 port 端口
		//String server = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();

		//图片显示路径
		String prefix = "/static/upload/hotelFile/";

		//获取文件后缀
		String fileName = dropFile.getOriginalFilename();
		String fileSuffix = fileName.substring(fileName.lastIndexOf('.'));

		//文件存放路径
		String realPath = request.getSession().getServletContext().getRealPath(prefix);

		File file = new File(realPath);
		//判断文件是否存在
		if (!file.exists()){
			file.mkdir();
		}
		file = new File(realPath, UUID.randomUUID() + fileSuffix);
		try {
			dropFile.transferTo(file);

		} catch (IOException e) {
			e.printStackTrace();
		}
		//传到前端
		result.put("errno",0);
		result.put("data",new String[] {prefix + file.getName()});
		return result;
	}

	/**
	 * 后台内容图片上传
	 * @param dropFile
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "fourmContentUpload", method = RequestMethod.POST)
	public Map<String, Object> fourmContentUpload(MultipartFile dropFile, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();
		//前缀路径 Scheme服务端提供的协议 getServerName服务器名称 port 端口
		//String server = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();

		//图片显示路径
		String prefix = "/static/upload/forumFile/";

		//获取文件后缀
		String fileName = dropFile.getOriginalFilename();
		String fileSuffix = fileName.substring(fileName.lastIndexOf('.'));

		//文件存放路径
		String realPath = request.getSession().getServletContext().getRealPath(prefix);

		File file = new File(realPath);
		//判断文件是否存在
		if (!file.exists()){
			file.mkdir();
		}
		file = new File(realPath, UUID.randomUUID() + fileSuffix);
		try {
			dropFile.transferTo(file);

		} catch (IOException e) {
			e.printStackTrace();
		}
		//传到前端
		result.put("errno",0);
		result.put("data",new String[] {prefix + file.getName()});
		return result;
	}

/********************美食图片文件上传***********************/
	/**
	 * 文件上传
	 * @param dropFile
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "foodAvatar", method = RequestMethod.POST)
	public Map<String, Object> foodAvatar(MultipartFile dropFile, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();
		//文件存放路径
		String filePath = "/static/upload/foodAvatar/";
		//获取文件后缀
		String fileName = dropFile.getOriginalFilename();
		System.out.println(fileName);
		String fileSuffix = fileName.substring(fileName.lastIndexOf('.'));
		//文件存放路径
		String realPath = request.getSession().getServletContext().getRealPath(filePath);
		System.out.println(realPath);
		File file = new File(realPath);
		//判断文件是否存在
		if (!file.exists()){
			file.mkdir();
		}
		file = new File(realPath,UUID.randomUUID() + fileSuffix);
		try {
			dropFile.transferTo(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		result.put("fileName",file.getName());
		return result;
	}

	/**
	 * 后台内容图片上传
	 * @param dropFile
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "foodContentUpload", method = RequestMethod.POST)
	public Map<String, Object> foodContentUpload(MultipartFile dropFile, HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>();
		//前缀路径 Scheme服务端提供的协议 getServerName服务器名称 port 端口
		//String server = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();

		//图片显示路径
		String prefix = "/static/upload/foodFile/";

		//获取文件后缀
		String fileName = dropFile.getOriginalFilename();
		String fileSuffix = fileName.substring(fileName.lastIndexOf('.'));

		//文件存放路径
		String realPath = request.getSession().getServletContext().getRealPath(prefix);

		File file = new File(realPath);
		//判断文件是否存在
		if (!file.exists()){
			file.mkdir();
		}
		file = new File(realPath, UUID.randomUUID() + fileSuffix);
		try {
			dropFile.transferTo(file);

		} catch (IOException e) {
			e.printStackTrace();
		}
		//传到前端
		result.put("errno",0);
		result.put("data",new String[] {prefix + file.getName()});
		return result;
	}


}
