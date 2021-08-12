package com.site.p0812.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class MemberVo {
	
	private String id;
	private String pw;
	private String name;
	private String nickname;
	private String gender;
	private String tel;
	private String address1;
	private String address2;
	private String hobby;
	
	@Builder
	public MemberVo(String id, String pw, String name, String nickname, String gender, String tel, String address1,
			String address2, String hobby) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.nickname = nickname;
		this.gender = gender;
		this.tel = tel;
		this.address1 = address1;
		this.address2 = address2;
		this.hobby = hobby;
	}
	
	
	
	
}
