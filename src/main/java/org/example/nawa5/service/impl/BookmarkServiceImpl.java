package org.example.nawa5.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.nawa5.domain.Bookmark;
import org.example.nawa5.domain.BookmarkStatus;
import org.example.nawa5.domain.Post;
import org.example.nawa5.domain.User;
import org.example.nawa5.repository.BookmarkRepository;
import org.example.nawa5.repository.PostRepository;
import org.example.nawa5.repository.UserRepository;
import org.example.nawa5.service.BookmarkService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class BookmarkServiceImpl implements BookmarkService {

    private final BookmarkRepository bookmarkRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Override
    public List<Bookmark> gets() {
        return bookmarkRepository.findBybookmarkStatus(BookmarkStatus.REGISTERED);
    }

    @Override
    public void register(Long userId, Long postId) {
        User user = userRepository.findById(userId).get();
        Post post = postRepository.findById(postId).get();

        Bookmark bookmark = new Bookmark(user, post);

        bookmarkRepository.save(bookmark);
    }

    @Override
    public void delete(Long id) {
        Bookmark bookmark = bookmarkRepository.findById(id).get();

        bookmark.delete();
    }
}
