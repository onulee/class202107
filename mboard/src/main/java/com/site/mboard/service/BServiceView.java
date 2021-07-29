package com.site.mboard.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.mboard.dao.BoardDao;
import com.site.mboard.vo.BVo;

public class BServiceView implements BService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao boardDao = new BoardDao();
		int bid = Integer.parseInt(request.getParameter("bid"));
		int page = Integer.parseInt(request.getParameter("page"));
		String category = request.getParameter("category");
		String keyword = request.getParameter("keyword");
		
		BVo bVo = boardDao.bViewSelect(bid);
		
		request.setAttribute("bVo", bVo);
		request.setAttribute("page", page);
		request.setAttribute("category", category);
		request.setAttribute("keyword", keyword);
	}

}
