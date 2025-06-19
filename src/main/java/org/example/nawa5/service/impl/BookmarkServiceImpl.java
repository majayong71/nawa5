package org.example.nawa5.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.nawa5.domain.Bookmark;
import org.example.nawa5.domain.Post;
import org.example.nawa5.domain.User;
import org.example.nawa5.repository.BookmarkRepository;
import org.example.nawa5.service.BookmarkService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class BookmarkServiceImpl implements BookmarkService {

    private final BookmarkRepository bookmarkRepository;

    @Override
    public void register(User user, Post post) {
        Bookmark bookmark = new Bookmark(user,post);
        bookmarkRepository.save(bookmark);
    }

    @Override
    public List<Bookmark> gets() {
        return bookmarkRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        Bookmark bookmark = bookmarkRepository.findById(id).get();
        bookmark.delete();
    }
}
