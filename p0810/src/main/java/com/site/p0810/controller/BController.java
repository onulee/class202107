package com.site.p0810.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BController {
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}

}
