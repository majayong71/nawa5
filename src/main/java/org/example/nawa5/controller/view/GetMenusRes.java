package org.example.nawa5.controller.view;

import lombok.Getter;
import org.example.nawa5.domain.Menu;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class GetMenusRes {
    private final List<MenuData> menus;

    public GetMenusRes(List<Menu> menus) {
        this.menus = menus.stream().map(menu -> new MenuData(
                    menu.getName(), menu.getPrice(), menu.getDescription(), menu.isMain(),
                    menu.getImageUrl()
                )
            ).collect(Collectors.toList());
    }
}
