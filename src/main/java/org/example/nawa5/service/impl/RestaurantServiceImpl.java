package org.example.nawa5.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.nawa5.domain.Restaurant;
import org.example.nawa5.repository.RestaurantRepository;
import org.example.nawa5.service.RestaurantService;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@Service
@Transactional
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return restaurants;

    }

    @Override
    public Restaurant getRestaurantById(Long restaurantId) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);

        /** IllegalArgumentException = 잘못된 인자 예외처리.   **/
        if(restaurant.isPresent()) {
            return restaurant.get();
        } else {
            throw new IllegalArgumentException("해당 레스토랑은 존재하지 않습니다.");
        }
    }

    @Override
    public List<Restaurant> getRestaurantByCategory(String category) {
//        List<Restaurant> restaurants = restaurantRepository.findByCategory(category);
//
//        return restaurants;
        return null;
    }

    @Override
    public Restaurant updateRestaurant(Long restaurantId, Restaurant restaurant) {
        Optional<Restaurant> restaurantOptional = restaurantRepository.findById(restaurantId);
        if (restaurantOptional.isPresent()) {
            Restaurant existingRestaurant = restaurantOptional.get();
            existingRestaurant.setName(restaurant.getName());
            existingRestaurant.setCategory(restaurant.getCategory());
            existingRestaurant.setAddress(restaurant.getAddress());
            existingRestaurant.setBusinessHours(restaurant.getBusinessHours());
            existingRestaurant.setPhoneNumber(restaurant.getPhoneNumber());
            existingRestaurant.setDescription(restaurant.getDescription());
            existingRestaurant.setMainImageUrl(restaurant.getMainImageUrl());
            return restaurantRepository.save(existingRestaurant);

        } else {
            throw new IllegalArgumentException("해당 레스토랑은 존재하지 않습니다.");
        }
    }

    @Override
    public void deleteRestaurant(Long restaurantId) {
        Optional<Restaurant> restaurant = restaurantRepository.findById(restaurantId);
        if (restaurant.isPresent()) {
            restaurant.get().setVisible(false);
        } else {
            throw new IllegalArgumentException("해당 레스토랑은 존재하지 않습니다.");
        }

    }

    @Override
    public List<Restaurant> crawlingRestaurantFromNaverMap() {
        String iframeUrl = "https://pcmap.place.naver.com/place/list?query=%ED%99%8D%EB%8C%80%EC%9E%85%EA%B5%AC%EC%97%AD%EB%A7%9B%EC%A7%91&x=126.804843&y=37.398715&clientX=126.804843&clientY=37.398715&display=70&ts=1716879983079&mapUrl=https%3A%2F%2Fmap.naver.com%2Fp%2Fsearch%2F%ED%99%8D%EB%8C%80%EC%9E%85%EA%B5%AC%EC%97%AD%EB%A7%9B%EC%A7%91";

        try {
            // jsoup 을 사용해 iframe 페이지 가져오기
            Document iframeDoc = Jsoup.connect(iframeUrl).get();

            // 지정된 CSS 쿼리로 요소들 가져오기
            String query = "span.place_bluelink.TYaxT";
            Elements elements = iframeDoc.select(query);
            for (Element element : elements) {
                System.out.println(element.text());
            }

            // iframe 페이지 제목 출력
            String iframeTitle = iframeDoc.title();
            System.out.println("Iframe page title is: " + iframeTitle);

            // 현재 URL 출력
            System.out.println("Current URL: " + iframeUrl);

            } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        return List.of();
    }

    @Override
    public List<Restaurant> crawlingRestaurantFromGoogleMap() {
        return List.of();
    }

    @Override
    public List<Restaurant> crawlingRestaurantFromInstagram() {
        return List.of();
    }
}
