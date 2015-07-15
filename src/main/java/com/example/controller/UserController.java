package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.example.condition.UserQueryCondition;
import com.example.constants.RoleConstant;
import com.example.exception.BusinessException;
import com.example.itf.UserService;
import com.example.page.PageResult;
import com.example.util.JsonUtil;
import com.example.util.MD5;
import com.example.vo.UserVO;

/**
 * 
 * @author sdyang
 * @date 2015年7月1日 下午5:08:31
 */
@Transactional
@Controller
@RequestMapping("/finc")
public class UserController {

	@Resource
	UserService userService;

	/**
	 * 
	 * @author sdyang
	 * @date 2015年7月1日 下午5:20:50
	 * @return
	 */
	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public String getUserList() {

		return "/user/user_list";

	}

	/**
	 * 
	 * @author sdyang
	 * @date 2015年7月1日 下午5:20:53
	 * @return
	 */
	@RequestMapping(value = "/userAdd", method = RequestMethod.GET)
	public String getUserAdd() {

		return "/user/user_add";

	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public @ResponseBody
	String saveUser(@RequestParam("loginid") String loginid,
			@RequestParam("name") String name,
			@RequestParam("password") String password,
			@RequestParam("access") String access) throws BusinessException {

		UserVO user = new UserVO();
		user.setLoginid(loginid);
		user.setPassword(MD5.sign(password));

		user.setName(name);

		user.setAccess(Integer.parseInt(access));

		String loginId = userService.addUser(user);

		return loginId;

	}

	@RequestMapping(value = "/userDetail", method = RequestMethod.GET)
	public ModelAndView getUserDetail(@RequestParam("pk_user") String id)
			throws NumberFormatException, BusinessException {

		UserVO user = userService.getUserById(Integer.parseInt(id));
		ModelAndView view = new ModelAndView();

		view.addObject("pk_user", user.getPk_user());
		view.addObject("loginid", user.getLoginid());
		view.addObject("name", user.getName());
		view.addObject("access", RoleConstant.ACCESS.get(user.getAccess()));
		view.addObject("creatime", user.getCreatime());
		view.setViewName("user/user_detail");

		return view;

	}

	/**
	 * 
	 * @author sdyang
	 * @date 2015年7月1日 下午5:20:59
	 * @return
	 * @throws BusinessException
	 * @throws NumberFormatException
	 */
	@RequestMapping(value = "/userEdit", method = RequestMethod.GET)
	public ModelAndView getUserEdit(@RequestParam("pk_user") String pk_user)
			throws NumberFormatException, BusinessException {

		UserVO user = userService.getUserById(Integer.parseInt(pk_user));
		ModelAndView view = new ModelAndView();

		view.addObject("pk_user", user.getPk_user());
		view.addObject("loginid", user.getLoginid());
		view.addObject("name", user.getName());
		view.addObject("access", user.getAccess());
		view.addObject("creatime", user.getCreatime());
		view.setViewName("user/user_edit");

		return view;

	}

	/**
	 * 
	 * @author sdyang
	 * @date 2015年7月2日 下午5:31:24
	 * @param page
	 * @param rows
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws BusinessException
	 */
	@RequestMapping(value = "/userPage", method = RequestMethod.POST)
	public void getPage(@RequestParam("page") Integer page,
			@RequestParam("rows") Integer rows,
			@RequestParam("beginTime") String beginTime,
			@RequestParam("endTime") String endTime,
			@RequestParam("access") String access, HttpServletRequest request,
			HttpServletResponse response) throws IOException, BusinessException {

		PageResult result = new PageResult();

		UserQueryCondition params = new UserQueryCondition();
		params.setCurrentPage(page);
		params.setRows(rows);
		params.calculateOffset();
		params.setAccess(access);
		params.setBeginTime(beginTime);
		params.setEndTime(endTime);
		params.setDr("0");
		List<UserVO> users = userService.getUsers(params);

		result.setTotal(userService.getUserCount());
		result.setRows(users);

		String obj = JsonUtil.getInstance().toJson(result);

		request.setAttribute("result", obj);
		PrintWriter pw = response.getWriter();
		pw.write(obj);
		pw.flush();
		pw.close();

	}

	@RequestMapping(value = "/updateUser", method = RequestMethod.POST)
	public @ResponseBody
	String updateUser(@RequestParam("pk_user") Integer pk_user,
			@RequestParam("loginid") String loginid,
			@RequestParam("name") String name,
			@RequestParam("access") String access) throws BusinessException {

		UserVO user = new UserVO();
		user.setPk_user(pk_user);
		user.setLoginid(loginid);
		user.setName(name);
		user.setAccess(Integer.parseInt(access));

		// 获取当前时间
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		user.setModifytime(format.format(now));

		String loginId = userService.updateUser(user);

		return loginId;

	}

	@RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
	public @ResponseBody
	String updateUser(@RequestParam("pk_user") Integer pk_user)
			throws BusinessException {

		UserVO user = new UserVO();
		user.setPk_user(pk_user);
		user.setDr("1");

		// 获取当前时间
		Date now = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		user.setModifytime(format.format(now));

		userService.updateUser(user);

		return JsonUtil.getInstance().toJson("success");

	}

	@RequestMapping(value = "/userListDownload")
	public void download(HttpServletRequest request,
			HttpServletResponse response) throws BusinessException {

		userService.downLoadFile(response);		
	}
	
	@RequestMapping(value = "/file/userUpload",method = RequestMethod.POST)
	public @ResponseBody 
	String upLoad(@RequestParam("file") CommonsMultipartFile   file,HttpServletRequest request,
			HttpServletResponse response) throws BusinessException {

		userService.upLoadFile(request, response);
		return "";
	}

}
