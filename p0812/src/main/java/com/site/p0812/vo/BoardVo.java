package com.site.p0812.vo;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardVo {
	
	int bid;
	String btitle;
	String bcontent;
	String bname;
	int bgroup;
	int bstep;
	int bindent;
	Timestamp bdate;
	String bupload;
	int bhit;

}
