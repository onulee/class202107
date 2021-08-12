package com.site.p0812.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.site.p0812.vo.MemberVo;

@Controller
public class MController {
	
	@RequestMapping("index")
	public String index() {
		return "/index";
	}
	
	@RequestMapping("listpage")
	public String listpage(@RequestParam(defaultValue = "1") int page,Model model) {
		model.addAttribute("page",page);
		return "/listpage";
	}
	
	
	@GetMapping("join")
	public String join() {
		return "/join";
	}
	
	@PostMapping("join")
	public String join(MemberVo memberVo,Model model) {
		
		//db저장을 위해 memberVo -> service로 전달
		model.addAttribute("memberVo",memberVo);
		return "/joinOk";
	}
	
	@GetMapping("logout")
	public String logout() {
		return "/logout";
	}
	
	@GetMapping("login")
	public String login() {
		return "/login";
	}
	
	@PostMapping("login")
	public String login(MemberVo memberVo,HttpServletRequest request, Model model) {

		HttpSession session = request.getSession();
		//login form 데이터 받음
		String id = memberVo.getId();
		String pw = memberVo.getPw();
		
		//service -> DB와 연결
		if(id.equals("aaa") && pw.equals("1111")) {
			//로그인성공
			session.setAttribute("session_flag", "success");
			session.setAttribute("session_id", id);
			session.setAttribute("session_nickName", "길동스");
		}else {
			//로그인실패
			session.setAttribute("session_flag", "fail");
			
		}
		
		return "/loginOk";
	}

}
