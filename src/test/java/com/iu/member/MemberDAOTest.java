package com.iu.member;

import static org.junit.Assert.assertEquals;

import javax.inject.Inject;

import org.junit.Test;

import com.iu.s4.AbstractTestCase;

public class MemberDAOTest extends AbstractTestCase{
	@Inject
	private MemberDAO memberDAO;
	@Test
	public void joinTest() throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId("id2");
		memberDTO.setPw("pw2");
		memberDTO.setName("name2");
		memberDTO.setEmail("email2");
		memberDTO.setPhone("p2");
		memberDTO.setAddress("a2");
		memberDTO.setGrade(1);
		int result=memberDAO.join(memberDTO);
		assertEquals(1, result);
	}
}
