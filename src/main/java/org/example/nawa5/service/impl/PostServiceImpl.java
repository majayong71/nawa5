package org.example.nawa5.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.nawa5.domain.Post;
import org.example.nawa5.domain.PostCategory;
import org.example.nawa5.domain.User;
import org.example.nawa5.repository.PostRepository;
import org.example.nawa5.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    @Override
    public void register(User user, PostCategory postCategory, String title, String content,
                         String imageUrl) {
        Post post = new Post(user, postCategory, title, content, imageUrl);
        postRepository.save(post);
    }

    @Override
    public List<Post> gets() {
        return postRepository.findAll();
    }

    @Override
    public Post get(Long id) {
        return postRepository.findById(id).get();
    }

    @Override
    public List<Post> getByUserId(Long userId) {
        return postRepository.findByUserId(userId);
    }

    @Override
    public List<Post> getByCategory(PostCategory category) {
        return postRepository.findByCategory(category);
    }

    @Override
    public void update(Long id, PostCategory category, String title, String content, String imageUrl) {
        Post post = postRepository.findById(id).get();

        post.update(id, title, category, content, imageUrl);
    }

    @Override
    public void delete(Long id, Long userId) {
        Post post = postRepository.findById(id).get();

        post.delete(userId);
    }
}
