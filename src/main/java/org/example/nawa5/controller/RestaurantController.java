package org.example.nawa5.controller;

import lombok.RequiredArgsConstructor;
import org.example.nawa5.controller.view.GetRestaurantRes;
import org.example.nawa5.controller.view.RegisterRestaurantReq;
import org.example.nawa5.domain.Restaurant;
import org.example.nawa5.service.RestaurantService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping
    public void register(@RequestBody RegisterRestaurantReq req) {
        restaurantService.register(
                req.getName(),
                req.getCategory(),
                req.getAddress(),
                req.getBusinessHours(),
                req.getPhoneNumber(),
                req.getDescription(),
                req.getMainImageUrl()
        );
    }

    // 레스토랑 전체 조회
    // 반환타입이 Entity면 안되기에 DTO로 바꿔야하는데..코드완성 구성이 안된다.
    @GetMapping
    public List<GetRestaurantRes> getAll() {
        List<Restaurant> restaurants = restaurantService.getAll();
        List<GetRestaurantRes> responses = new ArrayList<>();

        for (Restaurant restaurant : restaurants) {
            GetRestaurantRes res = new GetRestaurantRes(
                    restaurant.getName(),
                    restaurant.getCategory(),
                    restaurant.getAddress(),
                    restaurant.getBusinessHours(),
                    restaurant.getPhoneNumber(),
                    restaurant.getDescription(),
                    restaurant.getMainImageUrl()
            );
            responses.add(res);
        }
        return responses;
    }
    @GetMapping("/{id}")
    public GetRestaurantRes get(@PathVariable Long id) {
        Restaurant restaurant = restaurantService.get(id);
        return new GetRestaurantRes(
                restaurant.getName(),
                restaurant.getCategory(),
                restaurant.getAddress(),
                restaurant.getBusinessHours(),
                restaurant.getPhoneNumber(),
                restaurant.getDescription(),
                restaurant.getMainImageUrl()
        );
    }


}
