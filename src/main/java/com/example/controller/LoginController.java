package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class LoginController {

	
	@Controller
	public class GreetingController {

	    @RequestMapping(value = "greeting", method = RequestMethod.POST)
	    public String greeting(HttpServletRequest request) {
	       
	        return "greeting";
	    }

	}
}
