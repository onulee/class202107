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
		int startrow = Integer.parseInt(request.getParameter("startrow"));
		int endrow = Integer.parseInt(request.getParameter("endrow"));
		
		// 현재글
		BVo bVo = boardDao.bViewSelect(bid);
		// 이전글
		BVo bVoPre = boardDao.bViewPreSelect(bid,startrow,endrow);
		// 다음글
		BVo bVoNext = boardDao.bViewNextSelect(bid,startrow,endrow);
		
		request.setAttribute("bVo", bVo);
		request.setAttribute("bVoPre", bVoPre);
		request.setAttribute("bVoNext", bVoNext);
		request.setAttribute("page", page);
		request.setAttribute("category", category);
		request.setAttribute("keyword", keyword);
	}

}
