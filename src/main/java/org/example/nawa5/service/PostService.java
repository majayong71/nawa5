package org.example.nawa5.service;

import org.example.nawa5.domain.Post;
import org.example.nawa5.domain.PostCategory;
import org.example.nawa5.domain.SearchCategory;
import org.example.nawa5.domain.User;

import java.util.List;

public interface PostService {

    /**
     * 등록
     **/
    void register(Long userId, PostCategory postCategory, String title, String content, String imageUrl);

    /**
     * 서치
     */
    List<Post> search(SearchCategory category, String keyword);

    /**
     * -추후 페이징 작업
     * & 카테고리별 전체 조회
     * 전체 조회
     **/
    List<Post> gets();

    /**
     * 상세 조회
     **/
    Post get(Long id);

    List<Post> getByUserId(Long userId);

    /**
     * 수정
     */
    void update(Long id, Long userId, PostCategory postCategory, String title, String content, String imageUrl);

    /**
     * 삭제
     **/
    void delete(Long id, Long userId);

}
