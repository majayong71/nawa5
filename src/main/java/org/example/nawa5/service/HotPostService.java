package org.example.nawa5.service;

import org.example.nawa5.domain.HotPost;
import org.example.nawa5.domain.HotPostCategory;

import java.time.LocalDate;
import java.util.List;

public interface HotPostService {

    /** 인기게시글 등록 **/
    void register(Long postId, LocalDate date, int rank, HotPostCategory category);

    /** 인기게시글 전체 조회 **/
    List<HotPost> gets(LocalDate date);

    /** 인기게시글 수정 **/
    void update(Long id,Long postId, LocalDate date, int rank, HotPostCategory hotPostCategory);

    /** 인기게시글 삭제 **/
    void delete(Long id);
}
