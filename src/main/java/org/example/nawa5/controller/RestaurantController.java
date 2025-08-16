package org.example.nawa5.controller;

import lombok.RequiredArgsConstructor;
import org.example.nawa5.controller.view.*;
import org.example.nawa5.domain.Restaurant;
import org.example.nawa5.service.RestaurantService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurants")
public class RestaurantController {
    private final RestaurantService restaurantService;

    @PostMapping
    public void register(@RequestBody RegisterRestaurantReq req) {
        restaurantService.register(
                req.getName(), req.getCategory(), req.getAddress(), req.getBusinessHours(), req.getPhoneNumber(),
                req.getDescription(), req.getMainImageUrl()
        );
    }

    // 레스토랑 전체 조회
    @GetMapping
    public GetRestaurantsRes getAll() {
        List<Restaurant> restaurants = restaurantService.getAll();

        return new GetRestaurantsRes(restaurants);
    }

    //todo
    /** LocalTime ? String ? LocalDateTime ?
    startHour = 2024.01.01 12:10:00
    endHour = 2024.01.01 24:00:00

    24년 1월 1일 12시 10분 ~ 24년 1월 1일 24시 00분
     **/

    // 레스토랑 조회
    @GetMapping("/{id}")
    public GetRestaurantRes get(@PathVariable Long id) {
        Restaurant restaurant = restaurantService.get(id);

        return new GetRestaurantRes(restaurant);
    }

    @PostMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody UpdateRestaurantReq req) {
        restaurantService.update(
                id, req.getName(), req.getCategory(), req.getAddress(), req.getBusinessHours(),
                req.getPhoneNumber(), req.getDescription(), req.getMainImageUrl(), req.isVisible()
        );
    }

    @PostMapping("/{id}/delete")
    public void delete(@PathVariable Long id) {
        restaurantService.delete(id);
    }
}
