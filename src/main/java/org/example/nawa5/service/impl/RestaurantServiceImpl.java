package org.example.nawa5.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.nawa5.domain.Restaurant;
import org.example.nawa5.domain.RestaurantCategory;
import org.example.nawa5.repository.RestaurantRepository;
import org.example.nawa5.service.RestaurantService;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Override
    public void register(
            String name, RestaurantCategory category, String address, LocalDateTime businessHours,
            String phoneNumber, String description, String mainImageUrl
    ) {
        Restaurant restaurant = new Restaurant(
                name, category, address, businessHours, phoneNumber, description, mainImageUrl
        );

        restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> getAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant get(Long id) {
        return restaurantRepository.findById(id).get();
    }

    @Override
    public List<Restaurant> get(RestaurantCategory category) {
        return restaurantRepository.findByCategory(category);
    }

    @Override
    public void update(
            Long id, String name, RestaurantCategory category, String address, LocalDateTime businessHours,
            String phoneNumber, String description, String mainImageUrl, Boolean visible
    ) {
        Restaurant restaurant = restaurantRepository.findById(id).get();

        restaurant.update(
                name, category, address, businessHours, phoneNumber, description, mainImageUrl, visible
        );
    }

    @Override
    public void delete(Long id) {
        Restaurant restaurant = restaurantRepository.findById(id).get();

        restaurant.delete();
    }
//    @Override
//    public List<Restaurant> crawlingRestaurantFromNaverMap() {
//        String iframeUrl = "https://pcmap.place.naver.com/place/list?query=%ED%99%8D%EB%8C%80%EC%9E%85%EA%B5%AC%EC%97%AD%EB%A7%9B%EC%A7%91&x=126.804843&y=37.398715&clientX=126.804843&clientY=37.398715&display=70&ts=1716879983079&mapUrl=https%3A%2F%2Fmap.naver.com%2Fp%2Fsearch%2F%ED%99%8D%EB%8C%80%EC%9E%85%EA%B5%AC%EC%97%AD%EB%A7%9B%EC%A7%91";
//
//        try {
//            // jsoup 을 사용해 iframe 페이지 가져오기
//            Document iframeDoc = Jsoup.connect(iframeUrl).get();
//
//            // 지정된 CSS 쿼리로 요소들 가져오기
//            String query = "span.place_bluelink.TYaxT";
//            Elements elements = iframeDoc.select(query);
//            for (Element element : elements) {
//                System.out.println(element.text());
//            }
//
//            // iframe 페이지 제목 출력
//            String iframeTitle = iframeDoc.title();
//            System.out.println("Iframe page title is: " + iframeTitle);
//
//            // 현재 URL 출력
//            System.out.println("Current URL: " + iframeUrl);
//
//        } catch (Exception e) {
//            System.out.println("An error occurred: " + e.getMessage());
//        }
//
//        return List.of();
//    }
//
//    @Override
//    public List<Restaurant> crawlingRestaurantFromGoogleMap() {
//        return List.of();
//    }
//
//    @Override
//    public List<Restaurant> crawlingRestaurantFromInstagram() {
//        return List.of();
//    }
}
