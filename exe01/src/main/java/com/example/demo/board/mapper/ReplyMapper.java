package com.example.demo.board.mapper;


import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.example.demo.board.service.ReplyVO;

//기본이 public이라 생략가능
@Mapper
public interface ReplyMapper {
	//댓글 추가(몇 건인지에 대한 건수라 void,int로 고정,값이 여러개면 vo로 받는게 편함)
	int insert(ReplyVO replyVO);
	//단건조회
	ReplyVO read(Long rno);
	//댓글삭제
	int delete(Long rno);
	//댓글수정
	int update(ReplyVO replyVO);
	//댓글 전체
	List<ReplyVO> getList(ReplyVO replyVO);
	//댓글갯수,int or long | bno타입이 long 
	int getCountByBno(Long bno);
}
