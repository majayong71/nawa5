package org.example.nawa5.service.impl;

import org.example.nawa5.domain.Restaurant;
import org.example.nawa5.service.RestaurantService;

import java.util.List;

public class RestaurantServiceImpl implements RestaurantService {

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        return null;
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return List.of();
    }

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
