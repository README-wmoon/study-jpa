package com.example.app.repository;

import com.example.app.domain.PostDTO;
import com.example.app.entity.QPost;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.app.entity.QPost.*;

@RequiredArgsConstructor
public class PostQueryDslImpl implements PostQueryDsl {
    private final JPAQueryFactory query;

    @Override
    public List<PostDTO> findAll_QueryDSL() {
        return query.select(Projections.fields(PostDTO.class, post.id, post.postTitle, post.postContent)).from(post).fetch();
    }
}
