package org.example.nawa5.service;

import org.example.nawa5.domain.Post;
import org.example.nawa5.domain.PostCategory;
import org.example.nawa5.domain.User;

import java.util.List;

public interface PostService {

    /**
     * 등록
     **/
    void register(User user, PostCategory postCategory, String title, String content, String imageUrl);

    /**
     * 전체 조회
     **/
    List<Post> gets();

    /**
     * 상세 조회
     **/
    Post get(Long id);

    List<Post> getByUserId(Long userId);

    List<Post> getByCategory(PostCategory category);

    /**
     * 수정
     */
    void update(Long id,PostCategory postCategory, String title, String content, String imageUrl);

    /**
     * 삭제
     **/
    void delete(Long id, Long userId);

}
