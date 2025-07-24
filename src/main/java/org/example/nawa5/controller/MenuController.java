package org.example.nawa5.controller;

import lombok.RequiredArgsConstructor;
import org.example.nawa5.controller.view.GetMenuRes;
import org.example.nawa5.controller.view.GetMenusRes;
import org.example.nawa5.controller.view.RegisterMenuReq;
import org.example.nawa5.controller.view.UpdateMenuReq;
import org.example.nawa5.domain.Menu;
import org.example.nawa5.service.MenuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/menus")
public class MenuController {
    private final MenuService menuService;

    // 메뉴 등록
    @PostMapping
    public void register(@RequestBody RegisterMenuReq req) {
        menuService.register(
                req.getRestaurantId(), req.getName(), req.getPrice(), req.getDescription(), req.isMain(),
                req.getImageUrl()
        );
    }

    // 메뉴 전체 조회 [ 레스토랑별 전체 메뉴 ]
    @GetMapping("/restaurant/{restaurantId}")
    public GetMenusRes getAll(@PathVariable Long restaurantId) {
        List<Menu> menus = menuService.getAll(restaurantId);

        return new GetMenusRes(menus);
    }

    // 메뉴 단건 조회
    @GetMapping("/{menuId}")
    public GetMenuRes get(@PathVariable Long menuId) {
        Menu menu = menuService.get(menuId);

        return new GetMenuRes(menu);
    }

    // 메뉴 수정
    @PostMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody UpdateMenuReq req) {
        menuService.update(id, req.getName(), req.getPrice(), req.getDescription(), req.isMain(), req.getImageUrl());
    }

    // 메뉴 삭제
    @PostMapping("/{id}/delete")
    public void delete(@PathVariable Long id) {
        menuService.delete(id);
    }
}
