package org.example.nawa5.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.nawa5.domain.Restaurant;
import org.example.nawa5.domain.Review;
import org.example.nawa5.domain.User;
import org.example.nawa5.repository.RestaurantRepository;
import org.example.nawa5.repository.ReviewRepository;
import org.example.nawa5.repository.UserRepository;
import org.example.nawa5.service.ReviewService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final RestaurantRepository restaurantRepository;
    private final UserRepository userRepository;


    @Override
    public void register(
            Long userId, Long restaurantId, String content,
            int rating, String imageUrl
    ) {
        User user = userRepository.findById(userId).get();
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();

        Review review = new Review(user, restaurant, content, imageUrl, rating);
        reviewRepository.save(review);
    }

    @Override
    public List<Review> get(Long id) {
        return reviewRepository.findByRestaurantId(id);
    }

    @Override
    public void update(Long id, String content, int rating, String imageUrl) {
        Review review = reviewRepository.findById(id).get();

        review.update(content,imageUrl,rating);
    }

    @Override
    public void delete(Long id) {
        Review review = reviewRepository.findById(id).get();

        review.delete();
    }
}
