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
	
	
	//게시글 저장 -> int
	public int bWriteInsert(String btitle, String bcontent, String bname, String bupload) {
		int result=0;
		try {
			conn = getConnection();
			String sql = "insert into board values(\r\n"
					+ "board_seq.nextval,?,?,?,board_seq.currval,0,0,\r\n"
					+ "sysdate,?,0)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,btitle);
			pstmt.setString(2,bcontent);
			pstmt.setString(3,bname);
			pstmt.setString(4,bupload);
			result = pstmt.executeUpdate();
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
		return result;
	}//bWriteInsert
	
	// 게시글 수
	public int listCountSelect(String category, String keyword) {
		int count=0;
		try {
			conn=getConnection();
			switch (category) {
				case "": {
					String sql="select count(*) count from board";
					pstmt = conn.prepareStatement(sql);
					break;
				}
	            case "all": {
	            	String sql="select count(*) count from board\r\n"
	            			+ "where btitle like ? or bcontent like ?";
	            	pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, "%"+keyword+"%");
					pstmt.setString(2, "%"+keyword+"%");
					break;
				}
	            case "btitle": {
	            	String sql="select count(*) count from board\r\n"
	            			+ "where btitle like ?";
	            	pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, "%"+keyword+"%");
					break;
				}
	            case "bcontent": {
	            	String sql="select count(*) count from board\r\n"
	            			+ "where bcontent like ?";
	            	pstmt = conn.prepareStatement(sql);
	            	pstmt.setString(1, "%"+keyword+"%");
					break;
				}
			}
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
	public ArrayList<BVo> bListAllSelect(int startrow, int endrow, String category, String keyword){
		ArrayList<BVo> list = new ArrayList<BVo>();
		try {
			conn = getConnection();
			switch (category) {
				case "": {
					String sql = "select * from\r\n"
							+ "(select rownum rnum,b.* from\r\n"
							+ "(select * from board order by bgroup desc,bstep asc) b)\r\n"
							+ "where rnum>=? and rnum<=?";
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, startrow);
					pstmt.setInt(2, endrow);
					break;
				}
	            case "all": {
	            	String sql = "select * from\r\n"
	            			+ "(select rownum rnum,b.* from\r\n"
	            			+ "(select * from board order by bgroup desc,bstep asc) b\r\n"
	            			+ "where btitle like ? or bcontent like ?)\r\n"
	            			+ "where rnum>=? and rnum<=?";
	    			pstmt = conn.prepareStatement(sql);
	    			pstmt.setString(1, "%"+keyword+"%");
	    			pstmt.setString(2, "%"+keyword+"%");
	    			pstmt.setInt(3, startrow);
	    			pstmt.setInt(4, endrow);
					break;
				}
	            case "btitle": {
	            	String sql = "select * from\r\n"
	            			+ "(select rownum rnum,b.* from\r\n"
	            			+ "(select * from board order by bgroup desc,bstep asc) b\r\n"
	            			+ "where btitle like ?)\r\n"
	            			+ "where rnum>=? and rnum<=?";
	    			pstmt = conn.prepareStatement(sql);
	    			pstmt.setString(1, "%"+keyword+"%");
	    			pstmt.setInt(2, startrow);
	    			pstmt.setInt(3, endrow);
					break;
				}
	            case "bcontent": {
	            	String sql = "select * from\r\n"
	            			+ "(select rownum rnum,b.* from\r\n"
	            			+ "(select * from board order by bgroup desc,bstep asc) b\r\n"
	            			+ "where bcontent like ?)\r\n"
	            			+ "where rnum>=? and rnum<=?";
	    			pstmt = conn.prepareStatement(sql);
	    			pstmt.setString(1, "%"+keyword+"%");
	    			pstmt.setInt(2, startrow);
	    			pstmt.setInt(3, endrow);
					break;
				}
			}
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
