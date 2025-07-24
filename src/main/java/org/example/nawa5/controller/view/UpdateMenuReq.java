package org.example.nawa5.controller.view;

import lombok.Getter;

@Getter
public class UpdateMenuReq {
    private final String name;
    private final int price;
    private final String description;
    private final boolean isMain;
    private final String imageUrl;

    public UpdateMenuReq(
            String name, int price, String description, boolean isMain, String imageUrl
    ){
        this.name = name;
        this.price = price;
        this.description = description;
        this.isMain = isMain;
        this.imageUrl = imageUrl;
    }
}
