package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Transactional
@Controller
@RequestMapping("/finc")
public class FileController {

	@RequestMapping(value = "/file", method = RequestMethod.GET)
	public String getUserList() {

		return "/file/file";

	}
}
