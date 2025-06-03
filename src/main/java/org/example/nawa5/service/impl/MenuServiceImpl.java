package org.example.nawa5.service.impl;

import org.example.nawa5.domain.Menu;
import org.example.nawa5.service.MenuService;

import java.util.List;

public class MenuServiceImpl implements MenuService {

    @Override
    public void register(Long restaurantId, String name, int price, String description, boolean isMain, String imageUrl) {

    }

    @Override
    public List<Menu> getAll(Long id) {
        return List.of();
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
