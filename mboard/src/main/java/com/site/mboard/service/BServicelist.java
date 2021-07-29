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
		int listcount = boardDao.listCountSelect();
		System.out.println("게시글수 : "+listcount);
		int page=1;
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		int limit=10; //1page당 게시글 개수
		int numlimit=10; //하단넘버링 개수
		int maxpage=(int)((double)listcount/limit+0.99);
		int startpage=(((int)((double)page/numlimit+0.99))-1)*numlimit+1;
		int endpage=startpage+numlimit-1;
		if(endpage>maxpage) endpage=maxpage; //1-10 4이면 1-4
		
		request.setAttribute("listcount", listcount);
		request.setAttribute("page", page);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		
		ArrayList<BVo> list = boardDao.bListAllSelect();
		request.setAttribute("list", list);

	
	}

}
