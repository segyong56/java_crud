package com.study.board.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.board.entity.Board;
import com.study.board.repository.BoardRepository;

@Service
public class BoardServices {
	
	@Autowired
	private BoardRepository boardRepository;
	
	public void write(Board board) {
		
		boardRepository.save(board);
		
	}
}
