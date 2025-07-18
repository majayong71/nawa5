package org.example.nawa5.repository;

import org.example.nawa5.domain.Menu;
import org.example.nawa5.domain.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findByRestaurant(Restaurant restaurant);
}
