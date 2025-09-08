package com.example.demo.web;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.domain.dto.PostsListResponseDto;
import com.example.demo.domain.dto.PostsSaveRequestDto;
import com.example.demo.domain.dto.PostsUpdateRequestDto;
import com.example.demo.service.PostsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class PostsController {

	private final PostsService postsService;

	@PostMapping("/api/v1/posts")
	public Long save(@RequestBody PostsSaveRequestDto requestDto) {
		return postsService.save(requestDto);
	}

	// 수정
	@PutMapping("/api/v1/posts/{id}")
	public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
		return postsService.update(id, requestDto);
	}
	
	//페이징
	@GetMapping("/api/v1/posts")
	public Page<PostsListResponseDto> index(Model model,
			@PageableDefault(page = 1, size = 3, sort = "id", direction = Direction.ASC) Pageable pagable) {
		return postsService.findAllPaging(pagable);
	}
}