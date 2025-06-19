package org.example.nawa5.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.nawa5.domain.HotPost;
import org.example.nawa5.domain.HotPostCategory;
import org.example.nawa5.domain.Post;
import org.example.nawa5.repository.HotPostRepository;
import org.example.nawa5.repository.PostRepository;
import org.example.nawa5.service.HotPostService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class HotPostServiceImpl implements HotPostService {

    private final HotPostRepository hotPostRepository;
    private final PostRepository postRepository;

    @Override
    public void register(Long postId, LocalDate date, int rank, HotPostCategory category) {
        Post post = postRepository.findById(postId).get();

        HotPost hotPost = new HotPost(post, date, rank, category);

        hotPostRepository.save(hotPost);
    }

    @Override
    public List<HotPost> gets() {
        return hotPostRepository.findAll();
    }

    @Override
    public void update(Long id, Post post, LocalDate date, int rank, HotPostCategory hotPostCategory) {
        HotPost hotPost = hotPostRepository.findById(id).get();

        hotPost.update(post, date, rank, hotPostCategory);
    }

    @Override
    public void delete(Long id) {
        HotPost hotPost = hotPostRepository.findById(id).get();

        hotPost.delete();
    }
}
