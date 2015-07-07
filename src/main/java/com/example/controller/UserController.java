package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.constants.RoleConstant;
import com.example.dao.UserDao;
import com.example.exception.BusinessException;
import com.example.page.PageResult;
import com.example.util.JsonUtil;
import com.example.util.MD5;
import com.example.vo.UserVO;

/**
 * 
 * @author sdyang
 * @date 2015��7��1�� ����5:08:31
 */
@Controller
@RequestMapping("/finc")
public class UserController {

	@Resource
	UserDao userDao;

	/**
	 * 
	 * @author sdyang
	 * @date 2015��7��1�� ����5:20:50
	 * @return
	 */
	@RequestMapping(value = "/userList", method = RequestMethod.GET)
	public String getUserList() {

		return "/user/user_list";

	}

	/**
	 * 
	 * @author sdyang
	 * @date 2015��7��1�� ����5:20:53
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

		String loginId = userDao.addUser(user);

		return loginId;

	}

	@RequestMapping(value = "/userDetail", method = RequestMethod.GET)
	public ModelAndView getUserDetail(@RequestParam("id") String id) throws NumberFormatException, BusinessException {

		UserVO user = userDao.getUserById(Integer.parseInt(id));
		ModelAndView view = new ModelAndView();

		view.addObject("loginid",user.getLoginid());
		view.addObject("name", user.getName());
		view.addObject("access",RoleConstant.ACCESS.get(user.getAccess()));		
		view.addObject("creatime",user.getCreatime());
		view.setViewName("user/user_detail");

		return view;

	}

	/**
	 * 
	 * @author sdyang
	 * @date 2015��7��1�� ����5:20:59
	 * @return
	 */
	@RequestMapping(value = "/userEdit", method = RequestMethod.GET)
	public String getUserEdit(HttpServletRequest request) {

		return "/user/user_edit";

	}

	/**
	 * 
	 * @author sdyang
	 * @date 2015��7��2�� ����5:31:24
	 * @param page
	 * @param rows
	 * @param request
	 * @param response
	 * @throws IOException
	 * @throws BusinessException 
	 */
	@RequestMapping(value = "/userPage", method = RequestMethod.GET)
	public void getPage(@RequestParam("page") Integer page,
			@RequestParam("rows") Integer rows, HttpServletRequest request,
			HttpServletResponse response) throws IOException, BusinessException {

		PageResult result = new PageResult();
		List<UserVO> users = userDao.getAllUser();
		
		/*
		UserQueryCondition params = new UserQueryCondition();
		params.setCurrentPage(page);
		params.setRows(rows);
		params.calculateOffset();
		List<UserVO> users = userDao.getUsers(params);
		*/
		result.setTotal(userDao.getUserCount());
		result.setRows(users);

		String obj = JsonUtil.getInstance().toJson(result);

		request.setAttribute("result", obj);
		PrintWriter pw = response.getWriter();
		pw.write(obj);
		pw.flush();
		pw.close();

	}
}