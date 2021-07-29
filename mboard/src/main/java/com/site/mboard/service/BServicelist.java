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
		ArrayList<BVo> list = boardDao.bListAllSelect();
		request.setAttribute("list", list);

	
	}

}
