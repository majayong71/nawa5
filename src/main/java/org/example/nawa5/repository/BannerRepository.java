package org.example.nawa5.repository;

import org.example.nawa5.domain.Banner;
import org.example.nawa5.domain.BannerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BannerRepository extends JpaRepository<Banner, Long> {

    @Query
            ("""
                SELECT b
                FROM Banner b
                WHERE b.status = :status AND b.isVisible = :isVisible
                ORDER BY b.displayOrder 
            """)
    List<Banner> findBanners(BannerStatus status, boolean isVisible);
}
