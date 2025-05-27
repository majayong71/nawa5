package org.example.nawa5.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.nawa5.domain.Restaurant;
import org.example.nawa5.repository.RestaurantRepository;
import org.example.nawa5.service.RestaurantService;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return List.of();

    }//Todo: 레스토랑 서비스 로직 구현

    @Override
    public Restaurant getRestaurantById(Long restaurantId) {
        return null;
    }

    @Override
    public List<Restaurant> getRestaurantByCategory(String category) {
        return List.of();
    }

    @Override
    public Restaurant updateRestaurant(Long restaurantId, Restaurant restaurant) {
        return null;
    }

    @Override
    public void deleteRestaurant(Long restaurantId) {

    }

    @Override
    public List<Restaurant> crawlingRestaurantFromNaverMap() {
        return List.of();
    }

    @Override
    public List<Restaurant> crawlingRestaurantFromGoogleMap() {
        return List.of();
    }

    @Override
    public List<Restaurant> crawlingRestaurantFromInstagram() {
        return List.of();
    }
}
