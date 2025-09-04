package com.example.demo.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.service.BoardService;
import com.example.demo.board.service.BoardVO;
import com.example.demo.emp.mapper.EmpMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {

	final BoardMapper boardMapper;

	@Override
	public List<BoardVO> selectBoardList(BoardVO boardVO) {
		return boardMapper.selectBoardList(boardVO);
	}

	@Override
	public Long selectCount(BoardVO boardVO) {
		return boardMapper.selectCount(boardVO);
	}

	@Override
	public BoardVO selectBno(Long bno) {
		return boardMapper.selectBno(bno);
	}

	@Override
	public int deleteBoard(Long bno) {
		return boardMapper.deleteBoard(bno);
	}
}
