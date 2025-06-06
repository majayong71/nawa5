package org.example.nawa5.service;

import org.example.nawa5.domain.Menu;

import java.util.List;

public interface MenuService {

    /** 메뉴 등록 **/
    void register(Long restaurantId, String name, int price, String description, boolean isMain, String imageUrl);

    /** 모든 메뉴 조회 **/
    List<Menu> getAll(Long restaurantId);

    /** 메뉴 상세 조회 **/
    Menu get (Long id);

    /** 메뉴 수정 **/
    void update(Long id, String name, int price, String description, boolean isMain, String imageUrl);

    /** 메뉴 삭제 **/
    void delete(Long id);
}
