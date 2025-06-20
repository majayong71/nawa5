package org.example.nawa5.repository;

import org.example.nawa5.domain.HotPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface HotPostRepository extends JpaRepository<HotPost, Long> {
    List<HotPost> findByDateOrderByRank(LocalDate date);
}
