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

@Service
@Transactional
@RequiredArgsConstructor
public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;
    private final RestaurantRepository restaurantRepository;

    @Override
    public void register(Long restaurantId, String name, int price, String description, boolean isMain, String imageUrl) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();

        Menu menu = new Menu(restaurant, name, price, description, isMain, imageUrl);

        menuRepository.save(menu);
    }

    @Override
    public List<Menu> getAll(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId).get();

        return menuRepository.findByRestaurant(restaurant);
    }

    @Override
    public Menu get(Long id) {
        return menuRepository.findById(id).get();
    }

    @Override
    public void update(Long id, String name, int price, String description, boolean isMain, String imageUrl) {
        Menu menu = menuRepository.findById(id).get();

        menu.update(name, price, description, isMain, imageUrl);
    }

    @Override
    public void delete(Long id) {
        Menu menu = menuRepository.findById(id).get();

        /** 도메인 메서드 delete 를 사용해서 상태를 visible = false 로 변경 **/
        menu.delete();
    }
}
