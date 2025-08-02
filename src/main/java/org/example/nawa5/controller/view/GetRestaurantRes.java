package org.example.nawa5.controller.view;

import lombok.Getter;
import org.example.nawa5.domain.Restaurant;
import org.example.nawa5.domain.RestaurantCategory;

@Getter
public class GetRestaurantRes {
    private final String name;
    private final RestaurantCategory category;
    private final String address;
    private final String businessHours;
    private final String phoneNumber;
    private final String description;
    private final String mainImageUrl;

    public GetRestaurantRes(Restaurant restaurant) {
        this.name = restaurant.getName();
        this.category = restaurant.getCategory();
        this.address = restaurant.getAddress();
        this.businessHours = restaurant.getBusinessHours();
        this.phoneNumber = restaurant.getPhoneNumber();
        this.description = restaurant.getDescription();
        this.mainImageUrl = restaurant.getMainImageUrl();
    }
}
