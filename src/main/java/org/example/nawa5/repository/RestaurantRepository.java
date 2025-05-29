package org.example.nawa5.repository;

import org.example.nawa5.domain.Restaurant;
import org.example.nawa5.domain.RestaurantCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    List<Restaurant> findByCategory(RestaurantCategory category);
}

