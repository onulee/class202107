package com.site.p0812.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.site.p0812.vo.MemberVo;

@Controller
public class MController {
	
	@RequestMapping("index")
	public String index() {
		return "/index";
	}
	
	@GetMapping("login")
	public String login() {
		return "/login";
	}
	
	@PostMapping("login")
	public String login(MemberVo memberVo,HttpServletRequest request,Model model) {

		HttpSession session = request.getSession();
		//service 실행함.
		if(memberVo.getId().equals("aaa") && memberVo.getPw().equals("1111")) {
			//로그인성공
			session.setAttribute("session_flag", "success");
			session.setAttribute("session_id", memberVo.getId());
			//memberVo.getNickName();
			session.setAttribute("session_nickName", "길동스");
		}else {
			//로그인실패
			session.setAttribute("session_flag", "fail");
		}
		
		return "/loginOk";
	}

}
