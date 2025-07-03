package org.example.nawa5.controller.view;

import lombok.Getter;
import org.example.nawa5.domain.RestaurantCategory;

import java.time.LocalDateTime;

@Getter
public class GetRestaurantRes {
    private final String name;
    private final RestaurantCategory category;
    private final String address;
    private final LocalDateTime businessHours;
    private final String phoneNumber;
    private final String description;
    private final String mainImageUrl;

    public GetRestaurantRes(
            String name, RestaurantCategory category, String address, LocalDateTime businessHours,
            String phoneNumber, String description, String mainImageUrl
    ) {
        this.name = name;
        this.category = category;
        this.address = address;
        this.businessHours = businessHours;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.mainImageUrl = mainImageUrl;
    }
}
