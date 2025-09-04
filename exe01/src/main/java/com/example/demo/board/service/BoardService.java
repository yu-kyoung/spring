package com.example.demo.board.service;

import java.util.List;

public interface BoardService {
	//전체조회
	List<BoardVO> selectBoardList(BoardVO boardVO);
	//건수조회
	Long selectCount(BoardVO boardVO); 
	//단건조회
	BoardVO selectBno(Long bno);
	//삭제
	int deleteBoard(Long bno);
}
