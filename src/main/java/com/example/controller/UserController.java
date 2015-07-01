package com.example.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dao.UserDao;

/**
 * 
 * @author sdyang
 * @date 2015年7月1日 下午5:08:31
 */
@Controller
@RequestMapping("/finc")
public class UserController {

	@Resource
	UserDao userDao;

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

	/**
	 * 
	 * @author sdyang
	 * @date 2015年7月1日 下午5:20:59
	 * @return
	 */
	@RequestMapping(value = "/userEdit", method = RequestMethod.GET)
	public String getUserEdit() {

		return "/user/user_edit";

	}
}
