package com.example.demo.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Getter;

//setter X  posts에 필드값을 변경하면 db에 반영
@Getter
@Entity
public class Posts extends BaseTimeEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "post_title", length = 100, nullable = false)
	private String title;
	private String content;
	
	//@Transient
	private String author;


	
	public Posts() {};
	
	@Builder
	public Posts(String title, String content, String author) {
		super();
		this.title = title;
		this.content = content;
		this.author = author;
	}
	//수정
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
	
}
