package com.site.mboard.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.mboard.dao.BoardDao;
import com.site.mboard.vo.BVo;

public class BServicelist implements BService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao boardDao = new BoardDao();
		//검색으로 넘어올때 
		String category="",keyword="";
		if(request.getParameter("keyword")!=null) {
			category = request.getParameter("category");
			keyword = request.getParameter("keyword");
		}
		
		//하단넘버링
		int listcount = boardDao.listCountSelect(category,keyword);
		System.out.println("게시글수 : "+listcount);
		int page=1;
		System.out.println("page : "+request.getParameter("page"));
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		int limit=10; //1page당 게시글 개수
		int numlimit=10; //하단넘버링 개수
		int maxpage=(int)((double)listcount/limit+0.99);
		int startpage=(((int)((double)page/numlimit+0.99))-1)*numlimit+1;
		int endpage=startpage+numlimit-1;
		if(endpage>maxpage) endpage=maxpage; //1-10 4이면 1-4
		
		request.setAttribute("category", category);
		request.setAttribute("keyword", keyword);
		request.setAttribute("listcount", listcount);
		request.setAttribute("page", page);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		
		//한페이지 시작번호,끝번호
		int startrow = (page-1)*limit+1;
		int endrow = startrow+limit-1;
		request.setAttribute("startrow", startrow);
		request.setAttribute("endrow", endrow);
		
		// list내용 가져오기
		ArrayList<BVo> list = boardDao.bListAllSelect(startrow,endrow,category,keyword);
		request.setAttribute("list", list);

	
	}

}
