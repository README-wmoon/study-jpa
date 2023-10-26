package com.example.app.service;

import com.example.app.domain.PostDTO;
import com.example.app.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Override
    public void write(PostDTO postDTO) {
        postRepository.save(toEntity(postDTO));
    }

    @Override
    public List<PostDTO> getList() {
        return postRepository.findAll_QueryDSL();
    }
}


















