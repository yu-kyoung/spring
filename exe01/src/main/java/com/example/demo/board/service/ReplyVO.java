package com.example.demo.board.service;

import java.util.Date;

import com.example.demo.common.SearchVO;

import lombok.Data;

@Data
public class ReplyVO extends SearchVO {
	Long rno;
	Long bno;
	String	reply;
	String	replyer;
	Date	replydate;
	Date	updatedate;
}
