package org.example.nawa5.controller.view;

import lombok.Getter;
import org.example.nawa5.domain.Restaurant;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class GetRestaurantsRes {
    private final List<GetRestaurantRes> restaurants;

    public GetRestaurantsRes(List<Restaurant> restaurantList) {
        this.restaurants = restaurantList.stream().map(restaurant -> new GetRestaurantRes(
                        restaurant.getName(), restaurant.getCategory(), restaurant.getAddress(), restaurant.getBusinessHours(),
                        restaurant.getPhoneNumber(), restaurant.getDescription(), restaurant.getMainImageUrl()
                )
        ).collect(Collectors.toList());
    }
}
