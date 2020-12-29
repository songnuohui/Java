package com.song.trip.web.controller;

import com.song.trip.web.commons.Msg;
import com.song.trip.web.dao.ViewPointDao;
import com.song.trip.web.domain.*;
import com.song.trip.web.service.ViewPointService;
import com.song.trip.web.domain.Reply;
import com.song.trip.web.domain.ViewPoint;
import com.song.trip.web.domain.ViewPointExample;
import com.song.trip.web.domain.Words;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "view")
public class ViewPointController {
	@Autowired
	private ViewPointService viewPointService;

	private HttpSession session;
	@Autowired
	private ViewPointExample viewPointExample;
	@Autowired
	private ViewPointDao viewPointDao;

	/**
	 * 旅游景点跳转
	 * @return
	 */
	@RequestMapping(value = "point", method = RequestMethod.GET)
	public String viewPoint(@RequestParam(defaultValue = "1") Integer page, Model model) {
		if (page<=0){
			page=1;
		}
		String prefix = "/static/upload/viewavatar/";
		List<ViewPoint> viewPoints = viewPointService.selectByPage(page, 8);
		Integer count = viewPointService.count();			//查询总条数
		model.addAttribute("page",page);
		model.addAttribute("total",(count/8)+1);
		//System.out.println(page+"/"+count);
		for (ViewPoint viewPoint : viewPoints){
			String suffix = viewPoint.getTpVpic();
			//前端img标签路径
			viewPoint.setTpVpic(prefix+suffix);
		}
		model.addAttribute("viewPoints", viewPoints);
		return "proscenium/viewpoint/view";
	}


	/**
	 * 景点内容 跳转
	 */
	@RequestMapping(value = "content", method = RequestMethod.GET)
	public String viewContent(Integer tpVid, Model model) {
		//封装留言信息
		List<Words> lw_list = viewPointService.findByWords();
		model.addAttribute("lw_list",lw_list);

		//封装回复信息
		List<Reply> lr_list = viewPointService.findByReply();
		model.addAttribute("lr_list",lr_list);

		ViewPoint viewPoint = viewPointService.selectByPrimaryKey(tpVid);
		String prefix = "/static/upload/viewavatar/";
		String suffix=viewPoint.getTpVpic();
		viewPoint.setTpVpic(prefix+suffix);
		model.addAttribute("viewPoint", viewPoint);
		return "proscenium/viewpoint/content";
	}

	/**
	 * 前台景点模糊搜索
	 */
	@RequestMapping(value = "viewPointSearch", method = RequestMethod.GET)
	public String viewPointSearch(String keyword, Model model) {
		String prefix = "/static/upload/viewavatar/";

		ViewPoint viewPoint = new ViewPoint();
		viewPoint.setTpVname(keyword);
		viewPoint.setTpVtype(keyword);
		viewPoint.setTpLocation(keyword);
		List<ViewPoint> viewPoints = viewPointDao.viewPointSearch(viewPoint);

		for (ViewPoint vp : viewPoints){
			String imgUrl = vp.getTpVpic();
			vp.setTpVpic(prefix + imgUrl);
		}

		model.addAttribute("viewPoints", viewPoints);
		model.addAttribute("msg", Msg.success("景点查询成功!"));

		return "proscenium/viewpoint/view";
	}


}
