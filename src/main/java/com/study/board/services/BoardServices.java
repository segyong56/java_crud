package com.study.board.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;

@Service
public class BoardServices {
	
	@Autowired
	private BoardRepository boardRepository;
	
	// 게시물 저장하기  
	public void write(Board board) {
		
		boardRepository.save(board);	
	}
	
	// 전체 게시물 데이터 가져오기 
	public List<Board> boardList() {
		
		return boardRepository.findAll();	
	}
	
	// 상세 게시물 데이터 가져오기 
	public Board boardView(Integer id) {
		
		return boardRepository.findById(id).get();
		
	}
	
	
}
