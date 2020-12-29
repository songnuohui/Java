package com.song.trip.web.controller;

import com.song.trip.web.commons.Msg;
import com.song.trip.web.commons.TimeStampUtil;
import com.song.trip.web.dao.*;
import com.song.trip.web.domain.*;
import com.song.trip.web.service.AdminService;
import com.song.trip.web.service.FoodService;
import com.song.trip.web.service.UserService;
import com.song.trip.web.service.ViewPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	@Autowired
	private UserService userService;
	@Autowired
	private HttpSession session;
	@Autowired
	private ViewPointService viewPointService;
	@Autowired
	private HotelDao hotelDao;
	@Autowired
	private ViewPointDao viewPointDao;
	@Autowired
	private ForumDao forumDao;
	@Autowired
	private WordsDao wordsDao;
	@Autowired
	private ReplyDao replyDao;
	@Autowired
	private FoodDao foodDao;
	@Autowired
	private FoodService foodService;

	/**
	 * **********login start***************
	 * 从前端跳转到后台登录
	 */
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		return "admin/login";
	}

	/**
	 * 登录逻辑
	 * handle
	 *
	 * @param aemail 用户邮箱
	 * @param apwd   密码
	 * @return String
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	// @RequestParam(required = true) 为true时意思为不可缺省
	public String login(String aemail, String apwd, HttpSession session,HttpServletRequest httpServletRequest) {
		Admin admin = adminService.login(aemail, apwd);
		String timestamp = TimeStampUtil.getTimeFormat();

		//登录失败
		if (admin == null) {
			session.setAttribute("msg", Msg.fail("邮箱或者密码错误!"));
			return login();
		}
		//登录成功
		else {

			// 将登录信息放入session
			session.setAttribute("msg", Msg.success());
			session.setAttribute("timestamp", timestamp);
			//将admin对象放入会话中
			httpServletRequest.getSession().setAttribute("admin", admin);
			// 明日任务,获取域对象传送user信息
			//Admin attribute = (Admin) httpServletRequest.getSession().getAttribute("admin");
			/*System.out.println("看是否存入到session中"+attribute);*/
			return "redirect:main";
		}
	}

	/**
	 * 后台注销
	 */
	@RequestMapping(value = "loginout", method = RequestMethod.GET)
	public String loginOut(HttpSession session) {
		//销毁session
		session.invalidate();
		return login();
	}
	//**********login end***************

	/**
	 * **********main start***************
	 * 登录成功后跳转管理主界面
	 *
	 * @return
	 */
	@RequestMapping(value = "main", method = RequestMethod.GET)
	public String main() {
		return "admin/main";
	}
	//**********main end***************


	/**********user start***************
	 * 查看用户列表
	 */
	@RequestMapping(value = "userlist", method = RequestMethod.GET)
	public String userList() {
		String prefix = "/static/upload/useravatar/";
		List<User> users = userService.selectAll();
		for (User user : users) {
			String suffix = user.getUpic();
			user.setUpic(prefix + suffix);
		}
		session.setAttribute("users", users);
		return "admin/user_list";
	}

	/**
	 * 用户模糊搜索
	 */
	@RequestMapping(value = "usersearch", method = RequestMethod.GET)
	public String userSearch(String keyword, HttpSession session) {
		System.out.println(keyword);
		String prefix = "/static/upload/useravatar/";
		List<User> users = userService.search(keyword);
		for (User user : users){
			String imgUrl = user.getUpic();
			user.setUpic(prefix + imgUrl);
		}
		session.setAttribute("users", users);
		session.setAttribute("msg", Msg.success("用户查询成功!"));

		return "admin/user_list";
	}

	/**
	 * 景点模糊搜索
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

		return "admin/view_list";
	}

	/**
	 * 后台酒店模糊搜索
	 */
	@RequestMapping(value = "hotelPointSearch", method = RequestMethod.GET)
	public String hotelPointSearch(String keyword, Model model) {
		String prefix = "/static/upload/hotelAvatar/";

		Hotel hotel = new Hotel();
		hotel.setZip(keyword);
		hotel.setLocal(keyword);
		hotel.setHouseType(keyword);
		hotel.setBedType(keyword);

		List<Hotel> hotels = hotelDao.hotelPointSearch(hotel);

		for (Hotel hotelForEach : hotels){
			String imgUrl = hotelForEach.getImgUrl();
			hotelForEach.setImgUrl(prefix + imgUrl);
		}

		model.addAttribute("hotels", hotels);
		model.addAttribute("msg", Msg.success("酒店查询成功!"));

		return "admin/hotel_list";
	}

	/**
	 * 后台论坛模糊搜索
	 */
	@RequestMapping(value = "forumPointSearch", method = RequestMethod.GET)
	public String forumPointSearch(String keyword, Model model) {

		Forum forum = new Forum();

		forum.setTpTag(keyword);
		forum.setTpTitle(keyword);
		forum.setTpSubTitle(keyword);
		forum.setTpAuthor(keyword);

		List<Forum> forums = forumDao.forumPointSearch(forum);

		model.addAttribute("forums", forums);
		model.addAttribute("msg", Msg.success("论坛查询成功!"));

		return "admin/forum_list";
	}



	/**
	 * 用户单个单击删除
	 */
	@RequestMapping(value = "userdelete", method = RequestMethod.GET)
	public String userDelete(String uid) {
		System.out.println(uid);
		String prefix = "/static/upload/useravatar/";
		userService.userDelete(uid);
		List<User> users = userService.selectAll();
		for (User user : users){
			String imgUrl = user.getUpic();
			user.setUpic(prefix + imgUrl);
		}
		session.setAttribute("users", users);
		session.setAttribute("msg", Msg.success(uid + "号用户删除成功!"));
		return "admin/user_list";
	}

	/**
	 * 用户新增表单跳转
	 */
	@RequestMapping(value = "userform", method = RequestMethod.GET)
	public String userForm() {
		return "admin/user_form";
	}

	/**
	 * 用户新增
	 */
	@RequestMapping(value = "userinsert", method = RequestMethod.POST)
	public String userInsert(String uname, String uemail, String upwd) {
		userService.insertUser(uname, uemail, upwd);
		session.setAttribute("msg", Msg.success("新增用户成功"));
		return "redirect:/admin/userlist";
	}

	/**
	 * 用户批量删除功能
	 */
	@RequestMapping(value = "usersectiondelete", method = RequestMethod.GET)
	@ResponseBody//返回给前端
	public String userSectionDelete(String[] uids) {
		for (String uid : uids) {
			userService.userDelete(uid);
		}
		session.setAttribute("msg", Msg.success(Arrays.toString(uids) + "号用户批量删除成功!"));
		return "1";
	}

	/**
	 * 跳转用户编辑更新界面
	 */
	@RequestMapping(value = "useredit", method = RequestMethod.GET)
	public String userEdit(String uid) {
		User user = userService.userGet(uid);
		System.out.println(user);
		session.setAttribute("user", user);

		return "admin/user_edit";
	}

	/**
	 * 跳转用户更新业务
	 */
	@RequestMapping(value = "useredithandle", method = RequestMethod.POST)
	public String userEditHandle(User user) {
		userService.updataUserInfo(user);
		session.setAttribute("msg", Msg.success("用户信息保存成功!"));
		return "redirect:/admin/userlist";
	}
	//**********user end***************


	/************view start***************
	 * 跳转内容管理 景点列表
	 */
	@RequestMapping(value = "viewlist", method = RequestMethod.GET)
	public String viewPoint(ViewPointExample example, Model model, HttpServletRequest request) {
		example.setOrderByClause("tp_vid desc");
		String prefix = "/static/upload/viewavatar/";
		List<ViewPoint> viewPoints = viewPointService.selectByExample(example);
		for (ViewPoint viewPoint : viewPoints) {
			String suffix = viewPoint.getTpVpic();
			//前端img标签路径
			viewPoint.setTpVpic(prefix + suffix);
		}
		//存储信息转发
		model.addAttribute("viewPoints", viewPoints);
		return "admin/view_list";
	}

	/**
	 * 景点批量删除功能
	 */
	@RequestMapping(value = "viewsectiondelete", method = RequestMethod.GET)
	@ResponseBody//返回给前端
	public String viewSectionDelete(Integer[] tpVids) {
		for (Integer tpVid : tpVids) {
			viewPointService.deleteviews(tpVid);
		}
		session.setAttribute("msg", Msg.success(Arrays.toString(tpVids) + "号景点批量删除成功!"));
		return "1";
	}

	/**
	 * 景点查看
	 */
	@RequestMapping(value = "viewcontent", method = RequestMethod.GET)
	public String viewcontent(Integer tpVid, Model model) {
		ViewPoint viewPoint = viewPointService.selectByPrimaryKey(tpVid);
		String prefix = "/static/upload/viewavatar/";
		String suffix = viewPoint.getTpVpic();
		//前端img标签路径
		viewPoint.setTpVpic(prefix + suffix);
		model.addAttribute("viewPoint", viewPoint);
		return "admin/view_content";
	}

	/**
	 * 景点单个单击删除
	 */
	@RequestMapping(value = "viewdelete", method = RequestMethod.GET)
	public String viewDelete(Integer tpVid) {
		viewPointService.deleteviews(tpVid);

		session.setAttribute("msg", Msg.success(tpVid + "号用户删除成功!"));
		return "redirect:/admin/viewlist";
	}

	/**
	 * 景点新增表单跳转
	 */
	@RequestMapping(value = "viewform", method = RequestMethod.GET)
	public String viewForm() {
		return "admin/view_form";
	}

	/**
	 * 景点新增
	 */
	@RequestMapping(value = "viewinsert", method = RequestMethod.POST)
	public String viewInsert(ViewPoint viewPoint) {
		if (viewPoint.getTpVid() == null) {
			viewPoint.setTpCreattime(new Date());
			viewPointService.insertView(viewPoint);
			session.setAttribute("msg", Msg.success("新增景点成功!"));
			return "redirect:/admin/viewlist";
		}
		session.setAttribute("msg", Msg.fail("新增景点失败!"));
		return "redirect:/admin/viewlist";
	}


	/**
	 * 跳转景点编辑更新界面
	 */
	@RequestMapping(value = "viewedit", method = RequestMethod.GET)
	public String viewEdit(Integer tpVid, Model model) {
		ViewPoint viewPoint = viewPointService.selectByPrimaryKey(tpVid);
		model.addAttribute("viewPoint", viewPoint);
		return "admin/view_edit";
	}

	/**
	 * 跳转景点更新业务
	 */
	@RequestMapping(value = "viewedithandle", method = RequestMethod.POST)
	public String viewEditHandle(ViewPoint viewPoint,Model model) {
		viewPointService.updateByPrimaryKeySelective(viewPoint);
		model.addAttribute("msg", Msg.success("景点信息保存成功!"));
		return "redirect:/admin/viewlist";
	}

	//**********view end***************

	/*************hotel ************
	 * 跳转
	 * 酒店管理列表
	 */
	@RequestMapping(value = "hotellist", method = RequestMethod.GET)
	public String hotelList(Model model) {
		HotelExample example = new HotelExample();
		String prefix = "/static/upload/hotelAvatar/";

		example.setOrderByClause("hid desc");
		List<Hotel> hotels = hotelDao.selectByExample(example);
		for (Hotel hotel : hotels) {
			String suffix = hotel.getImgUrl();
			//前端img标签路径
			hotel.setImgUrl(prefix + suffix);
		}
		model.addAttribute("hotels", hotels);

		return "admin/hotel_list";
	}

	/**
	 * 跳转
	 * 酒店管理列表
	 */
	@RequestMapping(value = "hotelcontent", method = RequestMethod.GET)
	public String hotelContent(Integer hid, Model model) {

		Hotel hotel = hotelDao.selectByPrimaryKey(hid);
		String prefix = "/static/upload/hotelAvatar/";
		String suffix = hotel.getImgUrl();
		//前端img标签路径
		hotel.setImgUrl(prefix + suffix);

		model.addAttribute("hotel", hotel);

		return "admin/hotel_content";
	}

	/**
	 * 跳转
	 * 酒店编辑
	 */
	@RequestMapping(value = "hoteledit", method = RequestMethod.GET)
	public String hotelEdit(Integer hid, Model model) {

		Hotel hotel = hotelDao.selectByPrimaryKey(hid);

		model.addAttribute("hotel", hotel);
		return "admin/hotel_edit";
	}

	/**
	 * 跳转酒店新业务
	 */
	@RequestMapping(value = "hoteledithandle", method = RequestMethod.POST)
	public String hotelEditHandle(Hotel hotel) {
		hotelDao.updateByPrimaryKeySelective(hotel);
		session.setAttribute("msg", Msg.success("酒店信息保存成功!"));
		return "redirect:/admin/hotellist";
	}

	/**
	 * 酒店单个删除
	 */
	@RequestMapping(value = "hoteldelete", method = RequestMethod.GET)
	public String hotelDelete(Integer hid) {
		hotelDao.deleteByPrimaryKey(hid);
		session.setAttribute("msg", Msg.success("删除酒店成功!"));
		return "redirect:/admin/hotellist";
	}

	/**
	 * 酒店
	 * 批量删除
	 */

	@RequestMapping(value = "hotelMutiDelete", method = RequestMethod.GET)
	@ResponseBody//返回给前端
	public String hotelMutiDelete(Integer[] hids) {
		for (Integer hid : hids) {
			hotelDao.deleteByPrimaryKey(hid);
		}
		session.setAttribute("msg", Msg.success(Arrays.toString(hids) + "号景点批量删除成功!"));
		return "1";
	}

	/**
	 * 酒店
	 * 新增表单跳转
	 */
	@RequestMapping(value = "hotelInsertForm", method = RequestMethod.GET)
	public String hotelInsertForm() {
		return "admin/hotel_insert";
	}

	/**
	 * 酒店新增
	 */
	@RequestMapping(value = "hotelInsert", method = RequestMethod.POST)
	public String hotelInsert(Hotel hotel, Model model) {
		if (hotel.getHid() == null) {
			hotel.setCreated(new Date());
			hotelDao.insertSelective(hotel);
			model.addAttribute("msg", Msg.success("新增景点成功!"));
			return "redirect:/admin/hotellist";
		}
		model.addAttribute("msg", Msg.fail("新增景点失败!"));
		return "redirect:/admin/hoteledit";
	}

	/**
	 * content
	 */
	@RequestMapping(value = "forumList", method = RequestMethod.GET)
	public String forumList(Model model) {
		ForumExample example = new ForumExample();
		example.setOrderByClause("tp_fid desc");

		List<Forum> forums = forumDao.selectByExample(example);

		model.addAttribute("forums", forums);

		return "admin/forum_list";
	}

	/**
	 *
	 * @param tpFids
	 * @param model
	 * @return
	 */
	@ResponseBody//返回给前端
	@RequestMapping(value = "forumMutiDelete", method = RequestMethod.GET)
	public String forumMutiDelete(Integer[] tpFids, Model model) {
		for (Integer tpFid : tpFids) {
			forumDao.deleteByPrimaryKey(tpFid);
		}
		session.setAttribute("msg", Msg.success(Arrays.toString(tpFids) + "号批量删除成功!"));
		return "1";
	}

	/**
	 * forummutidelete
	 */
	@RequestMapping(value = "forumDelete", method = RequestMethod.GET)
	public String forumDelete(Integer tpFid, Model model) {
		forumDao.deleteByPrimaryKey(tpFid);
		model.addAttribute("msg", Msg.success(tpFid + "号批量删除成功!"));
		return "redirect:/admin/forumList";
	}

	/**
	 * 酒店
	 * 新增表单跳转
	 */
	@RequestMapping(value = "forumInsertForm", method = RequestMethod.GET)
	public String forumInsertForm() {
		return "admin/forum_insert";
	}

	/**
	 * 帖子新增
	 */
	@RequestMapping(value = "forumInsert", method = RequestMethod.POST)
	public String forumInsert(Forum forum, Model model) {
		if (forum.getTpFid() == null) {
			forumDao.insert(forum);
			model.addAttribute("msg", Msg.success("新帖子成功!"));
			return "redirect:/admin/forumList";
		}
		model.addAttribute("msg", Msg.fail("新增帖子失败!"));
		return "redirect:/admin/forumList";
	}

	/**
	 * 论坛新增
	 */
	@RequestMapping(value = "forumEditForm", method = RequestMethod.GET)
	public String forumEditForm(Integer tpFid, Model model) {
		Forum forum = forumDao.selectByPrimaryKey(tpFid);
		model.addAttribute("forum", forum);
		return "admin/forum_edit";
	}

	/**
	 * 论坛更新
	 */
	@RequestMapping(value = "forumEdit", method = RequestMethod.POST)
	public String forumEdit(Forum forum, Model model) {
		forumDao.updateByPrimaryKeySelective(forum);
		model.addAttribute("msg", Msg.success("更新成功!"));
		return "redirect:/admin/forumList";
	}

	/**
	 * 跳转评论列表
	 * @return
	 */
	@RequestMapping(value = "wordsList", method = RequestMethod.GET)
	public String wordsList(Model model) {
		List<Words> byWords = viewPointService.findByWords();
		model.addAttribute("byWords", byWords);
		return "admin/words_list";
	}

	/**
	 * 留言批量删除
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "wordsMutiDelete", method = RequestMethod.GET)
	public String wordsMutiDelete(Integer[] lw_ids, Model model) {

		for (Integer lw_id : lw_ids){
			wordsDao.deleteByPrimaryKey(lw_id);

		}
		model.addAttribute("msg", Msg.success(Arrays.toString(lw_ids) + "号删除成功！"));
		return "1";
	}

	/**
	 * 单击删除
	 * @return
	 */
	@RequestMapping(value = "wordsDelete", method = RequestMethod.GET)
	public String wordsDelete(Integer lw_id, Model model) {
		wordsDao.deleteByPrimaryKey(lw_id);
		model.addAttribute("msg", Msg.success(lw_id + "号删除成功！"));
		return "redirect:/admin/wordsList";
	}

	/**
	 * 跳转回复列表
	 * @return
	 */
	@RequestMapping(value = "replyList", method = RequestMethod.GET)
	public String ReplyList(Model model) {
		List<Reply> replys = viewPointService.findByReply();
		model.addAttribute("replys", replys);
		return "admin/reply_list";
	}

	/**
	 * 回复批量删除
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "replyMutiDelete", method = RequestMethod.GET)
	public String replyMutiDelete(Integer[] lr_ids, Model model) {
		for (Integer lr_id : lr_ids){
			replyDao.deleteByPrimaryKey(lr_id);

		}
		model.addAttribute("msg", Msg.success(Arrays.toString(lr_ids) + "号删除成功！"));
		return "1";
	}

	/**
	 * 单击删除
	 * @return
	 */
	@RequestMapping(value = "replyDelete", method = RequestMethod.GET)
	public String replyDelete(Integer lr_id, Model model) {
		replyDao.deleteByPrimaryKey(lr_id);
		model.addAttribute("msg", Msg.success(lr_id + "号删除成功！"));
		return "redirect:/admin/replyList";
	}

	//****************Food Start****************
	/**
	 *美食列表信息查询
	 * */
	@RequestMapping(value = "foodlist",method = RequestMethod.GET)
	public String foodList(FoodExample foodExample,Model model){
		String prefix = "/static/upload/foodAvatar/";
		List<Food> foods = foodService.selectByExampleWithBLOBs(foodExample);
		for (Food food:foods) {
			String suffix = food.getTpFpic();
			//前端img标签路径
			food.setTpFpic(prefix + suffix);
		}
		model.addAttribute("foods",foods);
		return "admin/food_list";
	}

	/**
	 * 单个美食详情列表展示
	 * **/
	@RequestMapping(value = "foodcontent",method = RequestMethod.GET)
	public String foodContent(Integer tpFid,Model model){
		Food food = foodService.selectByPrimaryKey(tpFid);
		String prefix= "/static/upload/foodAvatar/";
		String suffix = food.getTpFpic();
		food.setTpFpic(prefix + suffix);
		model.addAttribute("food",food);
		return "admin/food_content";
	}
	/**
	 * 美食
	 * 新增表单跳转
	 */
	@RequestMapping(value = "foodInsertForm", method = RequestMethod.GET)
	public String foodInsertForm() {
		return "admin/food_insert";
	}

	/**
	 * 美食新增
	 */
	@RequestMapping(value = "foodInsert", method = RequestMethod.POST)
	public String foodInsert(Food food, Model model) {
		if (food.getTpFid() == null) {
			food.setTpFcreated(new Date());
			foodService.insert(food);
			model.addAttribute("msg", Msg.success("新增美食成功!"));
			return "redirect:/admin/foodlist";
		}
		model.addAttribute("msg", Msg.fail("新增景点失败!"));
		return "redirect:/admin/foodedit";
	}

	/**
	 * 美食更新，先查询出单个美食信息，跳转到美食编辑页面
	 */
	@RequestMapping(value = "foodedit",method = RequestMethod.GET)
	public String foodEdit(Integer tpFid,Model model){
		Food food = foodService.selectByPrimaryKey(tpFid);
		model.addAttribute("food",food);
		return "admin/food_edit";
	}
	/**
	 * 美食更新，对美食进行更新
	 */
	@RequestMapping(value = "foodupdate",method =RequestMethod.POST )
	public String foodUpdate(Food food,Model model){
		foodService.updateByPrimaryKeySelective(food);
		model.addAttribute("msg" ,Msg.success("更新美食成功！"));
		return "redirect:/admin/foodlist";
	}
	/**
	 * 单个删除美食信息
	 */
	@RequestMapping(value = "fooddelete",method = RequestMethod.GET)
	public String foodDelete(Integer tpFid,Model model){
		foodService.deleteByPrimaryKey(tpFid);
		model.addAttribute("msg",Msg.success("删除成功！"));
		return "redirect:/admin/foodlist";
	}

	/**
	 * 美食批量删除
	 */
	@RequestMapping(value = "foodsdelete", method = RequestMethod.GET)
	@ResponseBody//返回给前端
	public String foodsDelete(Integer[] tpFids) {
		for (Integer tpFid : tpFids) {
			foodService.deleteByPrimaryKey(tpFid);
		}
		session.setAttribute("msg", Msg.success(Arrays.toString(tpFids) + "号景点批量删除成功!"));
		return "1";
	}
	/**
	 * 后台美食模糊搜索
	 */
	@RequestMapping(value = "foodPointSearch", method = RequestMethod.GET)
	public String foodPointSearch(String keyword, Model model) {
		String prefix = "/static/upload/foodAvatar/";

		Food food=new Food();

		food.setTpFtitle(keyword);
		food.setTpFname(keyword);
		food.setTpAddress(keyword);

		List<Food> foods = foodService.foodPointSearch(food);

		for (Food foodForEach:foods){
			String imgUrl = foodForEach.getTpFpic();
			foodForEach.setTpFpic(prefix + imgUrl);
		}

		model.addAttribute("foods", foods);
		model.addAttribute("msg", Msg.success("美食查询成功!"));

		return "admin/food_list";
	}
}