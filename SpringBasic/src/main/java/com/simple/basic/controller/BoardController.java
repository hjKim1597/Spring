package com.simple.basic.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.simple.basic.command.BoardVO;
import com.simple.basic.service.board.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	@Qualifier("a")
	BoardService boardService;
	
	//목록
	@RequestMapping("/boardList")
	public String boardList(Model model) {
		
		ArrayList<BoardVO> list = boardService.getBoard();
		
		model.addAttribute("list", list);
		
		return "board/boardList";
	}
	
	//등록
	@RequestMapping("/boardRegister")
	public String boardRegister() {
		return "board/boardRegister";
	}
	
	//폼요청
	@RequestMapping(value = "/boardForm", method = RequestMethod.POST)
	public String boardForm(BoardVO vo) {
		
		boardService.register(vo);
		
		return "board/boardResult";
		
		
	}
	
	//삭제요청
	@RequestMapping("/deleteBoard")
	public String delete(@RequestParam("num") int num) {
		boardService.delete(num);
		
		return "redirect:/board/boardList";
	}
	
}
