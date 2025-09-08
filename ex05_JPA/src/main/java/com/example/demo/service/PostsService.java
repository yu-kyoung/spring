package com.example.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.domain.Posts;
import com.example.demo.domain.dto.PostsListResponseDto;
import com.example.demo.domain.dto.PostsSaveRequestDto;
import com.example.demo.domain.dto.PostsUpdateRequestDto;
import com.example.demo.repository.PostsRepository;

import lombok.RequiredArgsConstructor;

	
@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;
    //등록
    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }
    //수정
    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }
    
    
    //페이징 조회
    public Page<PostsListResponseDto> findAllPaging(Pageable pageable) {
    	return postsRepository.findAllPage(pageable);
    }
}