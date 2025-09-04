package com.example.demo.board.service;

import java.util.Date;

import com.example.demo.common.SearchVO;

import lombok.Data;

@Data
public class BoardVO extends SearchVO{
 private Long   bno;
 private String title;
 private String content;
 private String writer;
 private Date regdate;
 private Date updatedate;
}
