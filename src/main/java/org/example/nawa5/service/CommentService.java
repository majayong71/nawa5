package org.example.nawa5.service;

import org.example.nawa5.domain.Comment;
import org.example.nawa5.domain.Post;
import org.example.nawa5.domain.User;

import java.util.List;

public interface CommentService {

    /** 댓글 등록 **/
    void register(User user, Post post, String content, String imageUrl);

    /** 댓글 조회 **/
    List<Comment> gets(Post post);

    /** 댓글 수정 **/
    void update(Long id, User user, String content, String imageUrl);

    /** 댓글 삭제 **/
    void delete(Long id, User user);
}
