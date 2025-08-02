package org.example.nawa5.controller.view;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class MenuData {
    private final String name;
    private final int price;
    private final String description;
    private final boolean isMain;
    private final String imageUrl;
}
