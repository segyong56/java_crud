package com.study.board.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.CrossOrigin;
=======
>>>>>>> ee4ff7a7a7eb5cf29488b8bad4c7de26c20141fb
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
	
<<<<<<< HEAD
	@PostMapping("/board/writedo")
	public void boardWriteDo(@RequestBody Board board) {
		System.out.println(board.toString());
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
	public void boardUpdate(@PathVariable("id") Integer id, Board board) throws Exception {
		
		Board boardTemp = boardService.boardView(id);
		boardTemp.setTitle(board.getTitle());
		boardTemp.setContent(board.getContent());
		
		boardService.write(boardTemp);
		
	}
	
 } 
=======
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
>>>>>>> ee4ff7a7a7eb5cf29488b8bad4c7de26c20141fb
