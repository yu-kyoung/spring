package com.example.demo;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.domain.Posts;
import com.example.demo.repository.PostsRepository;

@SpringBootTest
public class PostsRepositoryTest {

	@Autowired
	PostsRepository postsRepository;

	@AfterAll
	public void cleanup() {
		postsRepository.deleteAll();
	}

	// @Transactional
	// @Rollback(true)
	@Test
	public void insert() {
		// Posts posts= new Posts("","","");
		Posts posts = Posts.builder().author("김유경").title("포스트제목1").content("포스트내용").build();
		postsRepository.save(posts);

	}

}
