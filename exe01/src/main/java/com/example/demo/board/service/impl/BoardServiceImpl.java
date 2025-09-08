package com.example.demo.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.service.BoardService;
import com.example.demo.board.service.BoardVO;
import com.example.demo.common.aop.PrintExecutionTime;
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
	@PrintExecutionTime
	public BoardVO selectBno(Long bno) {
		return boardMapper.selectBno(bno);
	}

	@Transactional
	@Override
	public int deleteBoard(Long bno) {
		//댓글
		
		//첨부파일삭제(레코드 삭제).물리적인 파일 삭제
		
		//게시글삭제
		return boardMapper.deleteBoard(bno);
	}

	@Override
	public int insertBoard(BoardVO boardVO) {
		return boardMapper.insertBoard(boardVO);
	}
}
