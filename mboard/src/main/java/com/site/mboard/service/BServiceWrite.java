package com.site.mboard.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.site.mboard.dao.BoardDao;

public class BServiceWrite implements BService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao boardDao = new BoardDao();
		String fileSavePath = "c:/upload";
		int size = 10*1024*1024;
		MultipartRequest multi;
		int result=0;
		try {
			multi = new MultipartRequest(request, fileSavePath,size,"utf-8",new DefaultFileRenamePolicy());
			String bname = multi.getParameter("bname"); 
			String btitle = multi.getParameter("btitle"); 
			String bcontent = multi.getParameter("bcontent"); 
			String bupload = multi.getFilesystemName("bupload1");		
			result = boardDao.bWriteInsert(btitle,bcontent,bname,bupload);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("result", result);

	}

}
