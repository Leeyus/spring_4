package com.iu.s4;

import java.awt.Dialog.ModalExclusionType;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.iu.board.BoardDTO;
import com.iu.board.notice.NoticeService;
import com.iu.util.Pager;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	@Inject
	private NoticeService noticeService;
	
	//list
	@RequestMapping(value="noticeList")
	public String list(Model model, Pager pager) throws Exception {
		System.out.println(pager);
		List<BoardDTO> ar = noticeService.list(pager);
		model.addAttribute("board", "notice");
		model.addAttribute("list", ar);
		model.addAttribute("pager", pager);
		return "board/boardList";
	}
	
	//select
	@RequestMapping(value="noticeSelect")
	public String select(Model model, int num) throws Exception {
		BoardDTO boardDTO = noticeService.select(num);
		model.addAttribute("board", "notice");
		model.addAttribute("dto", boardDTO);
		System.out.println(boardDTO.getTitle());
		return "board/boardSelect";
	}
	
	//write Form
	@RequestMapping(value="noticeWrite", method=RequestMethod.GET)
	public String write(Model model) {
		model.addAttribute("board", "notice");
		return "board/boardWrite";
	}
	
	//write process
	@RequestMapping(value="noticeWrite", method=RequestMethod.POST)
	public String write(BoardDTO boardDTO, RedirectAttributes rd) throws Exception {
		int result = noticeService.insert(boardDTO);
		if(result < 1) {
			rd.addFlashAttribute("msg", "Insert Fail");
		}
		return "redirect:./noticeList";
	}
	
	//update Form
	@RequestMapping(value="noticeUpdate", method=RequestMethod.GET)
	public String update(Model model) {
		model.addAttribute("board", "notice");
		return "board/boardUpdate";
	}  
	
	//update process
	@RequestMapping(value="noticeUpdate", method=RequestMethod.POST)
	public void update(BoardDTO boardDTO) {
		System.out.println("update : "+boardDTO.getTitle());
	}
	
	//delete process
	@RequestMapping(value="noticeDelete", method=RequestMethod.POST)
	public void delete(int num) {
		System.out.println("delete : "+ num);
	}

}






