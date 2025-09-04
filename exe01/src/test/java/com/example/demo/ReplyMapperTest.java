package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.mapper.ReplyMapper;
import com.example.demo.board.service.ReplyVO;

@SpringBootTest //메퍼불러옴
public class ReplyMapperTest {
  @Autowired ReplyMapper relpyMapper;
  
  //게시글의 댓글 목록 조회
  @Test
  public void getList() {
	  ReplyVO reply = new ReplyVO();
	  reply.setBno(1L);
	  reply.setLast(10);
	  reply.setFirst(1);
	  List<ReplyVO> list = relpyMapper.getList(reply);
	  list.forEach(System.out::print);//화살표함수,자바에서는 람다방식 ::
//	  list.forEach(reply => System.out.println(reply);
  }
  
  @Test
  public void insert() {
	  //given
	  ReplyVO reply = new ReplyVO();
	  reply.setBno(1L);//게시글번호
	  reply.setReplyer("uno");//작성자
	  reply.setReply("첫번째 댓글....");//댓글내용
	  //when
	  int result = relpyMapper.insert(reply);
	  //then
	  assertEquals(result, 1);
	  
  }
}
