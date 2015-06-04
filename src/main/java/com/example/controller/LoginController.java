package com.example.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.exception.BusinessException;
import com.example.service.itf.IUserService;
import com.example.vo.User;
/**
 * Contoller测试
 * @author sdyang
 * @date 2015年6月2日 下午5:14:27
 */
@Controller
@RequestMapping("/html")
public class LoginController {

	@Resource 
	IUserService userService;
	
	    @RequestMapping(value = "/greeting", method = RequestMethod.POST)	    
	    public @ResponseBody
	    Object greeting(HttpServletRequest request) {
	       
	    	String pk_id = request.getParameter("id");
	    	User user = new User();
	    	user.setId(1);
	    	user.setName("sdyang");
	    	try {
	    		//userService.saveUser(user);
	    		//List<User> users = userService.getAllUser();
	    		userService.getUserById(1);
					    		
			} catch (BusinessException e) {
				e.printStackTrace();
			}
	        return "hello World !";
	    }

	
}
