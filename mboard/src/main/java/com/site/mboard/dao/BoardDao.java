package com.site.mboard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.site.mboard.vo.BVo;

public class BoardDao {
	private DataSource ds = null;
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	
	private int bid;
	private String btitle,bcontent,bname;
	private int bgroup,bstep,bindent;
	private Timestamp bdate;
	private String bupload;
	private int bhit;
	
	// 게시글 수
	public int listCountSelect() {
		int count=0;
		try {
			conn=getConnection();
			String sql="select count(*) count from board";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			//데이터 받기
			if(rs.next()) {
				count = rs.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)	rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return count;
	}//listCountSelect
	
	// list 전체 게시글 -> ArrayList
	public ArrayList<BVo> bListAllSelect(){
		ArrayList<BVo> list = new ArrayList<BVo>();
		try {
			conn = getConnection();
			String sql = "select * from board order by bgroup desc,bstep asc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				bid = rs.getInt("bid");
				btitle = rs.getString("btitle");
				bcontent = rs.getString("bcontent");
				bname = rs.getString("bname");
				bgroup = rs.getInt("bgroup");
				bstep = rs.getInt("bstep");
				bindent = rs.getInt("bindent");
				bdate = rs.getTimestamp("bdate");
				bupload = rs.getString("bupload");
				bhit = rs.getInt("bhit");
				BVo bVo = new BVo(bid,btitle,bcontent,bname,bgroup,bstep,bindent,bdate,bupload,bhit);
				list.add(bVo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)	rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	} //bListAllSelect
	
	
	
	
	
	//------------------------------------------------------
	// DataSource 1개 Connection 가져옴.
	public Connection getConnection() throws Exception {
		Context context = new InitialContext();
		ds = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		return ds.getConnection();
	}





	

}
