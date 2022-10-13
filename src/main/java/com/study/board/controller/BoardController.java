package com.study.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.study.board.entity.Board;
import com.study.board.services.BoardServices;

@Controller
public class BoardController {
	
	@Autowired
	private BoardServices boardService;
	
	@GetMapping("/board/write") // /board/write
	public String boardWriteForms() {
		return "boardwrite";
	}
	
	@PostMapping("/board/writedo") 
	public String boardWriteDo(Board board) {
		boardService.write(board);
		return "";
	}
	
	@GetMapping("/board/list")
	public String boardList(Model model) {
		model.addAttribute("list", boardService.boardList());
		return "boardlist";
	}
	
	@GetMapping("/board/view") // /board/view/id=1
	public String boardView(Model model, Integer id) {
		model.addAttribute("board", boardService.boardView(id));
		return "boardview";
	}
}
