package org.example.nawa5.service;

import org.example.nawa5.domain.Review;

import java.util.List;

public interface ReviewService {

    /** 리뷰 등록 **/
    void register(Long userId, Long restaurantId, String content, int rating, String imageUrl);

    /** 리뷰 조회 **/
    List<Review> get(Long id);

    /** 리뷰 수정 **/
    void update(Long id, String content, int rating, String imageUrl);

    /** 리뷰 삭제 **/
    void delete(Long id);
}
