package com.iu.s4;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iu.member.MemberDTO;
import com.iu.member.MemberService;

@Controller
@RequestMapping(value="/member/**")
public class MemberController {
	@Inject
	private MemberService memberService;
	
	@RequestMapping(value="join", method=RequestMethod.GET)
	public void join() throws Exception{}
	
	@RequestMapping(value="join", method=RequestMethod.POST)
	public String join(MemberDTO memberDTO, RedirectAttributes rd) throws Exception{
		memberDTO.setGrade(9);
		int result=memberService.join(memberDTO);
		String path="redirect:../";
		if(result<1) {
			path="redirect:./join";
			rd.addFlashAttribute("msg", "회원가입실패");
		}
		return path;
	}
	
	//중복확인
	@RequestMapping(value="idCheck")
	public String idCheck(String id, Model model) throws Exception{
		MemberDTO memberDTO=memberService.idCheck(id);
		// int result = 0 //사용 불가능 , 1이면 사용가능
		int result = 0;
		if(memberDTO == null) {
			result=1;
		}
		model.addAttribute("result",result);
		
		return "coommon/result";
	}
	
	@RequestMapping(value="login", method=RequestMethod.GET)
	public void login() throws Exception{}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(MemberDTO memberDTO, HttpSession session, RedirectAttributes rd)throws Exception{
		String path = "";
		memberDTO=memberService.login(memberDTO);
		if(memberDTO != null) {
			session.setAttribute("member", memberDTO);
			path= "redirect:../";
		}else {
			path ="redirect:./login";
			rd.addFlashAttribute("msg", "로그인 실패");
		}
		return path;
	}
	
	
	@RequestMapping(value="update", method=RequestMethod.GET)
	public void update() throws Exception{}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String update(MemberDTO memberDTO, HttpSession session, RedirectAttributes rd)throws Exception{
		MemberDTO sMemberDTO = (MemberDTO)session.getAttribute("member");
		memberDTO.setId(sMemberDTO.getId());
		int result = memberService.update(memberDTO);
		if(result>0) {
			memberDTO.setGrade(sMemberDTO.getGrade());
			session.setAttribute("member", memberDTO);
		}else {
			rd.addFlashAttribute("msg", "수정 실패");
		}
		return "redirect:./myPage";
	}
	@RequestMapping(value="delete")
	public String delete(HttpSession session, RedirectAttributes rd) throws Exception{
		MemberDTO memberDTO = (MemberDTO)session.getAttribute("member");
		int result=memberService.delete(memberDTO.getId());
		String message = "Delete Fail";
		if(result>0) {
			message="Delete success";
			session.invalidate();//invalidate는 로그아웃해주는 속성이다.
		}
		rd.addFlashAttribute("msg", message);
		return "redirect:../";
	}
	
	//myPage
	@RequestMapping(value="myPage")
	public void myPage()throws Exception{
		
	}
	@RequestMapping(value="logOut")
	public String logOut(HttpSession session)throws Exception{
		session.invalidate();
		return "redirect:../";
	}
	
	

}
