package org.example.nawa5.service;

import org.example.nawa5.domain.Restaurant;
import org.example.nawa5.domain.RestaurantCategory;

import java.util.List;

public interface RestaurantService {

    /**
     * 레스토랑 등록 (관리자 or 크롤링 후 수동 등록 )
     **/
    void register(
            String name, RestaurantCategory category, String address, String businessHours,
            String phoneNumber, String description, String mainImageUrl
    );

    /**
     * 모든 레스토랑 조회
     **/
    List<Restaurant> getAll();

    /**
     * 레스토랑 상세 조회 - 아이디
     **/
    Restaurant get(Long id);

    /**
     * 레스토랑 조회 - 카테고리
     **/
    List<Restaurant> get(RestaurantCategory category);

    /**
     * 레스토랑 정보 수정
     **/
    void update(
            Long id, String name, RestaurantCategory category, String address, String businessHours,
            String phoneNumber, String description, String mainImageUrl, Boolean visible
    );

    /**
     * 레스토랑 삭제
     **/
    void delete(Long id);
}
