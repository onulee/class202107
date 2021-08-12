package com.site.p0812.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.site.p0812.mapper.MemberMapper;
import com.site.p0812.vo.MemberVo;

@Service
public class MServiceImpl implements MService {
	//@Service가 있으면 IOC 컨테이너 자동생성해줌. 
	//@Autowired
	//MemberMapper memberMapper; 

	@Override
	public MemberVo login(String id, String pw) {
		//DAO에 데이터를 보내줌.
		//MemberVo mVo = memberMapper.loginOneSelect(id,pw);
		MemberVo mVo=null;
		return mVo;
	}
	
	
     
}
