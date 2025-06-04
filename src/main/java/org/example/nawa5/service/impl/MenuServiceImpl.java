package org.example.nawa5.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.nawa5.domain.Menu;
import org.example.nawa5.domain.Restaurant;
import org.example.nawa5.repository.MenuRepository;
import org.example.nawa5.repository.RestaurantRepository;
import org.example.nawa5.service.MenuService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public void register(Long restaurantId, String name, int price, String description, boolean isMain, String imageUrl) {

    }

    @Override
    public List<Menu> getAll(Long id) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(id);

        return menuRepository.findByRestaurant(restaurant.get());
    }

    @Override
    public Menu get(Long id) {
        return null;
    }

    @Override
    public void update(Long id, String name, int price, String description, boolean isMain, String imageUrl) {

    }

    @Override
    public void delete(Long id) {

    }
}
