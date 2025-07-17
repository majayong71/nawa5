package org.example.nawa5.controller;

import lombok.RequiredArgsConstructor;
import org.example.nawa5.controller.view.GetMenuRes;
import org.example.nawa5.controller.view.GetMenusRes;
import org.example.nawa5.controller.view.RegisterMenuReq;
import org.example.nawa5.domain.Menu;
import org.example.nawa5.service.MenuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menus")
public class MenuController {
    private final MenuService menuService;

    @PostMapping
    public void register(@RequestBody RegisterMenuReq req) {
        menuService.register(
                req.getRestaurantId(), req.getName(), req.getPrice(), req.getDescription(), req.isMain(),
                req.getImageUrl()
        );
    }

    // 메뉴 전체 조회
    @GetMapping("/{restaurantId}")
    public GetMenusRes getAll(@PathVariable Long restaurantId) {
        List<Menu> menus = menuService.getAll(restaurantId);

        return new GetMenusRes(menus);
    }

    // 메뉴 단건 조회
    @GetMapping("/{menuId}")
    public GetMenuRes get (@PathVariable Long menuId) {
        Menu menu = menuService.get(menuId);

        return new GetMenuRes(menu.getName(), menu.getPrice(), menu.getDescription(), menu.isMain(), menu.getImageUrl());
    }
}
