package com.example.app.repository;

import com.example.app.domain.PostDTO;

import java.util.List;

public interface PostQueryDsl {
//    전체 조회
    public List<PostDTO> findAll_QueryDSL();
}
