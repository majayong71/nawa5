package org.example.nawa5.repository;

import org.example.nawa5.domain.Post;
import org.example.nawa5.domain.PostCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findById(Long id);

    List<Post> findByUserId(Long userId);

    List<Post> findByCategory(PostCategory category);
}
