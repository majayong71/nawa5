package org.example.nawa5.controller.view;

import lombok.Getter;
import org.example.nawa5.domain.RestaurantCategory;

import java.time.LocalDateTime;

@Getter
public class UpdateRestaurantReq {
    private String name;
    private RestaurantCategory category;
    private String address;
    private LocalDateTime businessHours;
    private String phoneNumber;
    private String description;
    private String mainImageUrl;
    private boolean visible;

    public UpdateRestaurantReq(
            String name, RestaurantCategory category, String address, LocalDateTime businessHours,
            String phoneNumber, String description, String mainImageUrl, boolean visible
    ) {
        this.name = name;
        this.category = category;
        this.address = address;
        this.businessHours = businessHours;
        this.phoneNumber = phoneNumber;
        this.description = description;
        this.mainImageUrl = mainImageUrl;
        this.visible = visible;
    }
}
