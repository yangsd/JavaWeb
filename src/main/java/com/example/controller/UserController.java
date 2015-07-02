package com.example.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dao.UserDao;
import com.example.page.PageResult;
import com.example.page.PageTest;
import com.example.util.JsonUtil;

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

	/**
	 * 
	 * @author sdyang
	 * @date 2015年7月2日 下午5:31:24
	 * @param page
	 * @param rows
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping(value = "/userPage", method = RequestMethod.GET)
	public void getPage(@RequestParam() String page,
			@RequestParam() String rows, HttpServletRequest request,
			HttpServletResponse response) throws IOException {

		PageResult result = new PageResult();
		List<PageTest> test = new ArrayList<PageTest>();

		PageTest t = new PageTest();
		t.setProductname("A");
		t.setUnitcost(10);
		t.setItemid("A");
		t.setListprice(20);
		t.setStatus("S");
		t.setAttr1("B");
		test.add(t);

		PageTest t1 = new PageTest();
		t1.setProductname("C");
		t1.setUnitcost(5);
		t1.setItemid("c");
		t1.setListprice(20);
		t1.setStatus("P");
		t1.setAttr1("R");
		test.add(t1);

		result.setTotal(12);
		result.setRows(test);

		String obj = JsonUtil.getInstance().toJson(result);

		request.setAttribute("result", obj);
		PrintWriter pw = response.getWriter();
		pw.write(obj);
		pw.flush();
		pw.close();

	}
}
