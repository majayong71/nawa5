package org.example.nawa5.controller.view;

import lombok.Getter;

import java.util.List;

@Getter
public class DeleteRestaurantsReq {
    private List<Long> ids;

    public DeleteRestaurantsReq(List<Long> ids) {
        this.ids = ids;
    }
}
