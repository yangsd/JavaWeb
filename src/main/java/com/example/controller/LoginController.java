package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * Contoller����
 * @author sdyang
 * @date 2015��6��2�� ����5:14:27
 */
@Controller
@RequestMapping("/html")
public class LoginController {

	    @RequestMapping(value = "/greeting", method = RequestMethod.POST)	    
	    public @ResponseBody
	    Object greeting(HttpServletRequest request) {
	       
	    	String pk_id = request.getParameter("id");
	        return "hello World !";
	    }

	
}
