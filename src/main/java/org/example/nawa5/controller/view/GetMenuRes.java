package org.example.nawa5.controller.view;

import lombok.Getter;
import org.example.nawa5.domain.Menu;

@Getter
public class GetMenuRes {
    private final MenuData menu;

    public GetMenuRes(Menu menu) {
        this.menu = new MenuData(
                menu.getName(), menu.getPrice(), menu.getDescription(), menu.isMain(),
                menu.getImageUrl()
        );
    }
}
