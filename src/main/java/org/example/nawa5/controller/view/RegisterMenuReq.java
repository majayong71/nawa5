package org.example.nawa5.controller.view;

import lombok.Getter;

@Getter
public class RegisterMenuReq {
    private Long restaurantId;
    private String name;
    private int price;
    private String description;
    private boolean isMain;
    private String imageUrl;

    public RegisterMenuReq(
            Long restaurantId, String name, int price, String description, boolean isMain,
            String imageUrl
    ){
        this.restaurantId = restaurantId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.isMain = isMain;
        this.imageUrl = imageUrl;
    }
}
