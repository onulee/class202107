package com.site.mboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.mboard.service.BService;
import com.site.mboard.service.BServiceModify;
import com.site.mboard.service.BServiceView;
import com.site.mboard.service.BServiceWrite;
import com.site.mboard.service.BServicelist;
import com.site.mboard.service.MService;
import com.site.mboard.service.MServiceLogin;


@WebServlet("*.do")
public class PController extends HttpServlet {
	
	protected void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doAction");
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		String conpath = request.getContextPath();
		String fileUrl = uri.substring(conpath.length());
		System.out.println("uri :"+uri);
		System.out.println("conpath :"+ conpath);
		System.out.println("fileUrl :"+fileUrl);
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
		}else if(fileUrl.equals("/board/blist.do")) {
			bService = new BServicelist();
			bService.execute(request,response);
			dispatcher = request.getRequestDispatcher("blist.jsp");
		}else if(fileUrl.equals("/board/bwrite.do")) {
			dispatcher = request.getRequestDispatcher("bwrite.jsp");
		}else if(fileUrl.equals("/board/doBwrite.do")) {
			bService = new BServiceWrite();
			bService.execute(request,response);
			dispatcher = request.getRequestDispatcher("doBwrite.jsp");
		}else if(fileUrl.equals("/board/bview.do")) {
			bService = new BServiceView();
			bService.execute(request,response);
			dispatcher = request.getRequestDispatcher("bview.jsp");
		}else if(fileUrl.equals("/board/bmodify.do")) {
			bService = new BServiceModify();
			bService.execute(request,response);
			dispatcher = request.getRequestDispatcher("bmodify.jsp");
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
