package org.example.nawa5.controller.view;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.nawa5.domain.RestaurantCategory;

@RequiredArgsConstructor
@Getter
public class RestaurantData {
    private final String name;
    private final RestaurantCategory category;
    private final String address;
    private final String businessHours;
    private final String phoneNumber;
    private final String description;
    private final String mainImageUrl;
}
