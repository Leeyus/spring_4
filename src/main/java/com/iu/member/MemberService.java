package com.iu.member;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Inject
	private MemberDAO memberDAO;
	//회원가입
	public int join(MemberDTO memberDTO) throws Exception{
		
		return memberDAO.join(memberDTO);
	}
	//idCheck
	public MemberDTO idCheck(String id) throws Exception{
		return memberDAO.idCheck(id);
	}
	//Login
	public MemberDTO login(MemberDTO memberDTO) throws Exception{
		return memberDAO.login(memberDTO);
	}
	
	//수정
	public int update(MemberDTO memberDTO) throws Exception{
		
		return memberDAO.update(memberDTO);
	}
	//삭제
	public int delete(String id) throws Exception{
		
		return memberDAO.delete(id);
	}

}
