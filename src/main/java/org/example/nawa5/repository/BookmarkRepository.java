package org.example.nawa5.repository;

import org.example.nawa5.domain.Bookmark;
import org.example.nawa5.domain.BookmarkStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    List<Bookmark> findBybookmarkStatus(BookmarkStatus status);
}
