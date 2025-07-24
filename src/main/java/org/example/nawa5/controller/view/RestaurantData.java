package org.example.nawa5.controller.view;

import lombok.Getter;
import org.example.nawa5.domain.RestaurantCategory;

@Getter
public class RestaurantData {
    private final String name;
    private final RestaurantCategory category;
    private final String address;
    private final String businessHours;
    private final String phoneNumber;
    private final String description;
    private final String mainImageUrl;

    public RestaurantData(
            String name, RestaurantCategory category, String address, String businessHours, String phoneNumber,
            String description, String mainImageUrl
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
