package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * chart测试
 * 
 * @author sdyang
 * @date 2015年7月2日 上午9:47:52
 */
@Controller
@RequestMapping("/finc")
public class ChartController {

	@RequestMapping(value = "/line", method = RequestMethod.GET)
	public String getLinePage() {

		return "/chart/line";

	}
	
	@RequestMapping(value = "/line1", method = RequestMethod.GET)
	public String getLinePage1() {

		return "/chart/line1";

	}

	@RequestMapping(value = "/column", method = RequestMethod.GET)
	public String getColumnPage() {

		return "/chart/column";

	}
	
	@RequestMapping(value = "/column1", method = RequestMethod.GET)
	public String getColumn1Page() {

		return "/chart/column1";

	}

	@RequestMapping(value = "/pie", method = RequestMethod.GET)
	public String getPiePage() {

		return "/chart/pie";

	}
}
