package org.example.nawa5.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.nawa5.domain.Comment;
import org.example.nawa5.domain.Post;
import org.example.nawa5.domain.User;
import org.example.nawa5.repository.CommentRepository;
import org.example.nawa5.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Override
    public void register(User user, Post post, String content, String imageUrl) {
        Comment comment = new Comment(user, post, content, imageUrl);
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> gets(Post post) {
        return commentRepository.findByPost(post);
    }

    @Override
    public void update(Long id, User user, String content, String imageUrl) {
        Comment comment = commentRepository.findById(id).get();

        comment.update(id, user, content, imageUrl);
    }

    @Override
    public void delete(Long id, User user) {
        Comment comment = commentRepository.findById(id).get();

        comment.delete(id,user);
    }
}
