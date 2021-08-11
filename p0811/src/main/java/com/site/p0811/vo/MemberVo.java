package com.site.p0811.vo;

public class MemberVo {
	
	String id;
	String pw;
	String name;
	String[] hobby;
	
	public MemberVo() {}
	public MemberVo(String id, String pw, String name, String[] hobby) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.hobby = hobby;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String[] getHobby() {
		return hobby;
	}
	public void setHobby(String[] hobby) {
		this.hobby = hobby;
	}
	
	
	

}
