package com.site.p0812.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.site.p0812.vo.BoardVo;
import com.site.p0812.vo.MemberVo;

@Controller
public class BController {
	
	@RequestMapping("board")
	public String board(Model model) {
		// ArrayList
		ArrayList<BoardVo>list = new ArrayList();
		//db연결
		
		
		
		
		
		model.addAttribute("list",list);
		return "/board";
	}

}
