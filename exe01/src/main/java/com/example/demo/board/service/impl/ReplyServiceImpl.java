package com.example.demo.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.board.mapper.BoardMapper;
import com.example.demo.board.mapper.ReplyMapper;
import com.example.demo.board.service.ReplyService;
import com.example.demo.board.service.ReplyVO;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ReplyServiceImpl implements ReplyService{
	final ReplyMapper replyMapper;

	@Override
	public int insert(ReplyVO replyVO) {
		return replyMapper.insert(replyVO);
	}

	@Override
	public ReplyVO read(Long rno) {
		return replyMapper.read(rno);
	}

	@Override
	public int delete(Long rno) {
		return replyMapper.delete(rno);
	}

	@Override
	public int update(ReplyVO replyVO) {
		return replyMapper.update(replyVO);
	}

	@Override
	public List<ReplyVO> getList(ReplyVO replyVO) {
		return replyMapper.getList(replyVO);
	}

	@Override
	public int getCountByBno(Long bno) {
		return replyMapper.getCountByBno(bno);
	}
	
}
