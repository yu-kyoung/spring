package com.example.demo.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.service.BoardService;
import com.example.demo.board.service.BoardVO;
import com.example.demo.common.Paging;
import com.example.demo.emp.service.EmpService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class BoardController {
//  @Autowired BoardMapper boardMapper;
   @Autowired BoardService boardService;
  // boardList데이터를 꺼낼 때 사용할 이름
  @GetMapping("boardList")
  public String boardList(Model model,BoardVO boardVO,Paging paging) {
		//페이징관련
		paging.setPageUnit(5);//페이징건수
		paging.setTotalRecord(boardService.selectCount(boardVO));
		boardVO.setFirst(paging.getFirst());
		boardVO.setLast(paging.getLast());
	    model.addAttribute("boardList",boardService.selectBoardList(boardVO));
        return "boardList";
  }
  //단건조회
  @GetMapping("board")
  public String board(Model model,@RequestParam Long bno) {
	  System.out.println(">>> bno=" + bno);
	  model.addAttribute("board",boardService.selectBno(bno));
	  return "board";
  }
  //삭제
	@PostMapping("delBoard")
	public String delBoard(@RequestParam Long bno) {
		return "redirect:/bordList";
	}
}
