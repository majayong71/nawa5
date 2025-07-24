package org.example.nawa5.controller.view;

import lombok.Getter;
import org.example.nawa5.domain.Restaurant;

import java.util.List;
import java.util.stream.Collectors;

// EntityData 는 다건에서만 사용한다.
@Getter
public class GetRestaurantsRes {
    private final List<RestaurantData> restaurants;

    public GetRestaurantsRes(List<Restaurant> restaurants) {
        this.restaurants = restaurants.stream().map(restaurant -> new RestaurantData(
                        restaurant.getName(), restaurant.getCategory(), restaurant.getAddress(), restaurant.getBusinessHours(),
                        restaurant.getPhoneNumber(), restaurant.getDescription(), restaurant.getMainImageUrl()
                )
            ).collect(Collectors.toList());
    }
}
