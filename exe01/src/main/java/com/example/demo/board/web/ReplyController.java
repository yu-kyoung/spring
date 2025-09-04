package com.example.demo.board.web;

import org.springframework.web.bind.annotation.RestController;

import com.example.demo.board.mapper.ReplyMapper;
import com.example.demo.board.service.ReplyService;
import com.example.demo.board.service.ReplyVO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ReplyController {
//	@Autowired ReplyMapper replyMapper;
	@Autowired ReplyService replyService;
// 등록
	@PostMapping("/reply")
	//json일 경우 content-type으로 확인 가능,html의 url,메서드 동일,form일 경우 reqbody는 필요x
	public int insert(@RequestBody ReplyVO vo) {
		int result  = replyService.insert(vo);
		return result;
	}
// 수정
	@PutMapping("/reply/{rno}")
	public int update(@RequestBody ReplyVO vo) {
	    return replyService.update(vo);
	}
//삭제
	@DeleteMapping("/reply/{rno}")
	public int delete(@PathVariable Long rno) {
		int result = replyService.delete(rno);
		return result;
	}
//전체조회
	@GetMapping("/board/{bno}/reply")// /board/{bno}/reply/{page}-> 파라미터로 페이지 번호 보냄
	public List<ReplyVO> list(@PathVariable Long bno, ReplyVO replyVO) {
		replyVO.setBno(bno);
		replyVO.setFirst(1);//페이징 관련부분
		replyVO.setLast(100);
		return replyService.getList(replyVO);//mapper 전체조회관련 쿼리문부름,list<vo>타입으로 변경을 해줘야함
	}
//단건조회,삭제랑 유사 메서드만 다름
	@GetMapping("/reply/{rno}")
	public String get( ) {
		return "";
	}
}
