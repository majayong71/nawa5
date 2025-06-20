package org.example.nawa5.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.nawa5.domain.Comment;
import org.example.nawa5.domain.CommentStatus;
import org.example.nawa5.domain.Post;
import org.example.nawa5.domain.User;
import org.example.nawa5.repository.CommentRepository;
import org.example.nawa5.repository.PostRepository;
import org.example.nawa5.repository.UserRepository;
import org.example.nawa5.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Override
    public void register(Long userId, Long postId, String content) {
        User user = userRepository.findById(userId).get();
        Post post = postRepository.findById(postId).get();

        Comment comment = new Comment(user, post, content);

        commentRepository.save(comment);
    }

    @Override
    public List<Comment> gets(Long postId) {
        Post post = postRepository.findById(postId).get();

        return commentRepository.findByPostAndStatus(post, CommentStatus.REGISTERED);
    }

    @Override
    public void update(Long id, String content) {
        Comment comment = commentRepository.findById(id).get();

        comment.update(content);
    }

    @Override
    public void delete(Long id) {
        Comment comment = commentRepository.findById(id).get();

        comment.delete();
    }
}
