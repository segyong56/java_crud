package com.study.board.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.study.board.entity.Board;
import com.study.board.services.BoardServices;

@RestController
@CrossOrigin(origins="*",allowedHeaders = "*")
public class BoardController {
	
	@Autowired
	private BoardServices boardService;
	
	@GetMapping("/board/write") // /board/write
	public String boardWriteForms() {
		return "boardwrite";
	}
	

	@PostMapping("/board/writedo")
	public void boardWriteDo(@RequestBody Board board) {

		boardService.write(board);		
	}
	
	
	@GetMapping("/board/list")
	public List<Board> boardList() {
		List<Board> board = boardService.boardList(); 		
		return board;
	}
	
	@GetMapping("/board/view/{id}")
	public Board boardView(@PathVariable("id") Integer id) {
		Board board = boardService.boardView(id);
		return board;
	}
	
	@GetMapping("/board/delete/{id}")
	public void boardDelete(@PathVariable("id") Integer id) {
		
		boardService.boardDelete(id);
				
	}
	
	@GetMapping("/board/modify/{id}")
	public Board boardModify(@PathVariable("id") Integer id) {
		
		Board board = boardService.boardView(id);
		return board;

	}
	
	@PostMapping("/board/update/{id}")
	public void boardUpdate(@PathVariable("id") Integer id, @RequestBody Board board) throws Exception {
		System.out.println(board.toString());
		Board boardTemp = boardService.boardView(id);
		boardTemp.setTitle(board.getTitle());
		boardTemp.setContent(board.getContent());
		
		boardService.write(boardTemp);
	
		
	}
	
 } 

