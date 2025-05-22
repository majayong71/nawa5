package org.example.nawa5.service;

import org.example.nawa5.domain.Restaurant;

import java.util.List;

public interface RestaurantService {

    /** 레스토랑 생성 (관리자 or 크롤링 후 수동 등록 ) **/
    Restaurant createRestaurant (Restaurant restaurant);

    /** 모든 레스토랑 조회 **/
    List<Restaurant> getAllRestaurants();

    /** 레스토랑 상세 조회 - 아이디 **/
    Restaurant getRestaurantById(Long restaurnatId);

    /** 레스토랑 상세 조회 - 카테고리 **/
    List<Restaurant> getRestaurantByCategory(String category);

    /** 레스토랑 정보 수정 **/
    Restaurant updateRestaurant (Long restaurantId, Restaurant restaurant);

    /** 레스토랑 삭제 **/
    void deleteRestaurant (Long restaurantId);


    //추후 보완 필요
    /** Crawling : 네이버맵 레스토랑 크롤링 **/
    List<Restaurant> crawlingRestaurantFromNaverMap();

    /** Crawling : 구글맵 레스토랑 크롤링 **/
    List<Restaurant> crawlingRestaurantFromGoogleMap();

    /** Crawling : 인스타그램 레스토랑 크롤링 **/
    List<Restaurant> crawlingRestaurantFromInstagram();
}
