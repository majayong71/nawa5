package org.example.nawa5.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.nawa5.domain.Restaurant;
import org.example.nawa5.repository.RestaurantRepository;
import org.example.nawa5.service.RestaurantService;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
        return restaurants;

    }

    @Override
    public Restaurant getRestaurantById(Long restaurantId) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);

        /** IllegalArgumentException = 잘못된 인자 예외처리.   **/
        if(restaurant.isPresent()) {
            return restaurant.get();
        } else {
            throw new IllegalArgumentException("해당 레스토랑은 존재하지 않습니다.");
        }
    }

    @Override
    public List<Restaurant> getRestaurantByCategory(String category) {
//        List<Restaurant> restaurants = restaurantRepository.findByCategory(category);
//
//        return restaurants;
        return null;
    }

    @Override
    public Restaurant updateRestaurant(Long restaurantId, Restaurant restaurant) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(restaurantId);
        if (restaurantOptional.isPresent()) {
            Restaurant existingRestaurant = restaurantOptional.get();
            existingRestaurant.setName(restaurant.getName());
            existingRestaurant.setCategory(restaurant.getCategory());
            existingRestaurant.setAddress(restaurant.getAddress());
            existingRestaurant.setBusinessHours(restaurant.getBusinessHours());
            existingRestaurant.setPhoneNumber(restaurant.getPhoneNumber());
            existingRestaurant.setDescription(restaurant.getDescription());
            existingRestaurant.setMainImageUrl(restaurant.getMainImageUrl());
            return restaurantRepository.save(existingRestaurant);

        } else {
            throw new IllegalArgumentException("해당 레스토랑은 존재하지 않습니다.");
        }
    }

    @Override
    public void deleteRestaurant(Long restaurantId) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        if (restaurant.isPresent()) {
            restaurant.get().setVisible(false);
        } else {
            throw new IllegalArgumentException("해당 레스토랑은 존재하지 않습니다.");
        }

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
