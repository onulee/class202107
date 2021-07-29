package com.site.mboard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.site.mboard.dao.MemberDao;
import com.site.mboard.service.MService;
import com.site.mboard.vo.MVo;

public class MServiceLogin implements MService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		MemberDao memberDao = new MemberDao();
		HttpSession session = request.getSession();
		// login.jsp -> controller -> MService
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MVo mVo = memberDao.mLoginSelect(id, pw);
		
		//id,pw가 맞아서 1개 데이터가 담겨있으면
		if(mVo.getId()==null) {
			session.setAttribute("session_flag", "fail");
		}else {
			session.setAttribute("session_flag", "success");
			session.setAttribute("session_id", mVo.getId());
			session.setAttribute("session_nickname", mVo.getNickname());
		}
	}
}
