package org.example.nawa5.repository;

import org.example.nawa5.domain.Comment;
import org.example.nawa5.domain.CommentStatus;
import org.example.nawa5.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPostAndStatus(Post post, CommentStatus status);
}
