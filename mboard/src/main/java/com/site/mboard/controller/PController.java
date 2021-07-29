package com.site.mboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.mboard.service.BService;
import com.site.mboard.service.MService;


@WebServlet("*.do")
public class PController extends HttpServlet {
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAction");
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String conpath = request.getContextPath();
		String fileUrl = uri.substring(conpath.length());
		
		MService mService = null;
		BService bService = null;
		RequestDispatcher dispatcher = null;
		
		if(fileUrl.equals("/member/login.do")) {
			//mService = new MServiceLogin();
			//mService.execute(request,response);
			dispatcher = request.getRequestDispatcher("login.jsp");
		}else if(fileUrl.equals("/member/doLogin.do")) {
			mService = new MServiceLogin();
			mService.execute(request,response);
			dispatcher = request.getRequestDispatcher("doLogin.jsp");
		}
		
		dispatcher.forward(request, response);
		
	}
	
	
	
	//-------------------------------------------------
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		doAction(request,response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		doAction(request,response);
	}

}
