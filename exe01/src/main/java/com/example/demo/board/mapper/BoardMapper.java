package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.board.service.BoardVO;
import com.example.demo.emp.service.EmpVO;

@Mapper
public interface BoardMapper {
	//전체조회
	List<BoardVO> selectBoardList(BoardVO boardVO);
	//건수조회
	Long selectCount(BoardVO boardVO); 
	//단건조회
	BoardVO selectBno(Long bno);
	//삭제
	int deleteBoard(Long bno);
	//등록
	int insertBoard(BoardVO boardVO);
}
