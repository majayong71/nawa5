package org.example.nawa5.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.nawa5.domain.*;
import org.example.nawa5.repository.PostRepository;
import org.example.nawa5.repository.UserRepository;
import org.example.nawa5.service.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    public void register(Long userId, PostCategory postCategory, String title, String content,
                         String imageUrl) {
        User user = userRepository.findById(userId).get();

        Post post = new Post(user, postCategory, title, content, imageUrl);

        postRepository.save(post);
    }

    @Override
    public List<Post> search(SearchCategory category, String keyword) {
        return switch (category) {
            case TITLE -> postRepository.searchByTitle(keyword, PostStatus.REGISTERED);
            case CONTENT -> postRepository.searchByContent(keyword, PostStatus.REGISTERED);
            case TITLE_CONTENT -> postRepository.searchByTitleOrContent(keyword, PostStatus.REGISTERED);
        };
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
    public void update(Long id, Long userId, PostCategory category, String title, String content, String imageUrl) {
        Post post = postRepository.findById(id).get();

        post.update(userId, title, category, content, imageUrl);
    }

    @Override
    public void delete(Long id, Long userId) {
        Post post = postRepository.findById(id).get();

        post.delete(userId);
    }
}
