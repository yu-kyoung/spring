package com.example.demo.domain.dto;

import java.time.LocalDateTime;

import com.example.demo.domain.Posts;

import lombok.Getter;
import lombok.Setter;
 
@Getter
@Setter
public class PostsListResponseDto {
	//목록조회
	private Long id;
	private String title;
	private String author;
	private LocalDateTime modifiedDate;
	
	//기본 생성자
	public PostsListResponseDto() {};
	
	public PostsListResponseDto(Posts entity) {
		this.id =entity.getId();
		this.title=entity.getTitle();
		this.author=entity.getAuthor();
		this.modifiedDate=entity.getModifiedDate();
	}

}
