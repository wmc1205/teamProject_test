package com.wmc.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wmc.board.BoardDAO;
import com.wmc.board.BoardDTO;

@Service
public class BoardService {
	@Autowired BoardDAO boardDAO;
	public List<BoardDTO> selectList(HashMap<String,Object>param) {
		
		return boardDAO.selectList(param);
	}
	public void addViewCount(int idx) {
		boardDAO.addViewCount(idx);
		
	}
	public BoardDTO viewBoard(int idx) {
		BoardDTO dto = boardDAO.selectOne(idx);
		return dto;
	}
	public int write(BoardDTO dto) {
		int row = boardDAO.write(dto);
		return row;
	}
	public int update(BoardDTO dto) {
		int row = boardDAO.update(dto);
		return row;
	}
	public int delete(BoardDTO dto) {
		int row = boardDAO.delete(dto);
		return row;
	}
	public int selectBoardCount(HashMap<String, Object> param) {
		int boardCount = boardDAO.selectBoardCount(param);
		return boardCount;
	}

}
