package com.study.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.study.board.entity.Board;
import com.study.board.services.BoardServices;

@Controller
public class BoardController {
	
	@Autowired
	private BoardServices boardService;
	
	@GetMapping("/board/write") //localhost:8080/board/write
	public String boardWriteForms() {
		return "boardwrite";
	}
	
	@PostMapping("/board/writedo")
	public String boardWriteDo(Board board) {
		
//		board.setId(2);
		System.out.println(board.getId());
		System.out.println(board.getContent());
		System.out.println(board.getTitle());

		boardService.write(board);

		
		return "";
	}
}
