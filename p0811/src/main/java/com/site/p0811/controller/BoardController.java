package com.site.p0811.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.site.p0811.vo.MemberVo;

@Controller
public class BoardController {
	
	@RequestMapping("/index")
	public String index() {
		return "/index";
	}
	
	@GetMapping("form")
	public String form() {
		return "/form";
	}
	
	@RequestMapping("formOk")
	public String formOk(MemberVo memberVo,Model model) {
		
		String hobbys="";
		for(int i=0;i<memberVo.getHobby().length;i++) {
			if(i==0) {
				hobbys += memberVo.getHobby()[i];
			}else {
				hobbys +=","+memberVo.getHobby()[i];  //game,read,run,golf
			}
		}
		model.addAttribute("memberVo",memberVo);
		model.addAttribute("hobbys",hobbys);
		return "/formOk";
	}
	
	
	@GetMapping("/login")
	public String login() {
		System.out.println("get방식으로 들어옴.");
		return "/login";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			HttpServletRequest request, Model model) {
		
		HttpSession session = request.getSession();
		System.out.println("post방식으로 들어옴.");
		if(id.equals("aaa") || pw.equals("1111")) {
			session.setAttribute("session_flag", "success");
		}else {
			session.setAttribute("session_flag", "fail");
		}
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		
		//ModelAndView 클래스를 이용한 데이터 전닭
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("id",id);
//		mv.addObject("pw",pw);
//		mv.setViewName("/index");
		return "/index";
	}
	
	@RequestMapping("/logout")
	public String logout() {
		return "/logout";
	}
	

}
