package com.site.mboard.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.site.mboard.dao.BoardDao;

public class BServiceModify implements BService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		BoardDao boardDao = new BoardDao();
		int page=0;
		String category="";
		String keyword="";
		String fileSavePath = "c:/upload";
		int size = 10*1024*1024;
		MultipartRequest multi;
		int result=0;
		//파일 변경이 없으면 예전 파일이름을 사용
		String bupload=request.getParameter("bupload");
		try {
			multi = new MultipartRequest(request, fileSavePath,size,"utf-8",new DefaultFileRenamePolicy());
			String bname = multi.getParameter("bname"); 
			String btitle = multi.getParameter("btitle"); 
			String bcontent = multi.getParameter("bcontent"); 
			page= Integer.parseInt(multi.getParameter("page"));
			category = multi.getParameter("category");
			keyword = multi.getParameter("keyword");
			//수정페이지에서 파일업로드를 변경했을시
			if(multi.getFilesystemName("bupload1")!=null) {
				bupload = multi.getFilesystemName("bupload1");		
			}
			result = boardDao.bModifyUpdate(btitle,bcontent,bname,bupload);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("result", result);
		request.setAttribute("page", page);
		request.setAttribute("category", category);
		request.setAttribute("keyword", keyword);

	}

}
