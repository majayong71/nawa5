package org.example.nawa5.service;

import org.example.nawa5.domain.Banners;

import java.util.List;

public interface BannerService {
    /**
     * 모든 배너 조회
     **/
    List<Banners> gets();

    /**
     * 배너 수정
     **/
    void update(Long id, String imageUrl, int displayOrder);

    /**
     * 배너 삭제
     **/
    void delete(Long id);

}
